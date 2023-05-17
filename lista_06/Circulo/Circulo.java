public class Circulo{
    private float x, y, r;
    private final float PI = 3.141592f; 

    public Circulo(float x, float y, float r){
        setXYR(x, y, r);
    }

    public Circulo(){
        this(0, 0, 1);
    }

    public Circulo(float x, float y){
        this(x, y, 1);
    }

    public Circulo(float r){
        this(0, 0, r);
    }

    public void setXYR(float x, float y, float r){
        if(!validaCirculo(x, y, r)){
            System.out.println("Error, invalid value!!");
            System.exit(-1);
        }
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getR(){
        return this.r;
    }

    private boolean validaCirculo(float x, float y, float r){
        if((x < 0) || (y < 0) || (r < 0)){
            return false;
        }
        return true;
    }

    public void imprimeCirculo(){
        System.out.printf("X: %f\nY: %f\nR: %df\n", this.x, this.y, this.r);
    }

    public boolean isInnerPoint(Ponto2D outroPonto){
        double distance = Math.sqrt((outroPonto.getX() - this.x) * (outroPonto.getX() - this.x) + (outroPonto.getY() - this.y) * (outroPonto.getY() - this.y));

        if(distance > r){
            return false;
        }else{
            return true;
        }
    }

    public float area(){
        return (PI * this.r * this.r);
    }

    private float area(float r){
        return (PI * r * r);
    }

    public float perimeter(){
        return (2 * PI * this.r);
    }

    public boolean isBiggerThan(Circulo c){
        if(area() > area(c.getR())){
            return true;
        }
        return false;
    }
}