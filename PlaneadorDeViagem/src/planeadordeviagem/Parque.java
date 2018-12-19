package planeadordeviagem;

/**
 *
 * @author Limeiro
 * @author Etiando
 */
public abstract class Parque extends PontoDeInteresse{

    /**
     *
     */
    protected int nrBancos;

    /**
     *
     */
    protected int nrMesas;

    /**
     *
     */
    protected int kmEspaçoVerde;

    /**
     *
     * @param nrBancos
     * @param nrMesas
     * @param kmEspaçoVerde
     * @param horaInicio
     * @param horaFim
     * @param minutoInicio
     * @param minutoFim
     * @param despesasAdic
     * @param prefCount
     * @param nome
     * @param nomeLocal
     */
    public Parque(int nrBancos, int nrMesas, int kmEspaçoVerde, int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
        this.nrBancos = nrBancos;
        this.nrMesas = nrMesas;
        this.kmEspaçoVerde = kmEspaçoVerde;
    }

    
    
}
