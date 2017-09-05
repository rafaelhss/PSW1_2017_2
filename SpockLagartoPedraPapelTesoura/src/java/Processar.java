/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael.soares
 */
public class Processar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String[] elementos = {"spock", "lagarto", "tesoura", "pedra", "papel"};
            
            //TODO sortear um numero.
            
            int num = Math.abs(new Random().nextInt() % 5);
            
            String elementoServlet = elementos[num];
            
            
            String elementoUser = request.getParameter("opcao");
            
            
            String resultado = "voce venceu";
            
            //algoritmo 
            if(elementoUser.equals(elementoServlet)){
                resultado = "empate";
            } 
            
            if(elementoUser.equals("spock")){
                if(elementoServlet.equals("papel") 
                        || 
                        elementoServlet.equals("lagarto")){
                    resultado = "voce perdeu";
                }
            }

            if(elementoUser.equals("lagarto")){
                if(elementoServlet.equals("tesoura") 
                        || 
                        elementoServlet.equals("pedra")){
                    resultado = "voce perdeu";
                }
            }            
            if(elementoUser.equals("pedra")){
                if(elementoServlet.equals("papel") 
                        || 
                        elementoServlet.equals("spock")){
                    resultado = "voce perdeu";
                }
            }          
            if(elementoUser.equals("papel")){
                if(elementoServlet.equals("lagarto") 
                        || 
                        elementoServlet.equals("tesoura")){
                    resultado = "voce perdeu";
                }
            }              
            if(elementoUser.equals("tesoura")){
                if(elementoServlet.equals("pedra") 
                        || 
                        elementoServlet.equals("spock")){
                    resultado = "voce perdeu";
                }
            }            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Processar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O resultado do jogo foi:" + resultado + "</h1>");
            
            
            
            out.println("Eu escolhi:" + "<img height=100px src="  + elementoServlet + ".png alt=\"\">");
            out.println("E voce:" + "<img height=100px src="  + elementoUser + ".png alt=\"\">");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
