public class Data{
    //Atributos
    private int day, month, year;

    //Construtor
    public Data(int day, int month, int year){
        setDate(day, month, year);
    }

    public Data(){
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    //Retorna verdadeiro se a data passada por paramentro é anterior a data do objeto
    public boolean isPrevious(Data outraData){
        if(outraData.getYear() < this.year){
            return true;
        }else if(outraData.getYear() > this.year){
            return false;
        }else{
            if(outraData.getMonth() < this.month){
                return true;
            }else if(outraData.getMonth() > this.month){
                return false;
            }else{
                if(outraData.getDay() < this.day){
                    return true;
                }
                return false;
            }
        }
    }

    //Retorna a quantidade de dias até uma data
    public int howManyDays(Data outraData){
        if(isPrevious(outraData)){
            float diffYears = (float)mode(outraData.getYear() - this.year) - 1;
            float diffMonth1 = 12.0f - outraData.getMonth();
            float diffMonth2 = this.month - 1.0f + 1;
            float days = (diffYears * 365.25f) + ((diffMonth1 + diffMonth2) * 365.25f / 12);
            return (int)(-days);
        }else{
            float diffYears = (float)mode(outraData.getYear() - this.year) - 1;
            float diffMonth1 = 12.0f - this.month;
            float diffMonth2 = outraData.getMonth() - 1.0f + 1;
            float days = (diffYears * 365.25f) + ((diffMonth1 + diffMonth2) * 365.25f / 12);
            return (int)days;
        }
    }

    //Retorna o valor absoluto de um número
    private int mode(int n){
        if(n < 0){
            return (-1 * n);
        }
        return n;
    }

    //Retorna o dia da semana
    public String dayOfWeek(Data date){
        int d = date.getDay();
        int m = date.getMonth();
        int y = date.getYear();
        int k = 0;
        String[] daysWeek = {"Sabado", "Domingo","Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};

        if(m == 1){
            k = d + 2 * 13 + (3 * (13 + 1) / 5) + (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400) + 2;
        }else if(m == 2){
            k = d + 2 * 14 + (3 * (14 + 1) / 5) + (y - 1) + ((y - 1) / 4) - ((y - 1) / 100) + ((y - 1) / 400) + 2;
        }else{
            k = d + 2 * m + (3 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400) + 2;
        }

        return daysWeek[k % 7];
    }

    //Atualiza a data
    public void setDate(int day, int month, int year){
        if(dateVerification(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            System.out.printf("Invalid Date!\n");
            System.exit(-1);
        }
    }

    //Retorna o dia
    public int getDay(){
        return this.day;
    }

    //Retorna o mês
    public int getMonth(){
        return this.month;
    }

    //Retorna o ano
    public int getYear(){
        return this.year;
    }

    //Verifica se a data está correta
    private boolean dateVerification(int day, int month, int year){
        if((month >= 1) && (month  <= 12)){
            if(month == 2){
                if((day >= 1) && (day <= 29) && (isLeapYear(year))){
                    return true;
                }else if((day >= 1) && (day <= 28)){
                    return true;
                }
                return false;
            }else if((day >= 1) && (day <= 30) && ((month % 2 == 0) && (month != 8))){
                return true;
            }else if((day >= 1) && (day <= 31)){
                return true;
            }
        }
        return false;
    }

    //Verifica se o ano é bissexto
    private boolean isLeapYear(int year){
        if((year % 4 == 0) && ((year % 100 == 0) && (year % 400 == 0))){
            return true;
        }
        return false;
    }

    //Inicializa o dia, mês e ano com valores padrão
    public void initializeDate(){
        this.day = getDay();
        this.month = getMonth();
        this.year = getYear();
    }

    //Imprime data
    public void printDate(){
        System.out.printf("%d/%d/%d\n", day, month, year);
    }

    //Imprime data por extenso
    public void printDateExtensive(){
        String m[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        System.out.printf("%d de %s de %d\n", this.day, m[getMonth() - 1], this.year);
    }
}