public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, String placa, boolean alugada, String categoria, int cilindradas) {
        super(marca, modelo, ano, placa, alugada, categoria);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }


    @Override
    public String toString() {
        return super.toString() + ", " + cilindradas + " cilindradas";
    }
}
