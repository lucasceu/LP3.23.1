class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    
    public Aluguel(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + " (" + cliente.getCpf() + ")\n" +
                "Veículo alugado: " + veiculo + "\n";
    }
}