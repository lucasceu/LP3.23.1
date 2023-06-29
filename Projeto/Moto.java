class Moto extends Veiculo {
    private int cilindradas;
    
    public Moto(String placa, String fabricante, String modelo, int ano, int cilindradas) {
        super(placa, fabricante, modelo, ano);
        this.cilindradas = cilindradas;
    }
    
    public int getCilindradas() {
        return cilindradas;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + cilindradas + " cc";
    }
}