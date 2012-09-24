/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sistemarodoviario.CidadeSessionBeanRemote;
import sistemarodoviario.ClienteSessionBeanRemote;
import sistemarodoviario.EstadoSessionBeanRemote;
import sistemarodoviario.jpa.Cidade;
import sistemarodoviario.jpa.Cliente;
import sistemarodoviario.jpa.Estado;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @EJB
    ClienteSessionBeanRemote bean;
    @EJB
    CidadeSessionBeanRemote beanCidade;
    @EJB
    EstadoSessionBeanRemote beanEstado;

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

        /*
         * TODO output your page here. You may use following sample code.
         */
        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
        String nomeCliente_form = request.getParameter("nomeCliente");
        String cpfCliente_form = request.getParameter("cpfCliente");
        String usuarioCliente_form = request.getParameter("usuarioCliente");
        String senhaCliente_form = request.getParameter("senhaCliente");
        String datanascCliente_form = request.getParameter("datanascCliente");
        String rgCliente_form = request.getParameter("rgCliente");
        String enderecoCliente_form = request.getParameter("enderecoCliente");
        String complementoEnd_form = request.getParameter("complementoEnd");
        String cidadeCliente_form = request.getParameter("cidadeCliente");
        String estadoCliente_form = request.getParameter("estadoCliente");
        String telCliente_form = request.getParameter("telCliente");
        String celCliente_form = request.getParameter("celCliente");
        String emailCliente_form = request.getParameter("emailCliente");
        String cartaoCliente_form = request.getParameter("cartaoCliente");
        String button_form = request.getParameter("cadastraClienteButton");

        boolean result;

        if ("Cadastrar".equals(button_form)) {
            /*
             * Estado e = new Estado(estadoCliente_form);
             *
             * Estado estadoCliente = beanEstado.findEstado((long) 32768);
             */
            long id_cidade = beanCidade.findIDCidade(cidadeCliente_form);
            long id_estado = beanEstado.findIDEstado(estadoCliente_form);
            if ((id_estado != -1) && (id_cidade != -1)) {

                Cidade cidadeCliente = beanCidade.findCidade(id_cidade);
                Estado estadoCliente = beanEstado.findEstado(id_estado);


                //Cidade c = new Cidade(cidadeCliente_form, e);
                //Cidade cidadeCliente = beanCidade.findCidade((long) 1);
                Cliente cli = new Cliente(nomeCliente_form, cpfCliente_form, usuarioCliente_form, senhaCliente_form, datanascCliente_form, rgCliente_form, enderecoCliente_form, complementoEnd_form, cidadeCliente, estadoCliente, telCliente_form, celCliente_form, emailCliente_form, cartaoCliente_form);

                result = bean.salvar(cli);
                if (result) {
                    session.setAttribute("nome", usuarioCliente_form);
                    request.getRequestDispatcher("home.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
                }

            } else {

                session.setAttribute("valida", "DADOS INCORRETOS!");
                response.sendRedirect("cadastro.jsp");
            }

        }






        // } finally {
        //     out.close();
        // }
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
