package model;

public class Moto extends Veiculo{
    private String cor;

    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo);
        this.cor = cor;
    }

    // encapsulamento
    public String getCor() {
        return cor;
    }

    @Override
    public double calcularTarifa() {
        return 6.0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cor: " + cor;
    }
}
