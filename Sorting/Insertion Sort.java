import java.util.*;
public class Main
{
    public static void insertionSort(int arr[]){
      for(int i=1;i<arr.length;i++){
          int temp=arr[i];
          int j=i-1;
          while(j>=0&&arr[j]>temp){
              arr[j+1]=arr[j];
              j--;
          }
          j++;
          arr[j]=temp;
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
		 insertionSort(arr);
		 display(arr);
	}
}
