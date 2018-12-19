/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

/**
 *@author Etiandro
 * @author limeiro
 */
public class Mestrado extends Aluno{

    /**
     *
     * @param montMax
     * @param alunoNome
     * @param nrAluno
     * @param grau
     */
    public Mestrado(int montMax, String alunoNome, int nrAluno, String grau) {
        super(montMax, alunoNome, nrAluno, grau);
    }
     /**
     *método para obter o montante máximo 
     * @param montMax
     */
    @Override
    public int getMontMax() {
        return montMax;
    }

    /**
     *método para definir o montante máximo
     * @param montMax
     */
    @Override
    public void setMontMax(int montMax) {
        this.montMax = montMax;
    }

    /**
     *método para obter o nome do aluno
     * @return alunoNome
     */
    @Override
    public String getAlunoNome() {
        return alunoNome;
    }

    /**
     *método para definir o nome do aluno
     * @param alunoNome
     */
    @Override
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    
    /**
     *método para obter o número do aluno
     * @return nrAluno
     */
    @Override
    public int getNrAluno() {
        return nrAluno;
    }

    /**
     *método para definir o número do aluno
     * @param nrAluno
     */
    @Override
    public void setNrAluno(int nrAluno) {
        this.nrAluno = nrAluno;
    }

    /**
     *método para obter o grau do aluno(licenciado ou mestrado)
     * @return grau
     */
    @Override
    public String getGrau() {
        return grau;
    }

    /**
     *método para definir o grau do aluno(licenciado ou mestrado)
     * @param Grau
     */
    @Override
    public void setGrau(String Grau) {
        this.grau = grau;
    }

}