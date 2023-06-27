import java.time.LocalDate;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private boolean alugado;
    private String categoria;
    private LocalDate dataInicioAluguel;
    private LocalDate dataTerminoAluguel;

    public Veiculo(String marca, String modelo, int ano, String placa, boolean alugado, String categoria) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.alugado = alugado;
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataInicioAluguel() {
        return dataInicioAluguel;
    }

    public void setDataInicioAluguel(LocalDate dataInicioAluguel) {
        this.dataInicioAluguel = dataInicioAluguel;
    }

    public LocalDate getDataTerminoAluguel() {
        return dataTerminoAluguel;
    }

    public void setDataTerminoAluguel(LocalDate dataTerminoAluguel) {
        this.dataTerminoAluguel = dataTerminoAluguel;
    }

    // TO STRING RESUMIDO
    @Override
    public String toString() {
        return "Modelo: " + marca + " " + modelo + ", Placa: " + placa + ", Ano: " + ano;
    }

    /*
    // TO STRING GERAL
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Placa: " + placa + ", Alugado: " + alugado;
    }
    */
}
