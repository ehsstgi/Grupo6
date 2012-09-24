/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sistemarodoviario.ClienteSessionBeanRemote;
import sistemarodoviario.PedidoSessionBeanRemote;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "ClienteDadosServlet", urlPatterns = {"/ClienteDadosServlet"})
public class ClienteDadosServlet extends HttpServlet {

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

        String button1_form = request.getParameter("verificaDadosCliente");
        String button2_form = request.getParameter("verificaDadosCompras");

        if ("Verificar Meus Dados".equals(button1_form)) {

            String cliente_form = (String) session.getAttribute("nome");

            long id_cliente = beanCliente.findIDCliente(cliente_form);
            Cliente o = beanCliente.recebeClientePorID((long) id_cliente);

            session.setAttribute("cliente", o);
            response.sendRedirect("dados.jsp");


        }
        if ("Verificar Minhas Compras".equals(button2_form)) {

            Pedido pedido = (Pedido) session.getAttribute("pedido");

            List id_pedidos = beanPedido.exibeDadosPedido(pedido.getCliente().getId());

            List<Pedido> pedidos = new LinkedList<Pedido>();

            for (int i = 0; i < id_pedidos.size(); i++) {
                Pedido temp = new Pedido();
                temp = beanPedido.recebePedidoPorID(Long.parseLong(id_pedidos.get(i).toString()));
                pedidos.add(i, temp);
            }

            session.setAttribute("compras", pedidos);
            response.sendRedirect("historico.jsp");


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
