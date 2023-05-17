public class Main{
    public static void main(String[] args){
        Ponto2D p = new Ponto2D(0, 1);

        System.out.println(p.isEixoX());
        System.out.println(p.isEixoY());
        System.out.println(p.isEixos());
        System.out.println(p.quadrante());
        System.out.println(p.distancia(p));
    }
}