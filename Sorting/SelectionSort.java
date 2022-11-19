import java.util.*;
public class Main
{
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minIdx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIdx]>arr[j]){
                    minIdx=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
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
		 selectionSort(arr);
		 display(arr);
	}
}
