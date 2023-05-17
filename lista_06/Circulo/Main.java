public class Main{
    public static void main(String[] args){
        Ponto2D p = new Ponto2D(4, 4);
        Circulo c = new Circulo(0, 0, 5);

        System.out.println(c.isInnerPoint(p));
    }
}