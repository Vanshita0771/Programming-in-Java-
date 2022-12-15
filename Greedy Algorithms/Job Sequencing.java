//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       Arrays.sort(arr,(Job j1 , Job j2)->(int)(j2.profit - j1.profit ));
       int m=0;
        for(int i=0;i<n;i++){
            m=Math.max(m,arr[i].deadline);
        } 
        int[] dead=new int[m+1];
        for(int i=0;i<dead.length;i++)
         dead[i]=-1;
         for(int i=0;i<n;i++){
                int d=arr[i].deadline;
                int temp=arr[i].profit;
                for(int j=d;j>0;j--){
                    
                    if(dead[j]==-1){
                      dead[j]=temp;
                      break;
                    }
            }
            
         }
       
        int count=0;
        int profit=0;
       
        for(int i=0;i<dead.length;i++){
         if(dead[i]!=-1)
          {
              count++;
              profit+=dead[i];
             // System.out.println(dead[i]);
          }
           
        }
        int[] a={count,profit};
        return a;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
