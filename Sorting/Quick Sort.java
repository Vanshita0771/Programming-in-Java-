import java.util.*;
public class Main
{
    public static int partition(int arr[],int lb,int ub){
        int pivot=ub;
        int i=lb-1;
        for(int j=lb;j<ub;j++){
            if(arr[j]<arr[pivot]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[pivot];
        arr[pivot]=arr[i+1];
        arr[i+1]=temp;
        return i+1;
    }
    public static void quicksort(int arr[],int lb,int ub){
        if(lb<ub){
            int pi=partition(arr,lb,ub);
            quicksort(arr,lb,pi-1);
            quicksort(arr,pi+1,ub);
        }
    }
    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++)
         System.out.print(arr[i]+" ");
    }
	public static void main(String[] args) {
	   System.out.println("Enter the number of elements in the array");
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int[] arr=new int[n];
	   System.out.println("Enter the elements in the array");
	   for(int i=0;i<n;i++){
	       arr[i]=sc.nextInt();
	   }
	   quicksort(arr,0,arr.length-1);
	   display(arr);
	   
	}
}
