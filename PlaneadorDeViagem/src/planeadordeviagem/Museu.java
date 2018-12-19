package planeadordeviagem;
/**
 *
 * @author Limeiro
 * @author Etiando
 */
public class Museu extends PontoDeInteresse{
    private String tema;

    /**
     *
     * @param tema
     * @param horaInicio
     * @param horaFim
     * @param minutoInicio
     * @param minutoFim
     * @param despesasAdic
     * @param prefCount
     * @param nome
     * @param nomeLocal
     */
    public Museu(String tema, int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
        this.tema = tema;
    }
    
    /**
     *método para obter o tema
     * @return tema
     */
    public String getTema() {
        return tema;
    }

    /**
     *método para definir o tema
     * @param tema
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     *método para fazer print de certa informação
     * @return nome, nomeLocal, tema, horaInicio, minutoInicio, horaFim, minutoFim, prefCount, despesasAdic
     */
    @Override
    public String toString() {
        return "Nome do Museu: " + nome + ", " + nomeLocal 
               + "\nO tema do museu é " + tema 
               + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
               + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
               + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
    }
    
    
    
}