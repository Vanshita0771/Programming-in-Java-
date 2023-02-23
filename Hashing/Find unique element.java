//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.findUnique(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    public int findUnique(int a[], int n, int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(a[i]))
             map.put(a[i],map.get(a[i])+1);
            else 
             map.put(a[i],1);
        }
        for(Integer i:map.keySet()){
            int val=map.get(i);
            
            if(val%k!=0)
             return i;
        }
        return -1;
    }
}
