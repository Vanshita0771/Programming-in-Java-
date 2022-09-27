import java.util.*;
class Student{
    protected int rollNo;
    protected String name;
    protected String course;
    protected int sem;
    public void inputData(){
        
        Scanner s=new Scanner(System.in);
        System.out.println("-----Enter Student Details-----");
        System.out.print("Enter rollNo:");
        rollNo=s.nextInt();
        System.out.print("Enter name:");
        s.nextLine();
        name=s.nextLine();
        System.out.print("Enter course:");
      
        course=s.nextLine();
        System.out.print("Enter semester:");
        sem=s.nextInt();
    }
    public void displayOutput(){
        System.out.println("-----Display Student Details-----");
        System.out.println("RollNo:"+rollNo);
        System.out.println("Name:"+name);
        System.out.println("Course:"+course);
        System.out.println("Semester:"+sem);
    }
}
class Exam extends Student{
    private float sub1_marks;
    private float sub2_marks;
    private float sub3_marks;
    private float sub4_marks;
    private float sub5_marks;
    private float total_marks;
    private float percentage;
    private float total;
    private char grade;
    public void input_marks(){
        System.out.println("-----Enter Student Marks-----");
        Scanner s=new Scanner(System.in);
        System.out.print("Enter 1st subject marks:");
        sub1_marks=s.nextInt();
        System.out.print("Enter 2nd subject marks:");
        sub2_marks=s.nextInt();
        System.out.print("Enter 3rd subject marks:");
        sub3_marks=s.nextInt();
        System.out.print("Enter 4th subject marks:");
        sub4_marks=s.nextInt();
        System.out.print("Enter 5th subject marks:");
        sub5_marks=s.nextInt();
    }
    public void calculate(){
         total=sub1_marks+sub2_marks+sub3_marks+sub4_marks+sub5_marks;
         percentage=(total*100)/500;
         if(percentage>=70){
             grade='A';
         }
         else if(percentage>=60&&percentage<=69){
             grade='B';
         }
         else if(percentage>=50&&percentage<=59){
             grade='C';
         }
         else if(percentage>=40&&percentage<=49){
             grade='D';
         }
         else{
             grade='F';
         }
    }
    public void displayResult(){
         System.out.println("-----Display Student Result Details-----");
         System.out.println("1st Subject marks:"+sub1_marks);
         System.out.println("2nd Subject marks:"+sub2_marks);
         System.out.println("3rd Subject marks:"+sub3_marks);
         System.out.println("4th Subject marks:"+sub4_marks);
         System.out.println("5th Subject marks:"+sub5_marks);
         System.out.println("Total marks obtained:"+total);
         System.out.println("Max Marks:"+"500");
         System.out.println("Percentage:"+percentage);
         System.out.println("Grade:"+grade);
    }
}
public class Main
{
	public static void main(String[] args) {
		Exam e1=new Exam();
		e1.inputData();
		e1.input_marks();
		e1.displayOutput();
		e1.calculate();
		e1.displayResult();
	}
}
