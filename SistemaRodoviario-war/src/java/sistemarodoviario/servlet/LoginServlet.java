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
import sistemarodoviario.*;
import sistemarodoviario.jpa.*;
/**
 *
 * @author Marcelo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    ClienteSessionBeanRemote bean;

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

        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
            
            String login_form = request.getParameter("nome"); // Pega o Login vindo do formulario
            String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulario

            String button_form = request.getParameter("entrarButton");

            boolean result;

            if ("Entrar".equals(button_form)) {
                result = bean.validaLogin(login_form, senha_form);
                if (result) {
                    session.setAttribute("nome", login_form );
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    
                } else {
                    session.setAttribute("senha", "DADOS INCORRETOS...");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            }
        } catch (Exception e) {
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

/*
 * int count;
 * if (request.getSession().getAttribute("count");
 * count =0;
 * }else{
 * count = (Integer) request.getSession().getAttribute("count");
 * }
 * request.getSession().setAttribute("count",++count);
 * out.println("Número de Acessos: " + request.getSession().getAttribute("count"));
 * 
 * 
 * 
 */