/* ComplexNumbers class contains
 1 Data members--real,img
 2 Member Functions--addition,subtraction,display
 3 Explicit Constructor
*/
import java.util.*;
class ComplexNumbers{
    private float real;
    private float img;
   
    ComplexNumbers(){
        float r,i;
	      System.out.println("Enter the values of real and imaginary:");
	      Scanner s=new Scanner(System.in);
	      r=s.nextFloat();
	      i=s.nextFloat();
        real=r;
        img=i;
    }
    
    public void addition(ComplexNumbers c1){
       this.real+=c1.real;
       this.img+=c1.img;
   }
   public void subtraction(ComplexNumbers c1){
       this.real-=c1.real;
       this.img-=c1.img;
       
   }
   public void display(){
       if(img<0){
         System.out.println("Complex Number="+real+img+"i");  
       }
       else{
         System.out.println("Complex Number="+real+"+"+img+"i");
       }
   }
}
public class Main
{
	public static void main(String[] args) {
	   ComplexNumbers c1=new ComplexNumbers();
	   ComplexNumbers c2=new ComplexNumbers();
	   c1.addition(c2);
	   c1.display();
	   c2.subtraction(c1);
	   c2.display();
	}
}

