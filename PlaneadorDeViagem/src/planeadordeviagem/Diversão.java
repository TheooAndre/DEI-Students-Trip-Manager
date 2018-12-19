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
public class Diversão extends Parque{
    private int nrPiscinas;
    private int nrEquipamentos;
    private boolean espectaculos;

    /**
     *
     * @param nrPiscinas
     * @param nrEquipamentos
     * @param espectaculos
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
    public Diversão(int nrPiscinas, int nrEquipamentos, boolean espectaculos, int nrBancos, int nrMesas, int kmEspaçoVerde, int horaInicio, int horaFim, int minutoInicio, int minutoFim, int despesasAdic, int prefCount, String nome, String nomeLocal) {
        super(nrBancos, nrMesas, kmEspaçoVerde, horaInicio, horaFim, minutoInicio, minutoFim, despesasAdic, prefCount, nome, nomeLocal);
        this.nrPiscinas = nrPiscinas;
        this.nrEquipamentos = nrEquipamentos;
        this.espectaculos = espectaculos;
    }

    /**
     *
     * @return nrBancos
     */
    public int getNrBancos() {
        return nrBancos;
    }

    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param nrBancos
     */
    public void setNrBancos(int nrBancos) {
        this.nrBancos = nrBancos;
    }

    /**
     *
     * @return nrMesas
     */
    public int getNrMesas() {
        return nrMesas;
    }

    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param nrMesas
     */
    public void setNrMesas(int nrMesas) {
        this.nrMesas = nrMesas;
    }

    /**
     *
     * @return kmEspaçoVerde
     */
    public int getKmEspaçoVerde() {
        return kmEspaçoVerde;
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
     *
     * @return nrPiscinas
     */
    public int getNrPiscinas() {
        return nrPiscinas;
    }

    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param nrPiscinas
     */
    public void setNrPiscinas(int nrPiscinas) {
        this.nrPiscinas = nrPiscinas;
    }

    /**
     *
     * @return nrEquipamento
     */
    public int getNrEquipamentos() {
        return nrEquipamentos;
    }

    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param nrEquipamentos
     */
    public void setNrEquipamentos(int nrEquipamentos) {
        this.nrEquipamentos = nrEquipamentos;
    }

    /**
     *
     * @return tema
     */
    public String getTema() {
        return tema;
    }

    /**
     *
     * @return espectaculos
     */
    public boolean isEspectaculos() {
        return espectaculos;
    }

    /**
     * Serve para mudar o valor da variavél kmEspaçoVerde fora da classe.
     *
     * @param espectaculos
     */
    public void setEspectaculos(boolean espectaculos) {
        this.espectaculos = espectaculos;
    }
    
    /**
     * Serve para fazer print de toda a informação da classe.
     *
     * @return 
     */
    @Override
    public String toString() {
        if(espectaculos){
            return "Nome do Parque de diversão: " + nome + ", " + nomeLocal 
                + "\nExistem " + nrBancos + " bancos, " + nrMesas + " mesas, " + kmEspaçoVerde + " Km de espaço verde " + nrPiscinas + " piscinas, tem " + nrEquipamentos + " Atrações de entretenimento e espectáculos"
                + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
                + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
                + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
        }
        else if(!espectaculos){
                return "Nome do Parque de diversão: " + nome + ", " + nomeLocal 
                    + "\nExistem " + nrBancos + " bancos, " + nrMesas + " mesas, " + kmEspaçoVerde + " Km de espaço verde " + nrPiscinas + " piscinas, " + nrEquipamentos + " Atrações de entretenimento mas não tem espectáculos"
                    + "\nHorário de funcionamento: " + horaInicio + ":" + minutoInicio + "h - " + horaFim + ":" + minutoFim + "h"
                    + "\nHá "+ prefCount +" pessoas a irem para este Ponto de interesse"
                    + "\nAs despesas deste ponto interesse têm o valor de " + despesasAdic + "€";
        }      
        return null;
    }  
}
