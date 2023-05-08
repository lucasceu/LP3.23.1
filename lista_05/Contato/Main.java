class Main {
    public static void main(String[] args) {
      Contato contato = new Contato("lukasceu@gmail.com","73999998888","Lucas",24,03,2000);

      contato.setInicializaDadosAtuais(8, 5, 2023);
      contato.imprimeDados();
    }
  }