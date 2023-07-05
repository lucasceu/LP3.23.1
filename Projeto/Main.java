import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements AluguelVeiculo {
    private List<VeiculoAbstrato> veiculosDisponiveis; 
    private List<VeiculoAbstrato> veiculosAlugados;
    private List<Cliente> clientes;
    public static int totalVeiculosAlugados = 0;

    public Main() { 
        veiculosDisponiveis = new ArrayList<>(); // Inicializa a lista de veículos disponíveis
        veiculosAlugados = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public int totalVeiculosAlugados() {
        return totalVeiculosAlugados;
    }

    public void adicionarVeiculo(VeiculoAbstrato veiculo) {
        veiculosDisponiveis.add(veiculo); // Adiciona o veículo na lista de veículos disponíveis
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarVeiculosPorTipo(String tipo) {
        System.out.println("----- VEÍCULOS DISPONÍVEIS (" + tipo + ") -----");
        for (VeiculoAbstrato veiculo : veiculosDisponiveis) {
            if ((veiculo instanceof Carro && tipo.equalsIgnoreCase("Carro")) ||
                    (veiculo instanceof Moto && tipo.equalsIgnoreCase("Moto"))) { // Verifica se o veículo é do tipo informado
                veiculo.exibirDetalhes(); // Chama o método exibirDetalhes
            }
        }
        System.out.println("---------------------------------------------");
    }

    @Override
    public void realizarAluguel(String cpf, String placa) {
        Cliente cliente = null; // Inicializa o cliente como nulo
        VeiculoAbstrato veiculoAlugado = null; // Inicializa o veículo como nulo

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) { // Verifica se o CPF do cliente é igual ao informado
                cliente = c; // Atribui o cliente encontrado à variável cliente
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado."); // Se o cliente não for encontrado, exibe mensagem de erro
            return;
        }

        for (VeiculoAbstrato veiculo : veiculosDisponiveis) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) { // Verifica se a placa do veículo é igual à informada
                veiculoAlugado = veiculo; // Atribui o veículo encontrado à variável veiculoAlugado
                break;
            }
        }

        if (veiculoAlugado == null) {
            System.out.println("Veículo não encontrado ou indisponível para aluguel."); // Se o veículo não for encontrado, exibe mensagem de erro
            return;
        }

        veiculosDisponiveis.remove(veiculoAlugado);
        veiculoAlugado.setCliente(cliente);
        veiculosAlugados.add(veiculoAlugado);
        totalVeiculosAlugados++; // Incrementa o contador de veículos alugados

        System.out.println("\nVeículo alugado com sucesso!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculoAlugado.getMarca() + " " + veiculoAlugado.getModelo() + "\n");
    }

    @Override
    public void realizarDevolucao(String placa) {
        VeiculoAbstrato veiculoDevolvido = null;

        for (VeiculoAbstrato veiculo : veiculosAlugados) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) { // Verifica se a placa do veículo é igual à informada
                veiculoDevolvido = veiculo; // Atribui o veículo encontrado à variável veiculoDevolvido
                break;
            }
        }

        if (veiculoDevolvido == null) { // Se o veículo não for encontrado, exibe mensagem de erro
            System.out.println("Veículo não encontrado.\n");
            return;
        }

        veiculosAlugados.remove(veiculoDevolvido); 
        veiculoDevolvido.setCliente(null);
        veiculosDisponiveis.add(veiculoDevolvido);
        totalVeiculosAlugados--; // Decrementa o contador de veículos alugados

        System.out.println("\nVeículo devolvido com sucesso!");
        System.out.println("Veículo: " + veiculoDevolvido.getMarca() + " " + veiculoDevolvido.getModelo() + "\n");
    }

    public List<VeiculoAbstrato> getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public static boolean clientePossuiVeiculoAlugado(String cpf, List<VeiculoAbstrato> veiculosAlugados) {
        for (VeiculoAbstrato veiculo : veiculosAlugados) {
            if (veiculo.getCliente().getCpf().equals(cpf)) { 
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main aluguel = new Main(); // Instancia um objeto da classe Main
        Scanner scanner = new Scanner(System.in); 
        int opcao = 0; 

        Carro carro1 = new Carro("ABC1234", "Fiat", "Uno", 2015, 2); // Instancia os objetos da classe Carro
        Carro carro2 = new Carro("DEF5678", "Volkswagen", "Gol", 2018, 4);
        Carro carro3 = new Carro("GHI1234", "Toyota", "Corolla", 2021, 4);
        Moto moto1 = new Moto("GHI9012", "Honda", "CG 125", 2019, 125); // Instancia os objetos da classe Moto
        Moto moto2 = new Moto("JKL3456", "Yamaha", "YZF R3", 2021, 300);
        Moto moto3 = new Moto("KLM7891", "BMW", "S 1000 RR", 2023, 1000);

        aluguel.adicionarVeiculo(carro1); // Adiciona os veículos na lista de veículos disponíveis
        aluguel.adicionarVeiculo(carro2);
        aluguel.adicionarVeiculo(carro3);
        aluguel.adicionarVeiculo(moto1); // Adiciona as motos na lista de veículos disponíveis
        aluguel.adicionarVeiculo(moto2); 
        aluguel.adicionarVeiculo(moto3);

        Cliente cliente1 = new Cliente("João", "123456789"); // Instancia os objetos da classe Cliente
        Cliente cliente2 = new Cliente("Maria", "987654321");
        Cliente cliente3 = new Cliente("José", "456789123");

        aluguel.adicionarCliente(cliente1); // Adiciona os clientes na lista de clientes
        aluguel.adicionarCliente(cliente2);
        aluguel.adicionarCliente(cliente3);

        while (opcao != 4) { 
            System.out.println("----- MENU -----");
            System.out.println("1. Listar veículos disponíveis por tipo");
            System.out.println("2. Alugar veículo");
            System.out.println("3. Devolver veículo");
            System.out.println("4. Sair do aluguel");
            System.out.println("----------------");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de leitura

            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo de veículo (Carro/Moto): ");
                    String tipo = scanner.nextLine();
                    aluguel.mostrarVeiculosPorTipo(tipo); // Chama o método mostrarVeiculosPorTipo
                    System.out.println("Total de veículos alugados: " + aluguel.totalVeiculosAlugados() + "\n");
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    if (clientePossuiVeiculoAlugado(cpf, aluguel.getVeiculosAlugados())) { 
                        System.out.println("\nO cliente já possui um veículo alugado.\n");
                    } else {
                        System.out.print("Digite a placa do veículo que deseja alugar: ");
                        String placaAluguel = scanner.nextLine();

                        aluguel.realizarAluguel(cpf, placaAluguel); 
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo que deseja devolver: ");
                    String placaDevolucao = scanner.nextLine();
                    aluguel.realizarDevolucao(placaDevolucao);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}