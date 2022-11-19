import java.util.*;
public class Main
{
    public static void merge(int arr[],int lb,int ub,int mid){
        int n=ub-lb+1;
        int[] mer=new int[n];
        int i=lb,j=mid+1,k=0;
        while(i<=mid&&j<=ub){
            if(arr[i]>arr[j])
             mer[k++]=arr[j++];
            else 
             mer[k++]=arr[i++];
        }
        while(i<=mid)
           mer[k++]=arr[i++];
        while(j<=ub)
            mer[k++]=arr[j++];
        k=0;
        for(i=lb;i<=ub;i++){
            arr[i]=mer[k++];
        }
        
    }
    public static void mergeSort(int arr[],int lb,int ub){
      if(lb<ub){
          int mid=(lb+ub)/2;
          mergeSort(arr,lb,mid);
          mergeSort(arr,mid+1,ub);
          merge(arr,lb,ub,mid);
      }
    }
    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
	public static void main(String[] args) {
		System.out.println("Enter the number of elements");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
		 arr[i]=sc.nextInt();
		 mergeSort(arr,0,n-1);
		 display(arr);
	}
}
