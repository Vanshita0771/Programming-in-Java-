//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

// } Driver Code Ends


/*
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
*/
class Chain implements Comparable<Chain> {
    Pair p;
    Chain(Pair pa){
        p=pa;
    }
    @Override
    public int compareTo(Chain c1){
        return this.p.y-c1.p.y;
    }
}
class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
     ArrayList<Chain> a1=new ArrayList<>();
     for(int i=0;i<n;i++){
         a1.add(new Chain(arr[i]));
     }
     Collections.sort(a1);
     int count=1;
     int prev=a1.get(0).p.y;
     for(int i=1;i<n;i++){
         if(a1.get(i).p.x>prev){
             count++;
             prev=a1.get(i).p.y;
         }
     }
     return count;
       
    }
}

