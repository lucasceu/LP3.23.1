public class Main{
    public static void main(String[] args){
        Lampada l = new Lampada();

        l.setColor("Blue");
        l.setManufacturer("Light Corporation");
        l.setPotencyWatts(12.4);
        l.setQuantityInStock(30);
        l.setValue(25);
        l.setVoltage(7.0);
        l.makeSale(5);
        l.printPurchase();
    }
}