package planeadordeviagem;
import java.io.*;
import java.util.*;
/**
 *@author limeiro
 * @author etiandro
 */
public class GuardarDados {
    
    /**
     * 
     * guarda as viagens que o o aluno escolheu e alguns dados.
     * 
     */
    public GuardarDados(){
    }
    public void guardar(ArrayList <String> viagens, ArrayList <Percurso> pdi)throws IOException {
            String filename = File.separator + "home"+ File.separator + "limeiro" + File.separator + "NetBeansProjects" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "guardaDados.txt";
            File f = new File(filename);
            //f.createNewFile();
            PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
            //for (Percurso viagem : viagens){
            for(int i = 0; i < viagens.size(); i++){
                pw.println(viagens.get(i));
            }
                
            //}
            pw.close();
    }
}
