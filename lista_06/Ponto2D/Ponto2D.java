public class Ponto2D{
    //Atributos
    private float x, y;

    //Construtor
    public Ponto2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Ponto2D(){
        this(0, 0);
    }

    //Metodos get
    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    //Retorna true se o ponto está no eixo x
    public boolean isEixoX(){
        float x = getX(), y = getY();

        if(((x > 0) || (x < 0)) && (y == 0)){
            return true;
        }
        return false;
    }

    //Retorna true se o ponto está no eixo y
    public boolean isEixoY(){
        float x = getX(), y = getY();

        if(((y > 0) || (y < 0)) && (x == 0)){
            return true;
        }
        return false;
    }

    //Retorna true se o ponto está na origem
    public boolean isEixos(){
        if((getX() == 0) && (getY() == 0)){
            return true;
        }
        return false;
    }

    //Retorna o quadrante em que o ponto está
    public int quadrante(){
        float x = getX(), y = getY();

        if(x == 0 && y == 0){
            return 0;
        }else if((x >= 0) && (y >= 0)){
            return 1;
        }else if((x <= 0) && (y >= 0)){
            return 2;
        }else if((x <= 0) && (y <= 0)){
            return 3;
        }else if((x >= 0) && (y <= 0)){
            return 4;
        }
        return -1;
    }

    public float distance(Ponto2D outroPonto){
        double x = (double)outroPonto.getX(), y = (double)outroPonto.getY();

        return (float)(Math.sqrt(((x - this.x) * (x - this.x)) + ((y - this.y) * (y - this.y))));
    }

    public float distance(){
        return (float)(Math.sqrt(((0 - this.x) * (0 - this.x)) + ((0 - this.y) * (0 - this.y))));
    }

    public float distance(float x, float y){
        return (float)(Math.sqrt(((0 - x) * (0 - x)) + ((0 - y) * (0 - y))));
    }
}