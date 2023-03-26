//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        HashMap<Character,Integer> map=new HashMap<>();
    for(int i=0;i<S.length();i++){
        if(map.containsKey(S.charAt(i))){
            map.remove(S.charAt(i));
        }
        else
         map.put(S.charAt(i),1);
    }
    if(map.size()<=1)
     return 1;
    return  0;
    }
}
