class Carro extends VeiculoAbstrato {
    private int numPortas;

    public Carro(String placa, String marca, String modelo, int ano, int numPortas) {
        super(placa, marca, modelo, ano);
        this.numPortas = numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " +
                getModelo() + ", Ano: " + getAno() + ", Número de Portas: " +
                getNumPortas());
    }
}