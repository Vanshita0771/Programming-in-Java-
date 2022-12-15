//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class Items implements Comparable<Items>{
    Item it;
    double ratio;
    Items(Item i,double r){
        it=i;
        ratio=r;
    }
    @Override
    public int compareTo(Items i2)
    {
       if(i2.ratio-this.ratio>0)
        return 1;
       if(i2.ratio-this.ratio<0)
       return -1;
       return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
       ArrayList<Items> a1=new ArrayList<>();
       for(int i=0;i<arr.length;i++){
           double ratio=(double)arr[i].value/arr[i].weight;
           a1.add(new Items(arr[i],ratio));
       }
       Collections.sort(a1);
       double cost=0;
     
       int weightLeft=W;
       for(int i=0;i<n;i++){
          // System.out.println(cost);
              if(weightLeft<=a1.get(i).it.weight){
                  cost+=((double)weightLeft/a1.get(i).it.weight)*a1.get(i).it.value;
                 //   System.out.println(((double)weightLeft/a1.get(i).it.weight)*a1.get(i).it.value);
                  break;
              }
              else{
                  cost+=a1.get(i).it.value;
                  weightLeft-=a1.get(i).it.weight;
                
              }
           
       }
       return cost;
    }
}
