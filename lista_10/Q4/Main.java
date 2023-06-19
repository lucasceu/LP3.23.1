import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação da lista de contatos
        List<Contato> contatos = new ArrayList<>();

        // Adicionando contatos à lista
        contatos.add(new PessoaFisica("João", "123.456.789-01", "Rua A, 123", new Data(10, 5, 1985), "1234-5678", "joao@gmail.com"));
        contatos.add(new PessoaJuridica("Empresa XYZ", "12.345.678/0001-99", "Av. B, 456", 1000000.0, "9876-5432", "contato@empresa.com"));

        // Listagem de todos os contatos da agenda
        System.out.println("Lista de Contatos:");
        for (Contato contato : contatos) {
            System.out.println(contato.getInfo());
            System.out.println("---------------------");
        }

        // Busca de contato por CPF
        String cpf = "123.456.789-01";
        System.out.println("Buscando contato por CPF: " + cpf);
        for (Contato contato : contatos) {
            if (contato instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) contato;
                if (pessoaFisica.getCpf().equals(cpf)) {
                    System.out.println("Contato encontrado:");
                    System.out.println(pessoaFisica.getInfo());
                    break;
                }
            }
        }

        // Busca de contato por CNPJ
        String cnpj = "12.345.678/0001-99";
        System.out.println("Buscando contato por CNPJ: " + cnpj);
        for (Contato contato : contatos) {
            if (contato instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) contato;
                if (pessoaJuridica.getCnpj().equals(cnpj)) {
                    System.out.println("Contato encontrado:");
                    System.out.println(pessoaJuridica.getInfo());
                    break;
                }
            }
        }
    }
}