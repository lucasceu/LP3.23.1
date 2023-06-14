public class Carro extends Veiculo {
    private int numPortas;

    public Carro(String marca, String modelo, int ano, String placa, boolean alugado, String categoria, int numPortas) {
        super(marca, modelo, ano, placa, alugado, categoria);
        this.numPortas = numPortas;
    }

    public int getnumPortas() {
        return numPortas;
    }

    public void setnumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    @Override
    public String toString() {
        return super.toString() +", " + numPortas + " portas";
    }
}
