package planeadordeviagem;
/**
 *
 * @author Limeiro
 * @author Etiando
 */
import java.util.ArrayList;
import java.util.Map;

public class Local {

    /**
     *
     */
    protected String nomeLocal;

    /**
     *
     */
    protected Map<String, Integer> hash_map;
    
    ArrayList<PontoDeInteresse> pontosDeInteresse = new ArrayList();
    ArrayList<Local> listaLocais = new ArrayList();

    /**
     * método para alterar o nome do local 
     * @param nomeLocal
     */
    public Local(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
    //PDI == PontoDeInteresse
    
    /**
     * método que verifica se estamos a guardar um ponto de interesse que já exista
     * @param PDI
     * @return
     */
    public boolean addNewPDI(PontoDeInteresse PDI){
        if(findPDI(PDI.getNome()) >= 0) {
            System.out.println("Ponto de interesse já existe!");
            return false;
        }
        
        pontosDeInteresse.add(PDI);
        return true;
    }
    
    private int findPDI(PontoDeInteresse PDI){
        return this.pontosDeInteresse.indexOf(PDI);
    }
    
    /**
     * 
     *método para conseguir o nome do Local a que este ponto de interesse está associado
     * @param nomePDI
     * @return i
     * @return -1
     */
    private int findPDI(String nomePDI){
        for(int i = 0; i < this.pontosDeInteresse.size(); i++){
            PontoDeInteresse PDI = this.pontosDeInteresse.get(i);
            if(PDI.getNome().equals(nomePDI)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 
     *método para conseguir o nome do Local a que este ponto de interesse está associado
     * @return nomeLocal
     */
    
    public String getNomeLocal() {
        return nomeLocal; 
    }

    /**
     *método para definir o nome do Local a que este ponto de interesse está associado
     * @param nomeLocal
     */
    
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     *método para obter a ArrayList com os pontos de interesse
     * @return pontosDeInteresse
     */
    public ArrayList<PontoDeInteresse> getPontosDeInteresse() {
        return pontosDeInteresse;
    }

    /**
     * método para definir os pontos de interesse
     * @param pontosDeInteresse
     */
    public void setPontosDeInteresse(ArrayList<PontoDeInteresse> pontosDeInteresse) {
        this.pontosDeInteresse = pontosDeInteresse;
    }
    
    /**
     * método para adicionar um local à lista de locais
     * @param local
     */
    public void addLocal(Local local) {
        listaLocais.add(local);
    }
    
    /**
     * método para verificar se esse local já existe na lista de locais
     * @param newLocal
     * @return
     */
    public int findLocal(String newLocal){
        for(int i = 0; i < listaLocais.size(); i++){
            Local local = listaLocais.get(i);
            if(local.getNomeLocal().equals(newLocal)){
                return i;
            }
        }
      return -1;      
    }

    /**
     *método para definir o HashMap
     * @param hash_map
     */
    public void setHashMap(Map<String, Integer> hash_map){
        this.hash_map = hash_map;
    }
    
    /**
     *método para obter o custo da viagem
     * @param nomeLocal
     * @return hash_map
     */
    public int getCustoViagem(String nomeLocal){
        return hash_map.get(nomeLocal);
    }
    
}