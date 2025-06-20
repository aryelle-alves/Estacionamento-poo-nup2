package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estacionamento {
    private final List<Veiculo> veiculos;

    public Estacionamento() {
        this.veiculos = new ArrayList<>();
    }

    // adicionar veículos (carro e moto)
    public void adicionarVeiculo(Carro carro) {
        veiculos.add(carro);
    }
    public void adicionarVeiculo(Moto moto) {
        veiculos.add(moto);
    }

    // calcular tarifas
    public double calcularTotalTarifas() {
        double total = 0;
        for (Veiculo veiculo : veiculos) {
            total += veiculo.calcularTarifa();
        }
        return total;
    }

    // listar veículos
    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("\n---------------------------------");
            System.out.println("Nenhum veiculo a ser listado!");
            System.out.println("---------------------------------");
        } else {
            System.out.println("\n---------------------------------");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.toString());
            }
            System.out.println("---------------------------------");
        }

    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    // liberar veículos pela placa
    public boolean liberarVeiculo(String placa) {
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
