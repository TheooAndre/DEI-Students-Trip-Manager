package planeadordeviagem;
/**
 *
 * @author Limeiro
 * @author Etiando
 */
public class Bar extends PontoDeInteresse{
    private float rank;

    /**
     * 
     * Serve para criar a classe Bar.
     *
     * @param rank
     * @param horaInicio
     * @param horaFim
     * @param minutoInicio
     * @param minutoFim
     * @param despesasAdic
     * @param prefCount
     * @param nome
     * @param nomeLocal
     */
    public Bar(float rank, int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
        this.rank = rank;
    }

    /**
     *
     * Serve para ter acesso ao valor da variavel rank fora da classe.
     * 
     * @return rank
     */
    public float getRank() {
        return rank;
    }

    /**
     * Serve para mudar o valor da variavel rank fora da classe.
     * 
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     *Serve para ter acesso ao valor da variavel tema fora da classe.
     * 
     * @return tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * Serve para fazer print de toda a informação da classe.
     *
     * @return 
     */
    @Override
    public String toString() {
        return "Nome do Bar: " + nome + ", " + nomeLocal 
               + "\nClassificação do Bar = " + rank 
               + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
               + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
               + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
    }
    
    
}
