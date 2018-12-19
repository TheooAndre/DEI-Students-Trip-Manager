package planeadordeviagem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Limeiro
 * @author Etiando
 */
public abstract class PontoDeInteresse extends Local{

    /**
     *
     */
    protected int horaInicio;

    /**
     *
     */
    protected int horaFim;

    /**
     *
     */
    protected int minutoInicio;

    /**
     *
     */
    protected int minutoFim;

    /**
     *
     */
    protected int despesasAdic;

    /**
     *
     */
    protected int prefCount;

    /**
     *
     */
    protected String nome;

    /**
     *
     */
    protected String tema;
    
    private ArrayList<String> pref = new ArrayList();
    
    /**
     *
     * @param horaInicio
     * @param horaFim
     * @param minutoInicio
     * @param minutoFim
     * @param despesasAdic
     * @param prefCount
     * @param nome
     * @param nomeLocal
     */
    public PontoDeInteresse(int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(nomeLocal);
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.minutoInicio = minutoInicio;
        this.minutoFim = minutoFim;
        this.despesasAdic = despesasAdic;
        this.prefCount = prefCount;
        this.nome = nome;
        this.tema = "Não tem";
    }

    /**
     *
     * @return
     */
    @Override
    public String getNomeLocal(){
        return nomeLocal;
    }

    /**
     *
     * @return
     */
    public int getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @return
     */
    public int getMinutoInicio() {
        return minutoInicio;
    }

    /**
     *
     * @param horaInicio
     * @param minutoInicio
     */
    public void setInicio(int horaInicio, int minutoInicio) {
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
    }

    /**
     *
     * @return
     */
    public int getHoraFim() {
        return horaFim;
    }
    
    /**
     *
     * @return
     */
    public int getMinutoFim() {
        return minutoFim;
    }

    /**
     *
     * @param horaFim
     * @param minutoFim
     */
    public void setFim(int horaFim, int minutoFim) {
        this.horaFim = horaFim;
        this.minutoFim = minutoFim;
    }

    /**
     *
     * @return
     */
    public int getDespesasAdic() {
        return despesasAdic;
    }

    /**
     *
     * @param despesasAdic
     */
    public void addDespesaAdic(int despesasAdic) {
        this.despesasAdic += despesasAdic;
    }

    /**
     *
     * @return
     */
    public int getPrefCount() {
        return prefCount;
    }

    /**
     *
     * @param pref
     */
    public void setPrefCount(int pref) {
        this.prefCount = pref;
    }
   
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getTema() {
        return tema;
    }
    
    /**
     *
     * @param newPref
     */
    public void setPref(ArrayList<String> newPref){
        for(int i = 0; i < newPref.size(); i++){
            pref.add(newPref.get(i));
        }
    }
}
