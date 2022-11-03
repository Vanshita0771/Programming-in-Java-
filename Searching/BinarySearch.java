import java.util.*;
public class BinarySearch {
	public static int binSearch(int[] arr,int lb,int ub,int key) {
		while(lb<ub) {
			int mid=(lb+ub)/2;
			if(arr[mid]==key)
				 return mid;
			else if(arr[mid]>key)
				 ub=mid-1;
			else
				lb=mid+1;
		}
		return -1;
	}
    public static void main(String[] args) {
    	int arr[]= {1,2,3,4,5,6,7,8,9,10};
    	int pos=binSearch(arr,0,9,11);
    	if(pos==-1)
    		 System.out.println("Element not found");
    	else
    		System.out.println("Element found at index "+pos);
    	
    }
}
