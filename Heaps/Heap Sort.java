//Heap Sort
import java.util.*;
class Heap{
    ArrayList<Integer> heap=new ArrayList<>();
    void insert(int value){
        heap.add(value);
        int idx=heap.size()-1;
        int parent=(idx-1)/2;
        while(parent>=0&&heap.get(parent)>heap.get(idx)){
            int temp=heap.get(idx);
            heap.set(idx,heap.get(parent));
            heap.set(parent,temp);
            idx=parent;
            parent=(idx-1)/2;
        }
    }
    void heapify(int idx){
        int minIdx=idx;
        int right=2*idx+2;
        int left=2*idx+1;
        if(right<heap.size()&&heap.get(right)<heap.get(minIdx)){
            minIdx=right;
        }
        if(left<heap.size()&&heap.get(left)<heap.get(minIdx)){
            minIdx=left;
        }
        if(idx!=minIdx){
            int temp=heap.get(minIdx);
            heap.set(minIdx,heap.get(idx));
            heap.set(idx,temp);
            heapify(minIdx);
        }
    }
    int delete(){
        int idx=heap.size()-1;
        int temp=heap.get(idx);
        heap.set(idx,heap.get(0));
        heap.set(0,temp);
        int t1=heap.get(idx);
        heap.remove(heap.size()-1);
        heapify(0);
        return t1;
    }
    void display(){
        for(int i=0;i<heap.size();i++)
         System.out.print(heap.get(i)+" ");
        System.out.println();
    }
}
public class Main
{
   
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  int arr[]=new int[n];
	  Heap h1=new Heap();
	  for(int i=0;i<n;i++){
	      arr[i]=sc.nextInt();
	      h1.insert(arr[i]);
	  }

	  for(int i=0;i<n;i++){
	      arr[i]=h1.delete();
	      System.out.print(arr[i]+" ");
	  }
	}
}
