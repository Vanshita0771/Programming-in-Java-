import java.util.*;
class Hash{
    int[] hash_table;
    int size;
    Hash(int size){
        this.size=size;
        hash_table=new int[size];
        Arrays.fill(hash_table,0);
    }
    void insert(int data){
        int i=data%size;
        while(hash_table[i]!=0){
            i=(i+1)%size;
        }
        hash_table[i]=data;
    }
    void display(){
        for(int i=0;i<size;i++){
            System.out.print(hash_table[i]+" ");
        }
    }
    int search(int key){
        int i=key%size;
        if(hash_table[i]==key)
         return i;
        else{
            int temp=i;
            i=(i+1)%size;
            while(i!=temp){
                if(hash_table[i]==key)
                 return i;
                i=(i+1)%size;
            }
        }
        return -1;
    }
    void delete(int data){
        int i=data%size;
        if(hash_table[i]==0){
            System.out.println("Invalid key");
            return;
        }
        int temp=i;
        while(hash_table[i]!=data){
            i=(i+1)%size;
            if(i==temp)
             {
               System.out.println("Invalid key");
               return;
             }
        }
        hash_table[i]=0;
        for(i=(i+1)%size;hash_table[i]!=0;i=(i+1)%size){
            int t=hash_table[i];
            hash_table[i]=0;
            insert(t);
        }
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
	    h1.delete(22);
	    h1.display();
	}
}


