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
public class Final extends HttpServlet {

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
            
            String portaUsuString = request.getParameter("porta");
            int portaUsu = Integer.parseInt(portaUsuString);
            
            String portaAbertaString = request.getParameter("aberta");
            int portaAberta = Integer.parseInt(portaAbertaString);
            
            int portaPremiada;
            do{
                portaPremiada = Math.abs(new Random().nextInt(3));
            } while (portaPremiada == portaAberta);
            
            String mensagem = "Voce ";
            if(portaUsu == portaPremiada){
                mensagem = mensagem + "Venceu!";
            } else {
                mensagem = mensagem + "Perdeu!";
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Final</title>");
            out.println("<head>         "
                    + "<style>" +
"            img{padding-left: 20px;" +
"                height: 150px;" +
"            }" +
"        </style>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Porta Premiada</h1>");
            out.println("<h2>" + mensagem + "</h2>");
            
            for(int i=0; i < 3; i++){
                if(i == portaPremiada){
                    out.println("<img src=\"premiada.png\">");
                } else {
                    out.println("<img src=\"vazia.png\">");
                }
            }
            
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
