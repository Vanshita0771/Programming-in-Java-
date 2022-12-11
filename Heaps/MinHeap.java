import java.util.*;

public class Main
{
    public static void heapify(int idx,ArrayList<Integer> heap){
        int minIdx=idx;
        int left=2*idx+1;
        int right=2*idx+2;
        if(left<heap.size()&&heap.get(left)<heap.get(minIdx)){
            minIdx=left;
        }
        if(right<heap.size()&&heap.get(right)<heap.get(minIdx)){
            minIdx=right;
        }
        if(idx!=minIdx){
             int temp=heap.get(idx);
             heap.set(idx,heap.get(minIdx));
             heap.set(minIdx,temp);
             heapify(minIdx,heap);
        }
        
    }
    public static int delete(ArrayList<Integer> heap){
        //step-1 swap 1st element with last element
        int temp=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
         heap.set(heap.size()-1,temp);
         
        //step-2 remove the last element
        int t=heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        
        //step-3 heapify
        heapify(0,heap);
        
        //step-4 return deleted element
        return t;
        
    }
    public static void insert(int value,ArrayList<Integer> heap){
         heap.add(value);
         int idx=heap.size()-1;
         int parent=(idx-1)/2;
         while(parent>=0&&heap.get(idx)<heap.get(parent)){
             int temp=heap.get(idx);
             heap.set(idx,heap.get(parent));
             heap.set(parent,temp);
             idx=parent;
             parent=(idx-1)/2;
         }
     }
     
     public static void display(ArrayList<Integer> heap){
         for(int i=0;i<heap.size();i++){
           System.out.print(heap.get(i)+" ");
         }
           System.out.println();
     }
	public static void main(String[] args) {
	   ArrayList<Integer> heap=new ArrayList<>();
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   for(int i=0;i<n;i++){
	      
	       insert(sc.nextInt(),heap);
	   }
	   for(int i=0;i<n;i++){
	       System.out.print(delete(heap)+" ");
	   }
	}
}
