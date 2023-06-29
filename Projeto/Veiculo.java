abstract class Veiculo {
    private String placa;
    private String fabricante;
    private String modelo;
    private int ano;
    
    public Veiculo(String placa, String fabricante, String modelo, int ano) {
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    @Override
    public String toString() {
        return fabricante + " " + modelo + " (" + placa + ")";
    }
}