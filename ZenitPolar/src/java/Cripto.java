
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael.Soares
 */
public class Cripto {
    public String criptografar(String texto){
        Map<String, String> map = new HashMap<String, String>();
        map.put("z", "p");
        map.put("e", "o");
        map.put("n", "l");
        map.put("i", "a");
        map.put("t", "r");
        map.put("p", "z");
        map.put("o", "e");
        map.put("l", "n");
        map.put("a", "i");
        map.put("r", "t");
        map.put("Z", "P");
        map.put("E", "O");
        map.put("N", "L");
        map.put("I", "A");
        map.put("T", "R");
        map.put("P", "Z");
        map.put("O", "E");
        map.put("L", "N");
        map.put("A", "I");
        map.put("R", "T");
        
              
        String letras[] = texto.split("");
        
        
        String textoConvertido = "";
        
        for (String letra : letras) {
            String code = map.get(letra);
            if (code != null)
                textoConvertido = textoConvertido + code;
            else
                textoConvertido = textoConvertido + letra;
        }
        
        return textoConvertido;
    }
}
