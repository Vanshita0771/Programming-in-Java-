import java.util.Scanner;
class SlidingWindow{
    int minSubArraySum(int arr[],int n,int k){
        
        int st=0;
        int sum=0;
        int startingInd=0;
        for(int i=0;i<k;i++)
         sum+=arr[i];
        int min=sum;
        for(int i=k;i<n;i++){
            sum+=arr[i];
            sum-=arr[st];
            st++;
            if(min>sum){
             min=sum;
             startingInd=st;
            }
        }
        for(int i=startingInd;i<startingInd+k;i++)
         System.out.print(arr[i]+" ");
         System.out.println();
        return sum;
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		  arr[i]=sc.nextInt();
		SlidingWindow s1=new SlidingWindow();
	    System.out.print(s1.minSubArraySum(arr,n,k));
		
	}
}
