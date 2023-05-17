public class Time{
    private int hora;
    private int min;
    private int seg;

    public Time(){
        this(0);
    }

    public Time(int hour){
        this(hour, 0);
    }

    public Time(int hour, int minute){
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second){
        this.hora = hour;
        this.min = minute;
        this.seg = second;
    }

    public Time(Time t){
        this.hora = t.getHour();
        this.min = t.getMinute();
        this.seg = t.getSecond();
    }

    public void addTime(int s){
        if(s < 0){
            System.out.printf("Invalid seconds!!\n");
            System.exit(-1);
        }
        this.seg = this.seg + s;
        if(this.seg >= 60){
            this.min = this.min + this.seg / 60;
            this.seg = this.seg % 60;
            if(this.min >= 60){
                this.hora = this.hora + this.min / 60;
                this.min = this.min % 60;
                if(this.hora >= 24){
                    this.hora = this.hora % 24;
                }
            }
        }
    }

    public void addTime(int m, int s){
        if((m < 0) || (s < 0)){
            System.out.println("Error in addTime, invalide minute!!");
            System.exit(-1);
        }
        this.addTime(s);
        this.min = this.min + m;
        if(this.min >= 60){
            this.hora = this.hora + this.min / 60;
            this.min = this.min % 60;
            if(this.hora >= 24){
                this.hora = this.hora % 24;
            }
        }
    }

    public void addTime(int h, int m, int s){
        if((h < 0) || (m < 0) || (s < 0)){
            System.out.println("Error in addTime, invalide minute!!");
            System.exit(-1);
        }
        this.addTime(m, s);
        this.hora = this.hora + h;
        if(this.hora >= 24){
            this.hora = this.hora % 24;
        }
    }

    public void addTime(Time obj){
        this.addTime(obj.getHour(), obj.getMinute(), obj.getSecond());
    }

    public boolean isAm(){
        if((this.hora < 12) && (this.hora > 0)){
            return true;
        }
        return false;
    }

    public int cron(Time outraHora){
        int hour = mode(outraHora.getHour() - this.hora);
        int minute = mode(outraHora.getMinute() - this.min);
        int second = mode(outraHora.getSecond() - this.seg);

        return (hour * 3600) + (minute * 60) + (second);
    }

    private int mode(int n){
        if(n < 0){
            return ((-1) * n);
        }
        return n;
    }

    public void addSeconds(int secs){
        if(secs < 0){
            System.out.printf("Invalid seconds!!\n");
            System.exit(-1);
        }
        this.seg = this.seg + secs;
        if(this.seg >= 60){
            this.min = this.min + this.seg / 60;
            this.seg = this.seg % 60;
            if(this.min >= 60){
                this.hora = this.hora + this.min / 60;
                this.min = this.min % 60;
                if(this.hora >= 24){
                    this.hora = this.hora % 24;
                }
            }
        }
    }

    public int getHour(){
        return this.hora;
    }

    public int getMinute(){
        return this.min;
    }

    public int getSecond(){
        return this.seg;
    }

    private boolean validateTime(int hora, int min, int seg){
        return validateHour(hora) && validateMinOrSec(min) && validateMinOrSec(seg);
    }

    private boolean validateHour(int hora){
        if((hora>0) && (hora<25))
            return true;
        else
            return false;
    }

    private boolean validateMinOrSec(int param){
        if((param>0) && (param<61))
            return true;
        else
            return false;
    }

    public void setTime(int hora, int min, int seg){
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    public String getTime(){
        String res = this.hora + ":" + this.min + ":" + this.seg;
        return res;
    }

    public void prnTime(){
        System.out.println(getTime());
    }
}