public interface AluguelVeiculo {
    void realizarAluguel(String cpf, String placa);
    void realizarDevolucao(String placa);
}