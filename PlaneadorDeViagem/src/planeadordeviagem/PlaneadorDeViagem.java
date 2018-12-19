package planeadordeviagem;
/**
 *
 * @author Limeiro
 * @author Etiando
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author limeiro
 */
public class PlaneadorDeViagem {
    
    ArrayList<PontoDeInteresse> pontosDeInteresse = new ArrayList();
    ArrayList<Local> listaLocal;
    
    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public PlaneadorDeViagem() throws IOException, ClassNotFoundException{
        pontosDeInteresse = LeFicheiroPDI();
        for(Local local : listaLocal){
            HashMapDistancias l = new HashMapDistancias();
            l.setHashMap(local);
        }
  
        Login log = new Login(listaLocal, pontosDeInteresse);
       
    }
    
    public void actualizarFicheiroPDI(ArrayList<PontoDeInteresse> lista) throws IOException{

      String filename = File.separator + "home"+ File.separator + "etiandro" + File.separator + "Downloads" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "PontosDeInteresse.txt";
      File f = new File(filename);
      PrintWriter writer=new PrintWriter(new FileWriter(f));
      //Universidade(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
      //Bar(rank, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
      //Museu(arrayLinha[8], horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
      //Cultural(nrBancos, nrMesas, kmEspaÃ§oVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
      //Diversão(nrPiscinas, nrEquipamentos, espectaculos, nrBancos, nrMesas, kmEspaÃ§oVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);


      for(PontoDeInteresse pdi:lista){

        if(pdi.getClass() == Diversão.class){
          Diversão ponto = (Diversão) pdi;
          writer.println(String.format("DIVERSÃO,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",ponto.nomeLocal,ponto.horaInicio,ponto.minutoInicio,ponto.horaFim,ponto.minutoFim,ponto.despesasAdic,ponto.prefCount,ponto.getNrBancos(),ponto.nrMesas,ponto.getNrPiscinas(),ponto.getNrEquipamentos(),ponto.kmEspaçoVerde,ponto.isEspectaculos(),ponto.nome));
        }
        else if(pdi.getClass() == Museu.class){
          Museu ponto = (Museu) pdi;
          writer.println(String.format("MUSEU,%s,%s,%s,%s,%s,%s,%s,%s,%s",ponto.nomeLocal,ponto.horaInicio,ponto.minutoInicio,ponto.horaFim,ponto.minutoFim,ponto.despesasAdic,ponto.prefCount,ponto.getTema(),ponto.nome));
        }
        else if(pdi.getClass() == Bar.class){
          Bar ponto = (Bar) pdi;
          writer.println(String.format("BAR,%s,%s,%s,%s,%s,%s,%s,%s,%s",ponto.nomeLocal,ponto.horaInicio,ponto.minutoInicio,ponto.horaFim,ponto.minutoFim,ponto.despesasAdic,ponto.prefCount,ponto.getRank(),ponto.nome));
        }
        else if(pdi.getClass() == Cultural.class){
          Cultural ponto = (Cultural) pdi;
          writer.println(String.format("CULTURAL,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",ponto.nomeLocal,ponto.horaInicio,ponto.minutoInicio,ponto.horaFim,ponto.minutoFim,ponto.despesasAdic,ponto.prefCount,ponto.getNrBancos(),ponto.nrMesas,ponto.kmEspaçoVerde,ponto.nome));
        }
        else if(pdi.getClass() == Universidade.class){
          Universidade ponto = (Universidade) pdi;
          writer.println(String.format("UNIVERSIDADE,%s,%s,%s,%s,%s,%s,%s,%s",ponto.nomeLocal,ponto.horaInicio,ponto.minutoInicio,ponto.horaFim,ponto.minutoFim,ponto.despesasAdic,ponto.prefCount,ponto.nome));
        }
      }
      writer.close();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<PontoDeInteresse> LeFicheiroPDI() {
        
      String fileName = File.separator + "home"+ File.separator + "etiandro" + File.separator + "Downloads" + File.separator + "PlaneadorDeViagem" + File.separator + "src" + File.separator + "planeadordeviagem" + File.separator + "PontosDeInteresse.txt";

        ArrayList<PontoDeInteresse> pontoDeInteresse = new ArrayList();
        listaLocal = new ArrayList();
       
        File f = new File(fileName);
        
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                
                String line;
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                    
                    String[] arrayLinha = line.split(",");
                    if(arrayLinha.length > 9) {
                        String nomeLocal, nome;
                        float rank;
                        int horaInicio, minutoInicio, horaFim, minutoFim, despesasAdic, prefCount, flag = 1;  
                        
                        if(!arrayLinha[1].equals("")){
                            nomeLocal = arrayLinha[1];

                            try {
                                horaInicio = Integer.parseInt(arrayLinha[2]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler a horaInicio");
                                horaInicio = -1;
                            }
                            try {
                                minutoInicio = Integer.parseInt(arrayLinha[3]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler o LeFicheiroPDIminutoInicio");
                                minutoInicio = -1;
                            }
                            try {
                                horaFim = Integer.parseInt(arrayLinha[4]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler a horaFim");
                                horaFim = -1;
                            }
                            try {
                                minutoFim = Integer.parseInt(arrayLinha[5]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler o minutoFim");
                                minutoFim = -1;
                            }
                            try {
                                despesasAdic = Integer.parseInt(arrayLinha[6]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler as despesas adicionais");
                                despesasAdic = -1;
                            }
                             try {
                                prefCount = Integer.parseInt(arrayLinha[7]);
                            } catch (NumberFormatException e) {
                                System.out.println("Erro a ler a preferência");
                                prefCount = -1;
                            }
                           
                                
                            if(horaInicio >= 0 && horaInicio < 24 && minutoInicio >= 0 && minutoInicio < 60){
                                if(horaFim >= 0 && horaFim < 24 && minutoFim >= 0 && minutoFim < 60){
                                    if(despesasAdic >= 0 && prefCount >= 0 ){
                                        if(arrayLinha[0].equals("BAR")){
                                            //BAR,nomeLocal,horaInicio,minutoInicio,horaFim,minutoFim,despesasAdic,prefCount,rank,nome,pref|pref|pref
                                            try {
                                                rank = Float.parseFloat(arrayLinha[8]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                rank = -1;
                                            }
                                            if(!arrayLinha[9].equals("") && rank >= 0 && rank <= 5){
                                                nome = arrayLinha[9];
                                                Bar newPDI = new Bar(rank, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
                                                pontoDeInteresse.add(newPDI);
                                                Local newLocal = new Local(nomeLocal);
                                                boolean ret = listaLocal.contains(newLocal);
                                                flag = 1;
                                                for(Local l : listaLocal){
                                                    if(l.getNomeLocal().equals(nomeLocal))
                                                        flag = 0;
                                                }
                                                if(flag == 1){
                                                    listaLocal.add(newLocal);
                                                }
                                            }
                                        }
                                        if(arrayLinha[0].equals("UNIVERSIDADE")){
                                            //UNIVERSIDADE,nomeLocal,horaInicio,minutoInicio,horaFim,minutoFim,despesasAdic,prefCount,nome,curso,curso,pref|pref|pref
                                            if(!arrayLinha[8].equals("")){
                                                nome = arrayLinha[8];
                                                Universidade newPDI = new Universidade(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
                                                pontoDeInteresse.add(newPDI);
                                                int j = 9;
                                                while(j != (arrayLinha.length-2)){
                                                    newPDI.addCursos(arrayLinha[j]);
                                                    j++;
                                                }
                                                Local newLocal = new Local(nomeLocal);
                                                flag = 1;
                                                for(Local l : listaLocal){
                                                    if(l.getNomeLocal().equals(nomeLocal))
                                                        flag = 0;
                                                }
                                                if(flag == 1){
                                                    listaLocal.add(newLocal);
                                                }
                                            }   
                                        }
                                        if(arrayLinha[0].equals("MUSEU")){
                                            //MUSEU,nomeLocal,horaInicio,minutoInicio,horaFim,minutoFim,despesasAdic,prefCount,tema,nome
                                            
                                            if(!arrayLinha[8].equals("") && !arrayLinha[9].equals("")){
                                                nome = arrayLinha[9];
                                                
                                                Museu newPDI = new Museu(arrayLinha[8], horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
                                                pontoDeInteresse.add(newPDI);
                                                Local newLocal = new Local(nomeLocal);
                                                flag = 1;
                                                for(Local l : listaLocal){
                                                    if(l.getNomeLocal().equals(nomeLocal))
                                                        flag = 0;
                                                }
                                                if(flag == 1){
                                                    listaLocal.add(newLocal);
                                                }
                                            }
                                        }
                                        if(arrayLinha[0].equals("CULTURAL")){
                                            //CULTURAL,nomeLocal,horaInicio,minutoInicio,horaFim,minutoFim,despesasAdic,prefCount,nrBancos,nrMesas,kmEspaçoVerde,nome   \\15
                                            int nrBancos, nrMesas, kmEspaçoVerde;
                
                                            try {
                                                nrBancos = Integer.parseInt(arrayLinha[8]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrBancos = -1;
                                            }
                                            try {
                                                nrMesas = Integer.parseInt(arrayLinha[9]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrMesas = -1;
                                            }
                                            try {
                                                kmEspaçoVerde = Integer.parseInt(arrayLinha[10]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                kmEspaçoVerde = -1;
                                            }
                                            if(!arrayLinha[11].equals("") && nrMesas >= 0 && nrBancos >= 0 && kmEspaçoVerde >= 0){
                                                nome = arrayLinha[11];
                                                Cultural newPDI = new Cultural(nrBancos, nrMesas, kmEspaçoVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
                                                pontoDeInteresse.add(newPDI);
                                                Local newLocal = new Local(nomeLocal);
                                                flag = 1;
                                                for(Local l : listaLocal){
                                                    if(l.getNomeLocal().equals(nomeLocal))
                                                        flag = 0;
                                                }
                                                if(flag == 1){
                                                    listaLocal.add(newLocal);
                                                }
                                            }
                                        }
                                        if(arrayLinha[0].equals("DIVERSÃO")){
                                            //DIVERSÃO,nomeLocal,xCoord,yCoord,horaInicio,minutoInicio,horaFim,minutoFim,despesasAdic,prefCount,nrBancos,nrMesas,nrPiscinas,nrEquipamentos,kmEspaçoVerde,espectaculos,nome,pref|pref|pref
                                            int nrBancos, nrMesas, nrPiscinas, nrEquipamentos, kmEspaçoVerde;
                                            boolean espectaculos;
                
                                            try {
                                                nrBancos = Integer.parseInt(arrayLinha[8]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrBancos = -1;
                                            }
                                            try {
                                                nrMesas = Integer.parseInt(arrayLinha[9]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrMesas = -1;
                                            }
                                            try {
                                                nrPiscinas = Integer.parseInt(arrayLinha[10]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrPiscinas = -1;
                                            }
                                            try {
                                                nrEquipamentos = Integer.parseInt(arrayLinha[11]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                nrEquipamentos = -1;
                                            }
                                            try {
                                                kmEspaçoVerde = Integer.parseInt(arrayLinha[12]);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Erro a ler o ranking");
                                                kmEspaçoVerde = -1;
                                            }    
                                            if(!arrayLinha[13].equals("") && !arrayLinha[14].equals("") && nrMesas >= 0 && nrBancos >= 0 && nrEquipamentos >= 0 && nrPiscinas >= 0 && kmEspaçoVerde >= 0){
                                                nome = arrayLinha[14];
                                                espectaculos = Boolean.parseBoolean(arrayLinha[13]);
                                                Diversão newPDI = new Diversão(nrPiscinas, nrEquipamentos, espectaculos, nrBancos, nrMesas, kmEspaçoVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
                                                pontoDeInteresse.add(newPDI);
                                                Local newLocal = new Local(nomeLocal);
                                                flag = 1;
                                                for(Local l : listaLocal){
                                                    if(l.getNomeLocal().equals(nomeLocal))
                                                        flag = 0;
                                                }
                                                if(flag == 1){
                                                    listaLocal.add(newLocal);
                                                }
                                            }
                                        } 
                                    } 
                                }
                            }
                        }  
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (Exception e) {
                System.out.println("ERRO! Qual?");
                e.printStackTrace();
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
        
        return pontoDeInteresse;
    }
    
    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        PlaneadorDeViagem planeadorDeViagem = new PlaneadorDeViagem();
        
        
    }
}
    
               