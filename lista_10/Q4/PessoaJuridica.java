class PessoaJuridica extends Contato {
    private String cnpj;
    private double faturamento;

    public PessoaJuridica(String nome, String cnpj, String endereco, double faturamento, String telefone, String email) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getFaturamento() {
        return faturamento;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCNPJ: " + cnpj + "\nFaturamento: " + faturamento;
    }
}