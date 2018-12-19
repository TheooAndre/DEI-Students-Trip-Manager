package planeadordeviagem;
/**
 *
 * @author Limeiro
 * @author Etiando
 */
import java.util.ArrayList;

/**
 *
 * @author limeiro
 */
public class Universidade extends PontoDeInteresse{
    private ArrayList<String> cursos = new ArrayList();

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
    public Universidade(int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCursos() {
        return cursos;
    }

    /**
     *
     * @param cursos
     */
    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }
    
    /**
     *
     * @param curso
     */
    public void addCursos(String curso){
        cursos.add(curso);
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
     * @return
     */
    @Override
    public String toString() {
        return "Nome da Universidade: " + nome + ", " + nomeLocal 
               + "\nExistem estes cursos na Universidade: " + cursos.toString()
               + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
               + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
               + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
    }
    
    
    
}
