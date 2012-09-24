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
import sistemarodoviario.TrajetoSessionBeanRemote;
import sistemarodoviario.jpa.Cliente;
import sistemarodoviario.jpa.Pedido;
import sistemarodoviario.jpa.Trajeto;
import sistemarodoviario.jpa.Viagem;
import java.util.Date;
import sistemarodoviario.PedidoSessionBeanRemote;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "ComprarPassagemServlet", urlPatterns = {"/ComprarPassagemServlet"})
public class ComprarPassagemServlet extends HttpServlet {

    @EJB
    TrajetoSessionBeanRemote bean;
    @EJB
    CidadeSessionBeanRemote beanCidade;
    @EJB
    ClienteSessionBeanRemote beanCliente;
    @EJB
    PedidoSessionBeanRemote beanPedido;

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

        String cidadeOrigem_form = request.getParameter("origemComboBox");
        String cidadeDestino_form = request.getParameter("destinoComboBox");
        String dataIda_form = request.getParameter("dataIda");
        String dataVolta_form = request.getParameter("dataVolta");

        long id_cidadeOrigem = beanCidade.findIDCidade(cidadeOrigem_form);
        long id_cidadeDestino = beanCidade.findIDCidade(cidadeDestino_form);


        String button1_form = request.getParameter("consultaCompraPassagem");

        String button2_form = request.getParameter("registrarPassagem");
        String optionPassagem_form = request.getParameter("radioPassagem");
        String nomePassageiro = request.getParameter("nomePassageiro");
        String cpfPassageiro = request.getParameter("cpfPassageiro");

        String usuarioCliente = (String) session.getAttribute("nome");

        if ("Consultar".equals(button1_form)) {

            long id_trajeto = bean.findIDTrajeto(id_cidadeOrigem, id_cidadeDestino, dataIda_form, dataVolta_form);

            Trajeto t = bean.recebeTrajetoPorID((long) id_trajeto);


            if (t != null) {

                
                session.setAttribute("trajeto", t);
                response.sendRedirect("viagem.jsp");


            } else {

                session.setAttribute("consultaCompra", "Viagem não encontrada");
                response.sendRedirect("comprarPassagem.jsp");
            }
        }
        if ("Finalizar".equals(button2_form)) {

            long id_cliente = beanCliente.findIDCliente(usuarioCliente);
            Cliente clienteAtual = beanCliente.recebeClientePorID(id_cliente);
            Viagem viagemAtual = (Viagem) session.getAttribute("viagem");
            Date data = new Date();
            String dataAtual = data.toString();


            if ("radioPassagemCliente".equals(optionPassagem_form)) {

                Pedido pedidoAtual = new Pedido(clienteAtual.getNomeCliente(), clienteAtual.getCpfCliente(), dataAtual, false, clienteAtual, viagemAtual);
                beanPedido.salvar(pedidoAtual);
                session.setAttribute("pedido", pedidoAtual);
                session.setAttribute("compraFinalizada", "Compra Finalizada com sucesso... ");
                response.sendRedirect("viagem3.jsp");
            } else if ("radioPassagemOutroCliente".equals(optionPassagem_form)) {
                Pedido pedidoAtual = new Pedido(nomePassageiro, cpfPassageiro, dataAtual, false, clienteAtual, viagemAtual);
                beanPedido.salvar(pedidoAtual);
                session.setAttribute("pedido", pedidoAtual);
                session.setAttribute("compraFinalizada", "Compra Finalizada com sucesso... ");
                response.sendRedirect("viagem3.jsp");

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
