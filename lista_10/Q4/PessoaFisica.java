class PessoaFisica extends Contato {
    private String cpf;
    private Data dataAniversario;

    public PessoaFisica(String nome, String cpf, String endereco, Data dataAniversario, String telefone, String email) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.dataAniversario = dataAniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public Data getDataAniversario() {
        return dataAniversario;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCPF: " + cpf + "\nData de Aniversário: " + dataAniversario;
    }
}