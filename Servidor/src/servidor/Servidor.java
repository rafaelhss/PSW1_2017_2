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
            String lido = "";
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
	        
                outputWriter.println("HTTP/1.0 302 DeuCertoooo");
                outputWriter.println("Location: https://www.uniceub.br");
                outputWriter.println(); // The empty line
	        
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
