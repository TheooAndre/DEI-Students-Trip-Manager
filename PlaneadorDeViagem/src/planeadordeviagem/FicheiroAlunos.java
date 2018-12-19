
package planeadordeviagem;


import java.io.*;
import java.util.*;

/**
 *@author Limeiro
 * @author Etiandro
 */

public class FicheiroAlunos{
        
    /**
     *
     */
    public FicheiroAlunos(){
        
    }
        private int custoMont;
        ArrayList<Aluno> alunos = new ArrayList();
        
    /**
     *método para efetuar o registo do Aluno 
     * @param a
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void registo(Aluno a) throws IOException, ClassNotFoundException{
      String filename1 = File.separator + "home"+ File.separator + "etiandro" + File.separator + "Downloads" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "AlunosDados.txt";
            
            //Carregar ArrayList do ficheiro
            FileInputStream in_file = new FileInputStream(filename1);
            ObjectInputStream entrada = new ObjectInputStream(in_file);
            alunos = (ArrayList<Aluno>) entrada.readObject();
            in_file.close();
            entrada.close();
            //Actualizar lista com o novo aluno
            alunos.add(a);
            //Guardar a lista novamente
            FileOutputStream out_file = new FileOutputStream(filename1);
            ObjectOutputStream saida = new ObjectOutputStream(out_file);
            saida.writeObject(alunos);
            out_file.close();
            saida.close();
            }
     /**
     *método para verificar se o aluno já se encontra registado
     * @param nome
     * @param number
     * @return 0,1,2
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void testeBuscar() throws IOException, ClassNotFoundException{
                String filename1 = File.separator + "home"+ File.separator + "limeiro" + File.separator + "NetBeansProjects" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "AlunosDados.txt";

              // Reading the object from a file
                FileInputStream file = new FileInputStream(filename1);
                ObjectInputStream in = new ObjectInputStream(file);

                ArrayList<Aluno> teste = (ArrayList<Aluno>) in.readObject();
                in.close();
                file.close();
                for(Aluno a:teste){
                    System.out.println(a.nrAluno);
                }
            }

    /**
     *
     * @param nome
     * @param number
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int loginCheck(String nome, int number) throws IOException, ClassNotFoundException{
      String filename1 = File.separator + "home"+ File.separator + "etiandro" + File.separator + "Downloads" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "AlunosDados.txt";
              //Carregar ArrayList do ficheiro
               FileInputStream in_file = new FileInputStream(filename1);
               ObjectInputStream entrada = new ObjectInputStream(in_file);
               ArrayList<Aluno> alunos = (ArrayList<Aluno>) entrada.readObject();
               in_file.close();
               entrada.close();

                for(Aluno a:alunos){
                    if(a.alunoNome.equalsIgnoreCase(nome) && a.nrAluno==number){ 
                        if(a.getGrau().equals("Licenciatura")){
                            custoMont = a.getMontMax();
                            return 1;
                        }
                        
                        else if (a.getGrau().equals("Mestrado")){
                            custoMont = a.getMontMax();
                            return 2;
                        }
                    }  
                }
                return 0;
            }
            
    /**
     *
     * @return Máximo que o aluno deseja gastar
     */
            public int getCustoMont(){
                return custoMont;
            }
        }

