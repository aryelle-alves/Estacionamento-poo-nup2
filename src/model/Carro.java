package model;

public class Carro extends Veiculo {
    public Carro(String placa, String modelo) {
        super(placa, modelo);
    }

    @Override
    public double calcularTarifa() {
        return 10.0;
    }
}
