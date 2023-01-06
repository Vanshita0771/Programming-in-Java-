import java.util.*;

class Item implements Comparable<Item> {
	int value;
	int weight;
	double ratio;

	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
		ratio = (double) value / weight;
	}

	public int compareTo(Item i2) {
	
		if(i2.ratio-this.ratio>0)
		 return 1;
		 if(i2.ratio-this.ratio==0)
		   return 0;
		 return -1;
	}

}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int total_weight = sc.nextInt();
		int weight[] = new int[n];
		int price[] = new int[n];
	
		for (int i = 0; i < n; i++)
                {
			price[i] = sc.nextInt();
			weight[i] = sc.nextInt();
		 }
		Item[] arr = new Item[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Item(price[i], weight[i]);
		}
		Arrays.sort(arr);
		double total_price = 0;
		int currWeight = total_weight;
		for (int i = 0; i < n; i++) {
			if (currWeight- arr[i].weight >= 0) {
				currWeight -= arr[i].weight;
				total_price += arr[i].value;
			} else {
				total_price += arr[i].ratio * currWeight;
				currWeight = 0;
				break;
			}
		}
		System.out.println( total_price);
	}
}


