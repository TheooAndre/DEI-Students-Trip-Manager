/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author limeiro
 */
public class Licenciatura extends Aluno{

    /**
     *
     * @param montMax
     * @param alunoNome
     * @param nrAluno
     * @param grau
     */
    public Licenciatura(int montMax, String alunoNome, int nrAluno, String grau) {
        super(montMax, alunoNome, nrAluno, grau);
        
    }
    @Override
    public int getMontMax() {
        return montMax;
    }

    /**
     *método para definir o Montante maximo que o aluno deseja gastar
     * @param montMax
     */
    @Override
    public void setMontMax(int montMax) {
        this.montMax = montMax;
    }

    /**
     *método para conseguir obter o nome do Aluno
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
     * método para obter o número de Aluno
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
     *método para obter o grau(licenciatura ou mestrado)
     * @return grau
     */
    @Override
    public String getGrau() {
        return grau;
    }

    /**
     *método para definir o grau(licenciatura ou mestrado)
     * @param grau
     */
    public void setGrau(String grau) {
        this.grau = grau;
    }
    
    
    
    

}