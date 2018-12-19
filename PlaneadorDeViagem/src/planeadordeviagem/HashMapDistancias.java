/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author limeiro
 */
public class HashMapDistancias {
    
    Map<String, Integer> hash_map = new HashMap<>();
    
    /**
     *
     */
    public HashMapDistancias(){
    }
    
    /**
     *
     * Lê as distancias de um ficheiro e adicionas numa HashMap
     * 
     * @param local
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setHashMap(Local local) throws FileNotFoundException, IOException{
        
      String fileName = File.separator + "home"+ File.separator + "etiandro" + File.separator + "Downloads" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "Distancias.txt";
        
        File f = new File(fileName);
        
        if(f.exists() && f.isFile()) {
     
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
              
            String line;
            while((line = br.readLine()) != null) {
                    
                String[] arrayLinha = line.split(",");
                if(arrayLinha[0].equals(local.getNomeLocal())) {
                    int distancia, cont = 1;  
                    String nomeLocal;
                    while(cont < 39){
                        if(!arrayLinha[cont].equals("")){
                            nomeLocal = arrayLinha[cont];
                            try {
                                distancia = Integer.parseInt(arrayLinha[cont+1]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler a horaInicio");
                                distancia = 0;
                            }
                            if(distancia > 0){
                                hash_map.put(nomeLocal, distancia);
                            }
                            cont += 2;
                        }
                    }
                }
            }   
        }
        local.setHashMap(hash_map);
    }
        
    
    
}
