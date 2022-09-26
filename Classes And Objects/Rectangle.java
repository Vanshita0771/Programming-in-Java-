/*Rectangle class contains
 1 Data Members--length,width,area,peri
 2 Member Functions--calArea,calcPeri
 3 Parametrised Constructor
 */
import java.util.*;
class Rectangle{
    private float length;
    private float width;
    private float area;
    private float peri;
    Rectangle(float l,float w){
        length=l;
        width=w;
    }
    public void calcArea(){
        area=length*width;
        System.out.println("Area:"+area);
    }
    public void calcPeri(){
        peri=2*(length+width);
        System.out.println("Perimeter:"+peri);
    }
}
public class Main
{
	public static void main(String[] args) {
	    float l,w;
	    System.out.println("Enter the values of length and width:");
	    Scanner s=new Scanner(System.in);
	    l=s.nextFloat();
	    w=s.nextFloat();
		  Rectangle r1= new Rectangle(l,w);
		  r1.calcArea();
		  r1.calcPeri();
	}
}

