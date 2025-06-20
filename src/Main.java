import model.Estacionamento;
import model.Carro;
import model.Moto;


public class Main {
    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();

        // inicialização do programa
        Menu menu = new Menu(estacionamento);
        menu.exibirMenu();
    }
}
