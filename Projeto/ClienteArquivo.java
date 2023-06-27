import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteArquivo {

    public static void salvarClientes(List<Cliente> listaClientes, String nomeArquivo) {
        try {
            File arquivo = new File(nomeArquivo);

            // Verifica se o arquivo já existe
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Cliente cliente : listaClientes) {
                String linha = cliente.getNome() + "," + cliente.getCpf() + "," + cliente.getTelefone() + ","
                        + cliente.getEndereco();

                writer.write(linha);
                writer.newLine();
            }

            writer.close();
            System.out.println("Clientes salvos no arquivo com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os clientes no arquivo: " + e.getMessage());
        }
    }

    public static List<Cliente> carregarClientes(String nomeArquivo) {
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            File arquivo = new File(nomeArquivo);

            // Verifica se o arquivo existe
            if (!arquivo.exists()) {
                return listaClientes;
            }

            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                String[] dados = linha.split(",");

                String nome = dados[0];
                String cpf = dados[1];
                String telefone = dados[2];
                String endereco = dados[3];

                Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
                listaClientes.add(cliente);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Erro ao carregar os clientes do arquivo: " + e.getMessage());
        }

        return listaClientes;
    }

    public static void main() {
        List<Cliente> listaClientes = carregarClientes("clientes.txt");

        Scanner scanner = new Scanner(System.in);

        boolean clienteExistente;
        String cpf;

        do {
            clienteExistente = false;

            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();

            // Verifica se o cliente com o mesmo CPF já existe
            for (Cliente cliente : listaClientes) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteExistente = true;
                    System.out.println("Já existe um cliente cadastrado com o CPF informado.");
                    break;
                }
            }

            if (!clienteExistente) {
                System.out.print("Digite o telefone do cliente: ");
                String telefone = scanner.nextLine();

                System.out.print("Digite o endereço do cliente: ");
                String endereco = scanner.nextLine();


                Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
                listaClientes.add(cliente);

                salvarClientes(listaClientes, "clientes.txt");

                System.out.println("Cliente cadastrado com sucesso.");
            }

        } while (clienteExistente);

    }
}
