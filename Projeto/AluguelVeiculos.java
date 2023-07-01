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

    public void mostrarVeiculosPorTipo(String tipo) {
        System.out.println("----- VEÍCULOS DISPONÍVEIS (" + tipo + ") -----");
        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo instanceof Carro && tipo.equalsIgnoreCase("Carro")) {
                Carro carro = (Carro) veiculo;
                System.out.println("Placa: " + carro.getPlaca() + ", Marca: " + carro.getMarca() + ", Modelo: " +
                        carro.getModelo() + ", Ano: " + carro.getAno() + ", Número de Portas: " +
                        carro.getNumPortas());
            } else if (veiculo instanceof Moto && tipo.equalsIgnoreCase("Moto")) {
                Moto moto = (Moto) veiculo;
                System.out.println("Placa: " + moto.getPlaca() + ", Marca: " + moto.getMarca() + ", Modelo: " +
                        moto.getModelo() + ", Ano: " + moto.getAno() + ", Cilindradas: " +
                        moto.getCilindradas());
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void realizarAluguel(String cpf, String placa) {
        Cliente cliente = null;
        Veiculo veiculoAlugado = null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        for (Veiculo veiculo : veiculosDisponiveis) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoAlugado = veiculo;
                break;
            }
        }

        if (veiculoAlugado == null) {
            System.out.println("Veículo não encontrado ou indisponível para aluguel.");
            return;
        }

        veiculosDisponiveis.remove(veiculoAlugado);
        veiculoAlugado.setCliente(cliente);
        veiculosAlugados.add(veiculoAlugado);

        System.out.println("Veículo alugado com sucesso!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculoAlugado.getMarca() + " " + veiculoAlugado.getModelo());
    }

    public void realizarDevolucao(String placa) {
        Veiculo veiculoDevolvido = null;

        for (Veiculo veiculo : veiculosAlugados) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoDevolvido = veiculo;
                break;
            }
        }

        if (veiculoDevolvido == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        veiculosAlugados.remove(veiculoDevolvido);
        veiculoDevolvido.setCliente(null);
        veiculosDisponiveis.add(veiculoDevolvido);

        System.out.println("Veículo devolvido com sucesso!");
        System.out.println("Veículo: " + veiculoDevolvido.getMarca() + " " + veiculoDevolvido.getModelo());
    }

    public List<Veiculo> getVeiculosAlugados() {
        return veiculosAlugados;
    }

    public static boolean clientePossuiVeiculoAlugado(String cpf, List<Veiculo> veiculosAlugados) {
        for (Veiculo veiculo : veiculosAlugados) {
            if (veiculo.getCliente().getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AluguelVeiculos programa = new AluguelVeiculos();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        Carro carro1 = new Carro("ABC1234", "Fiat", "Uno", 2020, 4);
        Carro carro2 = new Carro("DEF5678", "Volkswagen", "Gol", 2018, 4);
        Moto moto1 = new Moto("GHI9012", "Honda", "CG 125", 2019, 125);
        Moto moto2 = new Moto("JKL3456", "Yamaha", "YZF R3", 2021, 300);

        programa.adicionarVeiculo(carro1);
        programa.adicionarVeiculo(carro2);
        programa.adicionarVeiculo(moto1);
        programa.adicionarVeiculo(moto2);

        Cliente cliente1 = new Cliente("João", "123456789");
        Cliente cliente2 = new Cliente("Maria", "987654321");

        programa.adicionarCliente(cliente1);
        programa.adicionarCliente(cliente2);

        while (opcao != 4) {
            System.out.println("----- MENU -----");
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
                    System.out.println("Digite o tipo de veículo (Carro/Moto): ");
                    String tipo = scanner.nextLine();
                    programa.mostrarVeiculosPorTipo(tipo);
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    if (clientePossuiVeiculoAlugado(cpf, programa.getVeiculosAlugados())) {
                        System.out.println("O cliente já possui um veículo alugado.");
                    } else {
                        System.out.print("Digite a placa do veículo que deseja alugar: ");
                        String placaAluguel = scanner.nextLine();

                        programa.realizarAluguel(cpf, placaAluguel);
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo que deseja devolver: ");
                    String placaDevolucao = scanner.nextLine();
                    programa.realizarDevolucao(placaDevolucao);
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