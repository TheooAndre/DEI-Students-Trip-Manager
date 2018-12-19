/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planeadordeviagem;

/**
 *
 * @author limeiro
 */
public class Cultural extends Parque {

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
    public Cultural(int nrBancos, int nrMesas, int kmEspaçoVerde, int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(nrBancos, nrMesas, kmEspaçoVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
    }

    /**
     *Serve para ter acesso ao valor da variavel nrBancos fora da classe.
     * 
     * @return nrBancos
     */
    public int getNrBancos() {
        return nrBancos;
    }

    /**
     * Serve para mudar o valor da variavél nrBancos fora da classe.
     *
     * @param nrBancos
     */
    public void setNrBancos(int nrBancos) {
        this.nrBancos = nrBancos;
    }

    /**
     * Serve para ter acesso ao valor da variavel nrMesas fora da classe.
     *
     * @return nrMesas
     */
    public int getNrMesas() {
        return nrMesas;
    }

    /**
     * Serve para mudar o valor da variavél nrMesas fora da classe.
     *
     * @param nrMesas
     */
    public void setNrMesas(int nrMesas) {
        this.nrMesas = nrMesas;
    }

    /**
     * Serve para ter acesso ao valor da variavel kmEspaçoVerde fora da classe.
     *
     * @return kmEspaçoVerde
     */
    public int getKmEspaçoVerde() {
        return kmEspaçoVerde;
    }

    /**
     * Serve para ter acesso ao valor da variavel tema fora da classe.
     *
     * @return tema
     */
    public String getTema() {
        return tema;
    }
    
    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param kmEspaçoVerde
     */
    public void setKmEspaçoVerde(int kmEspaçoVerde) {
        this.kmEspaçoVerde = kmEspaçoVerde;
    }
    
    /**
     *Serve para fazer print de toda a informação da classe.
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Nome do Parque: " + nome + ", " + nomeLocal 
               + "\nExistem " + nrBancos + " bancos, " + nrMesas + " mesas e tem " + kmEspaçoVerde + " Km de espaço verde"
               + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
               + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
               + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
    }
}
