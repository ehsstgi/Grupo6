/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sistemarodoviario.AssentoSessionBeanRemote;
import sistemarodoviario.ClienteSessionBeanRemote;
import sistemarodoviario.OnibusSessionBeanRemote;
import sistemarodoviario.ViagemSessionBeanRemote;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "ViagemServlet", urlPatterns = {"/ViagemServlet"})
public class ViagemServlet extends HttpServlet {

    @EJB
    OnibusSessionBeanRemote beanOnibus;
    @EJB
    AssentoSessionBeanRemote beanAssento;
    @EJB
    ViagemSessionBeanRemote beanViagem;
    @EJB
    ClienteSessionBeanRemote beanCliente;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String button1_form = request.getParameter("verificaAssentoOnibus");
        String button2_form = request.getParameter("selecionaAssento");
        String usuarioAtivo = (String) session.getAttribute("nome");
        String assentoDisponibilidade = request.getParameter("assentoOnibus");

        if ("Verificar Disponibilidade".equals(button1_form)) {

            Trajeto trajeto = (Trajeto) session.getAttribute("trajeto");
            long id_trajeto = beanOnibus.findIDOnibus(trajeto.getId());
            if (id_trajeto != -1) {
                Onibus o = beanOnibus.recebeOnibusPorID((long) id_trajeto);
                List valores = o.getAssento();
                session.setAttribute("valores", valores);
                response.sendRedirect("viagem.jsp");
            } else {
                session.setAttribute("validaCompraeAssento", "Onibus não encontrado, volte e procure outro trajeto que esteja disponivel");
                response.sendRedirect("viagem.jsp");


            }
        }


        if ("OK".equals(button2_form)) {
            if (usuarioAtivo != null) {
                long id_assento = Long.parseLong(assentoDisponibilidade);
                Assento assento = beanAssento.findAssento(id_assento);
                if (assento.isDisponibilidadeAssento()) {
                    session.setAttribute("validaCompraeAssento", "Assento " + assento.getId() + " já está reservado... ");
                    response.sendRedirect("viagem.jsp");
                } else {
                    assento.setDisponibilidadeAssento(true);
                    beanAssento.salvar(assento);
                    long id_cliente = beanCliente.findIDCliente(usuarioAtivo);
                    Cliente cliente = beanCliente.recebeClientePorID(id_cliente);
                    Trajeto trajeto = (Trajeto) session.getAttribute("trajeto");
                    Onibus onibus = beanOnibus.recebeOnibusPorID((long) 1);
                    Viagem viagem = new Viagem(trajeto, onibus, assento, cliente);
                    beanViagem.salvar(viagem);


                    long id_viagem = beanViagem.findIDViagem(id_cliente, trajeto.getId(), onibus.getId(), assento.getId());

                    Viagem v = beanViagem.recebeViagemPorID(id_viagem);
                    session.setAttribute("validaCompraeAssento", "Viagem reservada com sucesso ... ");
                    session.setAttribute("viagem", v);
                    response.sendRedirect("viagem2.jsp");
                }
            } else {
                session.setAttribute("nome", null);
                response.sendRedirect("home.jsp");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);


    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
