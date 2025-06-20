package model;

import interfaces.Tarifavel;

public abstract class Veiculo implements Tarifavel {
    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    public String getModelo() {
        return modelo;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public abstract double calcularTarifa();

    @Override
    public String toString() {
        return "Placa: " + placa + " | Modelo: " + modelo;
    }
}
