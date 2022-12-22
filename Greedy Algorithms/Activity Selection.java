import java.util.*;
class Activity implements Comparable<Activity>{
    int start,end,index;
    Activity(int st,int en,int idx){
        start=st;
        end=en;
        index=idx;
    }
    public int compareTo(Activity a){
        return this.end-a.end;
    }
}
public class Main
{
	public static void main(String[] args) {
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter the number of activities");
	     int n=sc.nextInt();
	     int start[]=new int[n];
	     int end[]=new int[n];
	     System.out.println("Enter the start time of activities");
	     for(int i=0;i<n;i++)
	         start[i]=sc.nextInt();
	      System.out.println("Enter the end time of activities");
	     for(int i=0;i<n;i++)
	         end[i]=sc.nextInt();
	     Activity[] arr=new Activity[n];
	     for(int i=0;i<n;i++){
	         arr[i]=new Activity(start[i],end[i],i);
	     }
	     Arrays.sort(arr);
	     
	     ArrayList<Integer> act=new ArrayList<>();
	     act.add(arr[0].index);
	     int prev=arr[0].end;
	     for(int i=1;i<n;i++){
	         
	         if(arr[i].start>=prev){
	             act.add(arr[i].index);
	             prev=arr[i].end;
	         }
	     }
	     for(int i=0;i<act.size();i++){
	         System.out.println("Act"+act.get(i));
	     }
	      
	}
}
