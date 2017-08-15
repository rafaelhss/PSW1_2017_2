/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author rafael.soares
 */
public class Cliente {
    public static void main(String[] args) throws IOException{
        Socket  c = new Socket("localhost",999);
        
        DataOutputStream outToServer = new DataOutputStream(c.getOutputStream());
        outToServer.writeBytes("Batataaaa");
        c.close();
    }
}
