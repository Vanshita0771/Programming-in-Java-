import java.util.*;
class Conversion{
    public void binToDeci(int n){
        int temp=0;
        int i=0;
        while(n>0){
            int rem=n%10;
            temp+=(int)Math.pow(2,i++)*rem;
            n/=10;
        }
        System.out.println(temp);
    }
    public void hexaToDeci(String n){
        
        int i=n.length()-1;
        int k=0;
        int temp=0;
        while(i>=0){
            int rem;
            if(n.charAt(i)>='A'&&n.charAt(i)<='F'){
                rem=n.charAt(i)-'A'+10;
            }
            else{
                rem=n.charAt(i)-'0';
            }
            temp+=(int)Math.pow(16,k++)*rem;
            i--;
        }
        System.out.println(temp);
    }
    public void octToDeci(int n){
        int temp=0;
        int i=0;
        while(n>0){
            int rem=n%10;
            temp+=(int)Math.pow(8,i++)*rem;
            n/=10;
        }
        System.out.println(temp);
    }
    public void deciToBin(int n){
       String temp="";
        while(n>0){
            int rem=n%2;
            temp+=rem;
            n/=2;
        }
        String rev="";
        for(int i=temp.length()-1;i>-1;i--){
            rev+=temp.charAt(i);
        }
         System.out.println(rev);
    }
 
     public void deciToOctal(int n){
        String temp="";
        while(n>0){
            int rem=n%8;
            temp+=rem;
            n/=8;
        }
        String rev="";
        for(int i=temp.length()-1;i>-1;i--){
            rev+=temp.charAt(i);
        }
         System.out.println(rev);
    }
    public void deciToHex(int n){
        String temp="";
        while(n>0){
            int rem=n%16;
            char a;
            if(rem>9){
                 a=(char)(55+rem);
                 temp+=a;
            }
            else{
              temp+=rem;  
            }
            
            n/=16;
        }
        String rev="";
        for(int i=temp.length()-1;i>-1;i--){
            rev+=temp.charAt(i);
        }
         System.out.println(rev);
    }
}
public class Main
{
	public static void main(String[] args) {
	    Scanner s=new Scanner(System.in);
	    System.out.println("----Choices----\n1 Binary To Decimal\n2 Decimal To Binary\n3 Octal To Decimal\n4 Decimal To Octal\n5 Hexadecimal To Decimal\n6 Decimal To Hexadecimal");
	    Conversion c1=new Conversion();
	    do{
	        System.out.print("Enter your choice:");
	        int ch=s.nextInt();
	        if(ch==1){
	          System.out.print("Enter the binary number:");
	          int n=s.nextInt();
	          c1.binToDeci(n);
	        }
	        else if(ch==2){
	            System.out.print("Enter the decimal number:");
	            int n=s.nextInt();
	            c1.deciToBin(n);
	        }
	          
	        else if(ch==3){
	           System.out.print("Enter the octal number:");
	           int n=s.nextInt();
	           c1.octToDeci(n);
	            
	        }
	        else if(ch==4){
	            System.out.print("Enter the decimal number:");
	            int n=s.nextInt();
	            c1.deciToOctal(n);
	        }
	        else if(ch==5){
	            System.out.print("Enter the hexadecimal number");
	            String st=s.next();
	            c1.hexaToDeci(st);
	        }
	        else if(ch==6){
	            System.out.print("Enter the decimal number:");
	            int n=s.nextInt();
	            c1.deciToHex(n);
	        }
	        else
	          System.out.println("Invalid option");
	         System.out.print("Do you want to continue?(y/n)");
	          char c=s.next().charAt(0);
	          if(c=='n')
	           break;
	    }
	    while(true);
		
	}
}
