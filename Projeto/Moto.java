class Moto extends VeiculoAbstrato {
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int ano, int cilindradas) {
        super(placa, marca, modelo, ano);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " +
                getModelo() + ", Ano: " + getAno() + ", Cilindradas: " +
                getCilindradas());
    }
}