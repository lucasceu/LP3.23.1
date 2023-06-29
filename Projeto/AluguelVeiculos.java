import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AluguelVeiculos {
    private List<Veiculo> veiculosDisponiveis;
    private List<Veiculo> veiculosAlugados;
    private List<Cliente> clientes;

    public AluguelVeiculos() {
        veiculosDisponiveis = new ArrayList<>();
        veiculosAlugados = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculosDisponiveis.add(veiculo);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarVeiculosDisponiveis() {
        System.out.println("Veículos disponíveis para aluguel:");
        for (Veiculo veiculo : veiculosDisponiveis) {
            System.out.println(veiculo);
        }
    }

    public void mostrarVeiculosPorTipo(String tipo) {
        System.out.println("Veículos disponíveis do tipo " + tipo + ":");
        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo.getClass().getSimpleName().equals(tipo)) {
                System.out.println(veiculo);
            }
        }
    }

    public void realizarAluguel(String cpf, String placa) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        Aluguel aluguel = new Aluguel(cliente, veiculo);
        veiculosDisponiveis.remove(veiculo);
        veiculosAlugados.add(veiculo);

        System.out.println("\nAluguel realizado:");
        System.out.println(aluguel);
    }

    public void realizarDevolucao(String placa) {
        Veiculo veiculo = buscarVeiculoAlugado(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado ou não está alugado.");
            return;
        }

        veiculosDisponiveis.add(veiculo);
        veiculosAlugados.remove(veiculo);

        System.out.println("\nDevolução realizada com sucesso.");
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public Veiculo buscarVeiculoAlugado(String placa) {
        for (Veiculo veiculo : veiculosAlugados) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AluguelVeiculos programa = new AluguelVeiculos();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Adicionar carros e motos disponíveis
        Carro carro1 = new Carro("ABC1234", "Volkswagen", "Gol", 2019, 4);
        Carro carro2 = new Carro("DEF5678", "Ford", "Fiesta", 2020, 5);
        Carro carro3 = new Carro("GHI1234", "Toyota", "Corolla", 2021, 5);

        Moto moto1 = new Moto("GHI9012", "Honda", "CB300", 2021, 300);
        Moto moto2 = new Moto("JKL3456", "Yamaha", "MT-07", 2022, 700);
        Moto moto3 = new Moto("KLM7891", "BMW", "S 1000 RR", 2023, 1000);

        programa.adicionarVeiculo(carro1);
        programa.adicionarVeiculo(carro2);
        programa.adicionarVeiculo(carro3);
        programa.adicionarVeiculo(moto1);
        programa.adicionarVeiculo(moto2);
        programa.adicionarVeiculo(moto3);


        // Adicionar clientes
        Cliente cliente1 = new Cliente("João", "123456789");
        Cliente cliente2 = new Cliente("Maria", "987654321");
        Cliente cliente3 = new Cliente("José", "567891234");

        programa.adicionarCliente(cliente1);
        programa.adicionarCliente(cliente2);
        programa.adicionarCliente(cliente3);

        while (opcao != 5) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Listar veículos disponíveis por tipo");
            System.out.println("2. Alugar veículo");
            System.out.println("3. Devolver veículo");
            System.out.println("4. Sair do programa");
            System.out.println("----------------");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de leitura

            switch (opcao) {
                case 1:
                    System.out.println("----- TIPOS DE VEÍCULOS -----");
                    System.out.println("1. Carro");
                    System.out.println("2. Moto");
                    System.out.println("-----------------------------");
                    System.out.print("Digite o tipo de veículo desejado: ");
                    int tipoVeiculo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de leitura

                    if (tipoVeiculo == 1) {
                        programa.mostrarVeiculosPorTipo("Carro");
                    } else if (tipoVeiculo == 2) {
                        programa.mostrarVeiculosPorTipo("Moto");
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite a placa do veículo que deseja alugar: ");
                    String placaAluguel = scanner.nextLine();

                    programa.realizarAluguel(cpf, placaAluguel);

                    break;
                case 3:
                    System.out.print("Digite a placa do veículo que deseja devolver: ");
                    String placaDevolucao = scanner.nextLine();

                    programa.realizarDevolucao(placaDevolucao);

                    break;
                case 4:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}