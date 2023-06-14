public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String veiculo;

    // Construtor da classe Cliente
    public Cliente(String nome, String telefone, String endereco, String veiculo) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculo = veiculo;
    }

    // ******************* MONTAR UMA LISTA DE CLIENTES **************//

    // Métodos getter e setter para cada atributo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getveiculo() {
        return veiculo;
    }

    public void setveiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    // Método toString para exibir os dados do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", veiculo='" + veiculo + '\'' +
                '}';
    }
}
