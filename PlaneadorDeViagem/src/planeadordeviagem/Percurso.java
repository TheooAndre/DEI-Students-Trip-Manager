package planeadordeviagem;

import java.util.ArrayList;

/**
 *
 * @author limeiro
 */
public class Percurso {
    
    private ArrayList<PontoDeInteresse> pontosVisit = new ArrayList();
    private ArrayList<Local> localVisit = new ArrayList();
    private float custoViagem;
    private int prefTotal;

    /**
     *
     */
    public Percurso() {
    }

    /**
     *
     * @return
     */
    public ArrayList<PontoDeInteresse> getPontosVisit() {
        return pontosVisit;
    }

    /**
     *
     * @param pontosVisit
     */
    public void setPontosVisit(ArrayList<PontoDeInteresse> pontosVisit) {
        this.pontosVisit = pontosVisit;
    }

    /**
     *
     * @return
     */
    public ArrayList<Local> getLocalVisit() {
        return localVisit;
    }

    /**
     *
     * @param localVisit
     */
    public void setLocalVisit(ArrayList<Local> localVisit) {
        this.localVisit = localVisit;
    }  
    
    /**
     * Escolhe um local aleatorio
     *
     * @param locais
     * @return
     */
    public int escolheLocal(ArrayList<Local> locais){
        int total, escolhido, flag = 1, cont;
        total = locais.size();
        escolhido = (int)Math.floor(Math.random() * total);
        if(localVisit.isEmpty()){
            localVisit.add(locais.get(escolhido));
            return 0;
        }
        while(flag == 1){
            cont = 0;
            for (int i = 0; i < localVisit.size(); i++) {
                if(locais.get(escolhido).getNomeLocal().equals((localVisit.get(i)).getNomeLocal()))
                    cont++;
            }
            if(cont > 0){
                escolhido = (int)Math.floor(Math.random() * total);
            }
            else { 
                localVisit.add(locais.get(escolhido));
                flag = 0;
            }            
        }
        return 0;
    }
    
    /**
     *
     * @param localEvitar
     * @return
     */
    public int verificaHotspot(String localEvitar){
        for (Local l : localVisit){
            if(l.getNomeLocal().equals(localEvitar)){
                return -1;
            }
        }return 1;
    }
    
    /**
     * escolhe um numero aleatorio de pontos de interesse para cada local
     *
     * @param pontos
     */
    public void escolhePontosDeInteresse(ArrayList<PontoDeInteresse> pontos){
        int cont, total, escolhido, flag, max;
        ArrayList<PontoDeInteresse> novosPontos;
        for(int j = 0; j < localVisit.size(); j++){
            Local newLocal = localVisit.get(j);
            novosPontos = new ArrayList();
            for(PontoDeInteresse p : pontos){
                if(newLocal.getNomeLocal().equals(p.getNomeLocal())){
                    novosPontos.add(p);
                }
            }
            max = (int)Math.floor(Math.random() * 5);
            cont = 0;
            while(cont < max && cont < novosPontos.size()){
                total = novosPontos.size();
                escolhido = (int)Math.floor(Math.random() * total);
                flag = 1;
                if(pontosVisit.isEmpty()){
                        pontosVisit.add(novosPontos.get(escolhido));
                        cont++;
                    }
                for(PontoDeInteresse ponto : pontosVisit){
                        if(novosPontos.get(escolhido).getNome().equals(ponto.getNome())){
                            flag = 0;
                        }   
                }
                if(flag == 1){
                    pontosVisit.add(novosPontos.get(escolhido));
                    cont++;
                }
            }
        }
    }
    
    /**
     *
     */
    public void printLocal(){
        for(Local l : localVisit) 
            System.out.println(l.getNomeLocal());
    }
    
    /**
     *
     */
    public void printPontos(){
        for(PontoDeInteresse p : pontosVisit)
            System.out.println(p.getNome());
    }
    
    /**
     *
     * @return
     */
    public int findMuseu(){
        for(int i = 0; i < pontosVisit.size(); i++){
            if(!pontosVisit.get(i).getTema().equals("Não tem"))
                return 1;
        }
        return -1;
    }
    
    /**
     *
     * @param pref
     * @return
     */
    public int verificaPref(String pref) {
        for(PontoDeInteresse ponto : pontosVisit){
            if(ponto.getNome().equals(pref))
                return 1;
        }
        return -1;
    }
    
    /**
     *
     * @return
     */
    public String printOutput(){
        String output;
        switch (localVisit.size()) {
            case 3:
                output = String.format("%s -> %s -> %s", (localVisit.get(0)).getNomeLocal(),(localVisit.get(1)).getNomeLocal(),(localVisit.get(2)).getNomeLocal());
                return output;
            case 4:
                output = String.format("%s -> %s -> %s -> %s", (localVisit.get(0)).getNomeLocal(),(localVisit.get(1)).getNomeLocal(),(localVisit.get(2)).getNomeLocal(), (localVisit.get(3)).getNomeLocal());
                return output;
            case 5:
                output = String.format("%s -> %s -> %s -> %s -> %s", (localVisit.get(0)).getNomeLocal(),(localVisit.get(1)).getNomeLocal(),(localVisit.get(2)).getNomeLocal(), (localVisit.get(3)).getNomeLocal(), (localVisit.get(4)).getNomeLocal());
                return output;
            default:
                break;
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public String specsLocal(){
        StringBuilder stringBuilder = new StringBuilder();
        for(PontoDeInteresse ponto : pontosVisit){
            stringBuilder.append(ponto.toString());
            stringBuilder.append("\n____________________________________________________\n\n");
        }      
        stringBuilder.append("A viagem custa ").append(custoViagem).append("€\n");
        stringBuilder.append("Vão ").append(prefTotal).append(" pessoas aos pontos de interesse.");
    return stringBuilder.toString();
    }
    
    /**
     *
     */
    public void setCustoViagem(){
        for(int i = 0; i < (localVisit.size()-1); i++){
            custoViagem += (localVisit.get(i)).getCustoViagem(localVisit.get(i+1).getNomeLocal());
        }
        for(PontoDeInteresse ponto : pontosVisit){
            custoViagem += ponto.despesasAdic;
        }
    }

    /**
     *
     * @return
     */
    public float getCustoViagem() {
        return custoViagem;
    }
    
    /**
     *
     */
    public void setPref(){
        for(PontoDeInteresse ponto : pontosVisit){
            prefTotal += ponto.prefCount;
        }
    }

    /**
     *
     * @return
     */
    public int getPref(){
        return prefTotal;
    }
    
}
