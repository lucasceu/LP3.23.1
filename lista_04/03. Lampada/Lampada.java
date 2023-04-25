public class Lampada{
    private double potencyWatts;//
    private String color = new String();//
    private String manufacturer = new String();//
    private double voltage;//
    private double value;
    private int quantityInStock;
    private int quantityPurchase;

    //Retorna a potencia
    public double getPotencyWatts(){
        return this.potencyWatts;
    }

    //Retorna a cor
    public String getColor(){
        return this.color;
    }

    //Retorna o fabricante
    public String getManufacturer(){
        return this.manufacturer;
    }

    //Retorna voltagem
    public double getVoltage(){
        return this.voltage;
    }

    //Retorna o valor
    public double getValue(){
        return this.value;
    }

    //Retorna a quantidade em estoque
    public int getQuantityInStock(){
        return this.quantityInStock;
    }

    //Retorna quantidade da compra
    public int getQuantityPurchase(){
        return this.quantityPurchase;
    }

    //Define a potencia
    public void setPotencyWatts(double potencyWatts){
        if(potencyWatts < 0){
            System.out.printf("Error in setPotencyWatts, invalid potency!!\n");
            System.exit(-1);
        }
        this.potencyWatts = potencyWatts;
    }

    //Define a cor
    public void setColor(String color){
        this.color = color;
    }

    //Define o fabricante
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    //Define a voltagem
    public void setVoltage(double voltage){
        if(voltage < 0){
            System.out.printf("Error in setVoltage, invalid voltage!!\n");
            System.exit(-1);
        }
        this.voltage = voltage;
    }

    //Define o valor
    public void setValue(double value){
        if(value < 0){
            System.out.printf("Error in setValue, invalid value!!\n");
            System.exit(-1);
        }
        this.value = value;
    }

    //Define quantidade em estoque
    public void setQuantityInStock(int quantityInStock){
        if(quantityInStock < 0){
            System.out.printf("Error in setQuantityInStock, invalid quantity!!\n");
            System.exit(-1);
        }
        this.quantityInStock = quantityInStock;
    }

    //Define quantidade da compra
    public void setQuantityPurchase(int quantityPurchase){
        if(quantityPurchase < 1){
            System.out.printf("Error in setQuantityPurchase, invalid quantity!!\n\n");
            System.exit(-1);
        }
        this.quantityPurchase = quantityPurchase;
    }

    //Faz a venda
    public void makeSale(int buyQuantity){
        setQuantityPurchase(buyQuantity);
        this.quantityInStock = this.quantityInStock - this.quantityPurchase;
    }

    //Imprime as informações da venda
    public void printPurchase(){
        System.out.printf("PURCHASE:\n");
        System.out.printf("MANUFACTURER: %s\n", getManufacturer());
        System.out.printf("COLOR: %s\n", getColor());
        System.out.printf("POTENCY: %f\n", getPotencyWatts());
        System.out.printf("VOLTAGE: %f\n", getVoltage());
        System.out.printf("QUANTITY: %d\n", getQuantityPurchase());
        System.out.printf("UNIT VALUE: %f\n", getValue());
        System.out.printf("VALUE: R$ %f\n", getValue() * this.quantityPurchase);
        System.out.printf("SUCCESSFUL PURCHASE!!!!\n");
    }
}