/*Matrix class contains 
 Data Members--row,col,arr[][]
 Member Functions--input,display,addition,transpose,multiplication
*/
import java.util.Scanner;
class Matrix{
    private int row=3;
    private int col=3;
    private int arr[][]=new int[row][col];
    public void input(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the elements of rows and columns:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=s.nextInt();
            }
        }
    }
    public void display(){
        System.out.println("-----Matrix---");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void transpose(){
        System.out.println("Transpose of matrix:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
    public void addition(Matrix m2){
        System.out.println("Addition of two matrices:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int add=this.arr[i][j]+m2.arr[i][j];
                System.out.print(add+" ");
            }
            System.out.println();
        }
    }
    
    public void multiplication(Matrix m2){
        System.out.println("Multiplication of two matrices:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int mult=0;
               for(int k=0;k<3;k++){
                 mult+=this.arr[i][k]*m2.arr[k][j];
               }
               System.out.print(mult+" ");
            }
            System.out.println();
        }
    }
    
}
public class Main
{
	public static void main(String[] args) {
		Matrix m1=new Matrix();
		m1.input();
		m1.display();
		m1.transpose();
		Matrix m2=new Matrix();
		m2.input();
		m2.display();
		m1.addition(m2);
		m1.multiplication(m2);
	}
}
