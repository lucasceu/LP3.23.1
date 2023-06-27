import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> listaVeiculos = new ArrayList<>();

        // Adicionando motos à lista
        listaVeiculos.add(new Moto("Honda", "CBR 1000RR", 2021, "ABC123", false, "Intermediário", 1000));
        listaVeiculos.add(new Moto("Yamaha", "YZF-R1", 2020, "DEF456", true, "Premium", 1000));
        listaVeiculos.add(new Moto("Suzuki", "GSX-R750", 2019, "GHI789", false, "Standard", 750));
        listaVeiculos.add(new Moto("Kawasaki", "Ninja 650", 2022, "JKL012", true, "Intermediário", 650));
        listaVeiculos.add(new Moto("BMW", "S 1000 RR", 2021, "MNO345", false, "Premium", 1000));
        listaVeiculos.add(new Moto("Ducati", "Panigale V4", 2020, "PQR678", true, "Premium", 1100));
        listaVeiculos.add(new Moto("Triumph", "Street Triple RS", 2019, "STU901", false, "Standard", 765));
        listaVeiculos.add(new Moto("Harley-Davidson", "Iron 883", 2022, "VWX234", false, "Standard", 883));
        listaVeiculos.add(new Moto("KTM", "Duke 390", 2021, "YZA567", true, "Intermediário", 390));
        listaVeiculos.add(new Moto("Aprilia", "Tuono V4 1100", 2020, "BCD890", true, "Premium", 1100));

        // Adicionando carros à lista
        listaVeiculos.add(new Carro("Toyota", "Corolla", 2021, "EFG123", false, "Intermediário", 4));
        listaVeiculos.add(new Carro("Volkswagen", "Golf", 2020, "HIJ456", true, "Standard", 4));
        listaVeiculos.add(new Carro("Ford", "Mustang", 2022, "KLM789", false, "Premium", 2));
        listaVeiculos.add(new Carro("Chevrolet", "Camaro", 2021, "NOP012", true, "Premium", 2));
        listaVeiculos.add(new Carro("BMW", "M3", 2020, "QRS345", false, "Premium", 4));
        listaVeiculos.add(new Carro("Audi", "A4", 2021, "TUV678", true, "Intermediário", 4));
        listaVeiculos.add(new Carro("Mercedes-Benz", "C-Class", 2019, "WXY901", false, "Standard", 4));
        listaVeiculos.add(new Carro("Ferrari", "488 GTB", 2022, "ZAB234", false, "Premium", 2));
        listaVeiculos.add(new Carro("Porsche", "911 Carrera", 2021, "CDE567", true, "Premium", 2));
        listaVeiculos.add(new Carro("Jaguar", "F-Type", 2020, "FGH890", true, "Premium", 2));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de aluguel de veículos!");

        while (true) {
                exibirMenu();
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    listarVeiculosDisponiveis(listaVeiculos);
                } else if (opcao == 2) {
                    alugarVeiculo(listaVeiculos, scanner);
                } else if (opcao == 3) {
                    devolverVeiculo(listaVeiculos, scanner);
                } else if (opcao == 4) {
                    ClienteArquivo.main();
                } else if (opcao == 5) {
                    System.out.println("Obrigado por utilizar o sistema de aluguel de veículos!");
                    break;
                } else {
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            }
            scanner.close();
        }
        private static void exibirMenu() {
            System.out.println("========= MENU =========");
            System.out.println("1 - Listar veículos disponíveis");
            System.out.println("2 - Alugar veículo");
            System.out.println("3 - Devolver veículo");
            System.out.println("4 - Cadastrar cliente");
            System.out.println("5 - Sair");
            System.out.println("========================");
            System.out.println("Escolha uma opção: ");
        }

 
    public static void listarVeiculosDisponiveis(List<Veiculo> listaVeiculos) {
        System.out.println("\nLista de veículos disponíveis:");

        // Categorias de veículos
        String[] categorias = {"Standard", "Intermediário", "Premium"};

        // Agrupar motos por categoria
        Map<String, List<Moto>> motosPorCategoria = new HashMap<>();
        for (String categoria : categorias) {
            List<Moto> motosCategoria = new ArrayList<>();
            for (Veiculo veiculo : listaVeiculos) {
                if (veiculo instanceof Moto) {
                    Moto moto = (Moto) veiculo;
                    if (!moto.isAlugado() && moto.getCategoria().equals(categoria)) {
                        motosCategoria.add(moto);
                    }
                }
            }
            motosPorCategoria.put(categoria, motosCategoria);
        }

        // Agrupar carros por categoria
        Map<String, List<Carro>> carrosPorCategoria = new HashMap<>();
        for (String categoria : categorias) {
            List<Carro> carrosCategoria = new ArrayList<>();
            for (Veiculo veiculo : listaVeiculos) {
                if (veiculo instanceof Carro) {
                    Carro carro = (Carro) veiculo;
                    if (!carro.isAlugado() && carro.getCategoria().equals(categoria)) {
                        carrosCategoria.add(carro);
                    }
                }
            }
            carrosPorCategoria.put(categoria, carrosCategoria);
        }

        // Imprimir motos disponíveis por categoria
        System.out.println("\nMotos disponíveis:");
        for (String categoria : categorias) {
            List<Moto> motosCategoria = motosPorCategoria.get(categoria);
            System.out.println("Categoria: " + categoria);
            if (motosCategoria.isEmpty()) {
                System.out.println("Nenhuma moto disponível nesta categoria");
            } else {
                for (Moto moto : motosCategoria) {
                    System.out.println(moto);
                }
            }
            System.out.println();
        }

        // Imprimir carros disponíveis por categoria
        System.out.println("\nCarros disponíveis:");
        for (String categoria : categorias) {
            List<Carro> carrosCategoria = carrosPorCategoria.get(categoria);
            System.out.println("Categoria: " + categoria);
            if (carrosCategoria.isEmpty()) {
                System.out.println("Nenhum carro disponível nesta categoria");
            } else {
                for (Carro carro : carrosCategoria) {
                    System.out.println(carro);
                }
            }
            System.out.println();
        }
    }


    public static void alugarVeiculo(List<Veiculo> listaVeiculos, Scanner scanner) {
        System.out.println("\nAluguel de veículo:");
        System.out.print("Digite a placa do veículo desejado: ");
        String placa = scanner.nextLine();

        Veiculo veiculoSelecionado = null;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoSelecionado = veiculo;
                break;
            }
        }

        if (veiculoSelecionado != null) {
            if (!veiculoSelecionado.isAlugado()) {
                System.out.print("Digite a data de início do aluguel (AAAA-MM-DD): ");
                String dataInicioAluguelStr = scanner.nextLine();
                LocalDate dataInicioAluguel = LocalDate.parse(dataInicioAluguelStr);

                System.out.print("Digite a data de término do aluguel (AAAA-MM-DD): ");
                String dataTerminoAluguelStr = scanner.nextLine();
                LocalDate dataTerminoAluguel = LocalDate.parse(dataTerminoAluguelStr);

                veiculoSelecionado.setAlugado(true);
                veiculoSelecionado.setDataInicioAluguel(dataInicioAluguel);
                veiculoSelecionado.setDataTerminoAluguel(dataTerminoAluguel);

                System.out.println("\nVeículo alugado com sucesso!");
                System.out.println(veiculoSelecionado);
            } else {
                System.out.println("\nVeículo indisponível para aluguel.");
            }
        } else {
            System.out.println("\nVeículo não encontrado.");
        }
    }

    public static void devolverVeiculo(List<Veiculo> listaVeiculos, Scanner scanner) {
        System.out.println("\nDevolução de veículo:");
        System.out.print("Digite a placa do veículo a ser devolvido: ");
        String placa = scanner.nextLine();

        Veiculo veiculoSelecionado = null;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoSelecionado = veiculo;
                break;
            }
        }

        if (veiculoSelecionado != null) {
            if (veiculoSelecionado.isAlugado()) {
                veiculoSelecionado.setAlugado(false);
                veiculoSelecionado.setDataInicioAluguel(null);
                veiculoSelecionado.setDataTerminoAluguel(null);

                System.out.println("\nVeículo devolvido com sucesso!");
                System.out.println(veiculoSelecionado);
            } else {
                System.out.println("\nEste veículo não está alugado.");
            }
        } else {
            System.out.println("\nVeículo não encontrado.");
        }
    }
}
