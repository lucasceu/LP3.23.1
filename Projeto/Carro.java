class Carro extends Veiculo {
    private int numPortas;
    
    public Carro(String placa, String fabricante, String modelo, int ano, int numPortas) {
        super(placa, fabricante, modelo, ano);
        this.numPortas = numPortas;
    }
    
    public int getNumPortas() {
        return numPortas;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + numPortas + " portas";
    }
}