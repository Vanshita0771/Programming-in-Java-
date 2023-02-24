//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class PalindromeLL{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Node head=null;
			head=insert(head,sc.nextInt());
			for(int i=1;i<n;i++)
				insert(head,sc.nextInt());
			GfG g=new GfG();
			System.out.println(g.maxPalindrome(head));
		}
	}
	public static Node insert(Node head,int val){
		if(head==null)
			return new Node(val);
		head.next=insert(head.next,val);
		return head;
	}
	/*public static void print(Node head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}*/
}
// } Driver Code Ends



class GfG
{
        public static int maxPalindrome(Node head)
        {
          ArrayList<Integer> arr=new ArrayList<>();
          Node ptr=head;
        
          while(ptr!=null){
              arr.add(ptr.data);
              ptr=ptr.next;
          }
          int n=arr.size();
          int[][] dp=new int[n+1][n+1];
          for(int i=0;i<=n;i++){
              dp[i][i]=1;
          }
          int max=1;
          for(int diff=1;diff<n;diff++){
              for(int i=0,j=i+diff;j<n;i++,j++){
                  if(arr.get(i)==arr.get(j)){
                      if(j-i==1)
                        dp[i][j]=2;
                      else{
                          if(dp[i+1][j-1]!=0){
                              dp[i][j]=2+dp[i+1][j-1];
                          }
                          else
                            dp[i][j]=0;
                      }
                  }
                  if(max<dp[i][j])
                   max=dp[i][j];
              }
          }
          return max;
        }
}
