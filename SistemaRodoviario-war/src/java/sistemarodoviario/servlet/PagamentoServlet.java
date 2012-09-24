/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sistemarodoviario.ClienteSessionBeanRemote;
import sistemarodoviario.PedidoSessionBeanRemote;
import sistemarodoviario.jpa.Cliente;
import sistemarodoviario.jpa.Pedido;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "PagamentoServlet", urlPatterns = {"/PagamentoServlet"})
public class PagamentoServlet extends HttpServlet {

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

        String button1_form = request.getParameter("efetuarPagamento");
        String button2_form = request.getParameter("imprimirPassagem");
        String button3_form = request.getParameter("receberDados");
        String numeroPedido = request.getParameter("numeroPedido");
        String cartaoCliente = request.getParameter("cartaoCliente");
        String cliente_form = (String) session.getAttribute("nome");

        String numeroPedidoASerImpresso = request.getParameter("nPedido");

        String nomePassageiro = request.getParameter("nomePassageiroASerImpresso");

        String cpfPassageiro = request.getParameter("cpfPassageiroASerImpresso");


        if ("Pagar".equals(button1_form)) {



            long id_cliente = beanCliente.findIDCliente(cliente_form);
            Cliente o = beanCliente.recebeClientePorID((long) id_cliente);
            o.setCartaoCliente(cartaoCliente);
            beanCliente.salvar(o);
            Pedido p = beanPedido.recebePedidoPorID(Long.parseLong(numeroPedido));
            p.setPagoCompra(true);
            beanPedido.salvar(p);
            session.setAttribute("pagamentoRealizado", "Feito");
            response.sendRedirect("pagamento.jsp");

        }

        if ("Imprimir".equals(button2_form)) {
            Pedido pAtual = null;
            if ("".equals(numeroPedidoASerImpresso) || "".equals(nomePassageiro) || "".equals(cpfPassageiro)) {
                session.setAttribute("impressao", "Preencha todos os dados, pois são necessários.");
            } else {
                pAtual = beanPedido.recebePedidoPorID(Long.parseLong(numeroPedidoASerImpresso));
            }

            if (pAtual != null) {
                if (!nomePassageiro.equals(pAtual.getNomePassageiro())) {
                    session.setAttribute("impressao", "Nome do Passageiro incorreto.");
                    response.sendRedirect("retirarPassagem.jsp");
                } else if (!cpfPassageiro.equals(pAtual.getCpfPassageiro())) {
                    session.setAttribute("impressao", "CPF do Passageiro incorreto.");
                    response.sendRedirect("retirarPassagem.jsp");
                } else {
                    if (pAtual.isPagoCompra()) {

                        session.setAttribute("retiraPedido", pAtual);
                        response.sendRedirect("impressao.jsp");

                    } else {
                        session.setAttribute("impressao", "A passagem não foi paga.");
                        response.sendRedirect("retirarPassagem.jsp");
                    }
                }

            } else {
                session.setAttribute("impressao", "Pedido não encontrado.");
                response.sendRedirect("retirarPassagem.jsp");
            }
        }
        if ("Receber".equals(button3_form)) {
            Pedido pRecebido = (Pedido) session.getAttribute("retiraPedido");
            session.setAttribute("enviaPedido", pRecebido);
            response.sendRedirect("impressao.jsp");
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
