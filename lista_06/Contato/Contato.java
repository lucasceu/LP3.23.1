import java.util.*;

public class Contato{
    //Atributos
    private String name, email, phone;
    private int day, month, year;

    //Construtor
    public Contato(String name, String email, String phone, int day, int month, int year){
        setName(name);
        setEmail(email);
        setPhone(phone);
        setDate(day, month, year);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Contato(){
        this("No one", null, "00000000000", 10, 3, 2000);
    }

    public Contato(String name, String phone, int day, int month, int year){
        this(name, null, phone, day, month, year);
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        phone = phone.replace("(", "");
        phone = phone.replace(")", "");
        phone = phone.replace("-", "");
        phone = phone.replace(" ", "");
        this.phone = phone;
    }

    public void setDate(int day, int month, int year){
        Data date = new Data();

        date.setDate(day, month, year);
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }
    
    public void printContact(){
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Email: %s\n", getEmail());
        System.out.printf("Phone: %s\n", getPhone());
        System.out.printf("Birth date: %02d/%02d/%02d\n", getDay(), getMonth(), getYear());
    }
    
    public int calculateAge(){
        Calendar date = new GregorianCalendar();
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        int age = year - this.year;

        if(this.month <= month){
            if(this.day <= day){
                return age;
            }
        }
        return (age - 1);
    }
}