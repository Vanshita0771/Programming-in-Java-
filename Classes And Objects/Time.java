/* Time class contains
 1 Data members--hours,secs,min
 2 Member Functions--addition,display,input
*/
import java.util.*;
class Time{
    private int min,hours,sec;
    public void input(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter hours:");
        hours=s.nextInt();
        System.out.print("Enter minutes:");
        min=s.nextInt();
        System.out.print("Enter seconds:");
        sec=s.nextInt();
    }
    public void display(){
        System.out.println("Time:"+hours+":"+min+":"+sec);
    }
    public void addition(Time t){
        this.min+=t.min;
        this.hours+=t.hours;
        this.sec+=t.sec;
        if(this.sec>60){
            this.sec%=60;
            this.min++;
        }
        if(this.min>60){
            this.min%=60;
            this.hours++;
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		Time t1=new Time();
		t1.input();
		t1.display();
		Time t2=new Time();
		t2.input();
		t2.display();
		t1.addition(t2);
		t1.display();
	}
}

