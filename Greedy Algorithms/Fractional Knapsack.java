import java.util.*;
class Item implements Comparable<Item>{
   int value;
   int weight;
   double ratio;
   Item(int value,int weight){
       this.value=value;
       this.weight=weight;
       ratio=(double) value/weight;
   }
   public int compareTo(Item i2){
       return (int)(i2.ratio-this.ratio);
   }
   
}
public class Main
{
	public static void main(String[] args) {
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter the number of items");
	     int n=sc.nextInt();
	     int weight[]=new int[n];
	     int price[]=new int[n];
	     System.out.println("Enter the weight of items");
	     for(int i=0;i<n;i++)
	         weight[i]=sc.nextInt();
	      System.out.println("Enter the price of items");
	     for(int i=0;i<n;i++)
	         price[i]=sc.nextInt();
	     System.out.println("Enter the weight of bag");
	     int total_weight=sc.nextInt();
	     Item[] arr=new Item[n];
	     for(int i=0;i<n;i++){
	         arr[i]=new Item(price[i],weight[i]);
	     }
	     Arrays.sort(arr);
	     double total_price=0;
	     int currWeight=total_weight;
	     for(int i=0;i<n;i++){
	         if(currWeight-arr[i].weight>=0){
	             currWeight-=arr[i].weight;
	             total_price+=arr[i].value;
	         }
	         else{
	             total_price+=arr[i].ratio*currWeight;
	             currWeight=0;
	             break;
	         }
	     }
	     System.out.println("Total value:"+total_price);
	}
}

