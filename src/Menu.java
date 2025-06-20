import model.Estacionamento;
import model.Carro;
import model.Moto;
import java.util.Scanner;


public class Menu {
    private Estacionamento estacionamento;
    private Scanner scanner;

    public Menu() {
        this(new Estacionamento());
    }

    public Menu(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {

        int opcao;
        do {
            System.out.println("\n===== MENU ESTACIONAMENTO =====");
            System.out.println("1 - Cadastrar Carro");
            System.out.println("2 - Cadastrar Moto");
            System.out.println("3 - Listar Veiculos");
            System.out.println("4 - Liberar Veiculo Cadastrado");
            System.out.println("5 - Calcular total de tarifas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    cadastrarMoto();
                    break;
                case 3:
                    estacionamento.listarVeiculos();
                    break;
                case 4:
                liberarVeiculo();
                break;
                case 5:
                    System.out.println("\n---------------------------------");
                    System.out.printf("Total de Tarifas: R$ %.2f%n", estacionamento.calcularTotalTarifas());
                    System.out.print("---------------------------------\n");
                    break;
                case 0:
                    System.out.println("\n---------------------------------");
                    System.out.println("\t\t\tBye 🤧");
                    System.out.println("---------------------------------\n");

                    break;
                default:
                    System.out.println("\n---------------------------------");
                    System.out.println("Opção Invalida!!!!");
                    System.out.println("---------------------------------\n");
            }
        } while (opcao != 0);

    }

    private void cadastrarCarro() {
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        Carro carro = new Carro(placa, modelo);
        estacionamento.adicionarVeiculo(carro);
        System.out.println("\n--------------------------------------");
        System.out.println("Carro cadastrado com sucesso ✨✨✨");
        System.out.println("--------------------------------------");
    }

    private void cadastrarMoto() {
        System.out.print("Digite a placa da moto: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo da moto: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a cor da moto: ");
        String cor = scanner.nextLine();
        scanner.nextLine();

        Moto moto = new Moto(placa, modelo, cor);
        estacionamento.adicionarVeiculo(moto);
        System.out.println("\n------------------------------------");
        System.out.println("Moto cadastrada com sucesso ✨✨✨");
        System.out.println("------------------------------------");
    }

    private void liberarVeiculo() {

        if (estacionamento.getVeiculos().isEmpty()) {
            System.out.println("\n------------------------------------------");
            System.out.println("Não há veículos cadastrados para excluir!");
            System.out.println("------------------------------------------");
            return;
        }

        System.out.println("\n--- LIBERAR VEÍCULO ---");
        System.out.print("Ver na lista de veículos aquele que deve ser liberado.");
        estacionamento.listarVeiculos();

        System.out.print("Digite a placa do veículo a ser liberado: ");
        String placa = scanner.nextLine().trim();

        boolean liberado = estacionamento.liberarVeiculo(placa);

        // Usando Iterator para remoção segura durante iteração
        if (liberado) {
            System.out.println("\n---------------------------------");
            System.out.println("Veículo com placa " + placa + " foi liberado com sucesso!");
            System.out.println("---------------------------------");
        } else {
            System.out.println("\n---------------------------------");
            System.out.println("Veículo com placa " + placa + " não encontrado!");
            System.out.println("---------------------------------");
        }
    }
}