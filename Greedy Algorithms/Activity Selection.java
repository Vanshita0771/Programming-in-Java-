//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class Activity implements Comparable<Activity>{
    int start;
    int end;
    Activity(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Activity a1){
        return this.end-a1.end;
    }
}
class Solution
{
    
    public static int activitySelection(int start[], int end[], int n)
    {
        ArrayList<Activity> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Activity(start[i],end[i]));
        }
        int count=1;
        Collections.sort(arr);
        int prev=arr.get(0).end;
      
        for(int i=1;i<arr.size();i++){
            if(prev<arr.get(i).start){
             count++;
             prev=arr.get(i).end;
            }
        }
        return count;
    }
}
