import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> listaVeiculos = new ArrayList<>();

        // Adicionando motos à lista
        listaVeiculos.add(new Moto("Honda", "CBR 1000RR", 2021, "ABC123", false, "Intermediário", 1000));
        listaVeiculos.add(new Moto("Yamaha", "YZF-R1", 2020, "DEF456", true, "Premium", 1000));
        listaVeiculos.add(new Moto("Suzuki", "GSX-R750", 2019, "GHI789", false, "Standard",750));
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
        listaVeiculos.add(new Carro("Lamborghini", "Huracan", 2020, "CDE567", true, "Premium", 2));
        listaVeiculos.add(new Carro("Porsche", "911 Carrera", 2021, "FGH890", true, "Premium", 2));

        // Imprimindo os veículos da lista
        // for (Veiculo veiculo : listaVeiculos) {
        //     System.out.println(veiculo.toString());
        // }

        // Mostrar a lista de veículos separando por categoria e disponibilidade
        System.out.println("Lista de veículos por categoria e disponibilidade:");

        // Categorias de veículos
        String[] categorias = {"Standard", "Intermediário", "Premium"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja ver motos (M) ou carros (C)?");
        String escolha = scanner.nextLine();
        scanner.close();

        for (String categoria : categorias) {
            if (escolha.equalsIgnoreCase("M")) {
                System.out.println("Motos " + categoria + " disponíveis:");
                for (Veiculo veiculo : listaVeiculos) {
                    if (veiculo instanceof Moto) {
                        Moto moto = (Moto) veiculo;
                        if (moto.getCategoria().equals(categoria) && !moto.isAlugado()) {
                            System.out.println(moto.toString());
                        }
                    }
                }
            } else if (escolha.equalsIgnoreCase("C")) {
                System.out.println("Carros " + categoria + " disponíveis:");
                for (Veiculo veiculo : listaVeiculos) {
                    if (veiculo instanceof Carro) {
                        Carro carro = (Carro) veiculo;
                        if (carro.getCategoria().equals(categoria) && !carro.isAlugado()) {
                            System.out.println(carro.toString());
                        }
                    }
                }
            }

            //Mostrar a lista de veículos alugados separando por categoria
            // System.out.println("Alugados:");

            // if (escolha.equalsIgnoreCase("M")) {
            //     for (Veiculo veiculo : listaVeiculos) {
            //         if (veiculo instanceof Moto) {
            //             Moto moto = (Moto) veiculo;
            //             if (moto.getCategoria().equals(categoria) && moto.isAlugado()) {
            //                 System.out.println(moto.toString());
            //             }
            //         }
            //     }
            // } else if (escolha.equalsIgnoreCase("C")) {
            //     for (Veiculo veiculo : listaVeiculos) {
            //         if (veiculo instanceof Carro) {
            //             Carro carro = (Carro) veiculo;
            //             if (carro.getCategoria().equals(categoria) && carro.isAlugado()) {
            //                 System.out.println(carro.toString());
            //             }
            //         }
            //     }
            // }

            System.out.println();
        }

            
                
    }
}
