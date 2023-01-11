//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		ArrayList <ArrayList <Integer>> res = new Solution().binTreeSortedLevels (arr, n);
    		
    		for (int i = 0; i < res.size(); i++)
    		{
    		    for (int j = 0; j < (res.get (i).size()); j++)
    		    {
    		        System.out.print (res.get(i).get(j) + " ");
    		    }
    		    System.out.println ();
    		}
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList <ArrayList <Integer>> binTreeSortedLevels (int arr[], int n)
    {
       int level=0;
       ArrayList<ArrayList<Integer>> out=new ArrayList<>();
       int high=0;
       int low=0;
       for(int i=0;i<arr.length;i=high+1){
            low=i;
            high=(int)Math.pow(2,level++)+i-1;
           if(high>=n){
               high=arr.length-1;
           }
           ArrayList<Integer> a=new ArrayList<>();
           for(int j=low;j<=high;j++){
               a.add(arr[j]);
           }
           Collections.sort(a);
           out.add(a);
           
       }
       return out;
       
    }
}
