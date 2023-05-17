public class Main{
    public static void main(String[] args){
        Time t = new Time(13, 0, 0);

        t.addTime(7, 50, 3600);
        t.prnTime();
    }
}