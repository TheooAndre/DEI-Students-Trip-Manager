/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author limeiro
 * @author Etiandro
 */
public abstract class Aluno implements Serializable{
    /**
     * As variáveis estão public para ser conseguirmos ler o ficheiro objeto e introduzir as variaveis numa arraylist no FicheiroAlunos.java
     */
    /**
     *É a variavel montMax que guarda quanto é que é o máximo que o utilizadr quer gastar.
     * 
     */
    public int montMax;

    /**
     *É a variavél alunoNome que guarda o nome do aluno, usada para o Log in.
     */
    public String alunoNome;

    /**
     *É a variavél alunoNome que guarda o número do aluno, usado para o Log in.
     */
    public int nrAluno;

    /**
     *A variavél grau é para diferenciar os alunos de Licenciatura ou Mestrado
     */
    public String grau;

    /**
     *
     * Esta função é o construtor da classe Aluno.
     * 
     * @param montMax
     * @param alunoNome
     * @param nrAluno
     * @param grau
     */
    public Aluno(int montMax, String alunoNome, int nrAluno, String grau) {
        this.montMax = montMax;
        this.alunoNome = alunoNome;
        this.nrAluno = nrAluno;
        this.grau = grau;
    }
    /**
     * 
     * Serve para ter acesso à variavel montMax fora da classe, ( como as variavéis sao public nao era necessário mas pusemos na mesma) 
     * 
     * @return montMax
     */
    public int getMontMax() {
        return montMax;
    }

    /**
     *Serve para mudar o valor da variavel montMax fora da classe ( como as variavéis sao public nao era necessário mas pusemos na mesma) 
     * 
     * @param montMax
     */
    public void setMontMax(int montMax) {
        this.montMax = montMax;
    }

    /**
     *Serve para ter acesso à variavel alunoNome fora da classe, ( como as variavéis sao public nao era necessário mas pusemos na mesma)
     * 
     * @return alunoNome
     */
    public String getAlunoNome() {
        return alunoNome;
    }

    /**
     *Serve para mudar o valor da variavel alunoNome fora da classe ( como as variavéis sao public nao era necessário mas pusemos na mesma) 
     * 
     * @param alunoNome
     */
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    
    /**
     *Serve para ter acesso à variavel nrAluno fora da função, ( como as variavéis sao public nao era necessário mas pusemos na mesma)
     * 
     * @return nrAluno
     */
    public int getNrAluno() {
        return nrAluno;
    }

    /**
     *Serve para mudar o valor da variavel nrAluno fora da classe ( como as variavéis sao public nao era necessário mas pusemos na mesma) 
     * 
     * @param nrAluno
     */
    public void setNrAluno(int nrAluno) {
        this.nrAluno = nrAluno;
    }

    /**
     *
     * Serve para ter acesso à variavel grau fora da função, ( como as variavéis sao public nao era necessário mas pusemos na mesma)
     * @return grau
     */
    public String getGrau() {
        return grau;
    }

    /**
     *Serve para mudar o valor da variavel grau fora da classe ( como as variavéis sao public nao era necessário mas pusemos na mesma) 
     * 
     * @param grau
     */
    public void setGrau(String grau) {
        this.grau = grau;
    }
    
    
    
    
}
