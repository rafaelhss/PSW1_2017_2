/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael.Soares
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ServerSocket server = null;
        
        try {
            server = new ServerSocket(999);
            
            System.out.println("Aguardando conexao");
            Socket socket;
            socket = server.accept();
            System.out.println("Recebi uma conexao!");
            
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isReader = new InputStreamReader( inputStream );
            BufferedReader inputReader = new BufferedReader( isReader );


            System.out.println("Enviado pelo cliente:");
            System.out.println("----------------------------------");

            //Lï¿½ os dados atï¿½ o fim 
            String lido = inputReader.readLine();
            
            String aux = lido.substring(5);
            int espaco = aux.indexOf(" ");
            String path = aux.substring(0, espaco);
            
            System.out.println("path:" + path + "  aux:" + aux );
            
            do {
                    lido = inputReader.readLine();
                    System.out.println(lido); //Exibe o que foi recebido na tela
            } while (lido != null && !lido.equals(""));

            System.out.println("----------------------------------");
            System.out.println("Fim do conteudo enviado pelo cliente.");

            System.out.println("Enviando resposta ao cliente.");
            
            OutputStream outputStream;
            try {
                outputStream = socket.getOutputStream();
                PrintWriter outputWriter =
                        new PrintWriter(
                            new OutputStreamWriter( outputStream ));
	        
                outputWriter.println("HTTP/1.0 200 DeuCertoooo");
                outputWriter.println(); // The empty line
                outputWriter.println("<h1>"
                        + "<font color='red'>"
                        + "teste"
                        + "</font>"
                        + "</h1>"
                        + "<form>"
                        + "teste gambi: <input type='text'>"
                        + "<br/>"
                        + "<input type='submit'>"
                        + "</form>");
                
                if("batata".equals(path)){
                    outputWriter.println("<img height='100px' src='https://yt3.ggpht.com/-cHFMZ-sad-E/AAAAAAAAAAI/AAAAAAAAAAA/dTSVHSra930/s900-c-k-no-mo-rj-c0xffffff/photo.jpg'>");
                }
                if("cenoura".equals(path)){
                    outputWriter.println("<img height='100px' src='http://medicina-tradicional-chinesa.com/wp-content/uploads/2013/02/carrots.jpg'>");
                }
                
                
	        
	        outputWriter.close();
	          socket.close();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }


            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
