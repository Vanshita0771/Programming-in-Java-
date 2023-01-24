import java.util.*;
class Hash{
   int size;
   LinkedList<Integer>[] hash_table;
   Hash(int size){
       this.size=size;
       hash_table=new LinkedList[size];
       for(int i=0;i<size;i++)
        hash_table[i]=new LinkedList<Integer>();
   } 
   void insert(int data){
       int i=data%size;
       hash_table[i].add(data);
   }
   int search(int data){
       int i=data%size;
       int n=hash_table[i].size();
       for(int j=0;j<n;j++){
           if(hash_table[i].get(j)==data)
            return j;
       }
       return -1;
   }
   void display(){
       for(int i=0;i<size;i++){
           if(hash_table[i].size()!=0){
               System.out.print(i+": ");
               for(int j=0;j<hash_table[i].size();j++){
                   System.out.print(hash_table[i].get(j)+" ");
               }
               System.out.println();
           }
       }
   }
   void delete(int data){
       int i=data%size;
       int loc=search(data);
       if(loc==-1)
        return;
       hash_table[i].remove(loc);
       
   }
}
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Hash h1=new Hash(n);
		for(int i=0;i<n;i++){
		    h1.insert(sc.nextInt());
		}
    	h1.display();
	    System.out.println("Enter the data to be searched:");
	    int a=h1.search(sc.nextInt());
	    System.out.println(a);
	    h1.delete(4);
	    h1.display();
	}
}
