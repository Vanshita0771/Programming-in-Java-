public class Main
{
	public static void main(String[] args) {
	   String str="aaabbabaabggh";
	   String pat="aab";
	   String con=pat+"$"+str;
	   int len=con.length();
	   int arr[]=new int[len];
	   arr[0]=0;
	   int l=0;
	   int r=0;
	   for(int i=1;i<len;i++){
	       l=0;
	       r=i;
	       while(l<i){
	           if(con.charAt(l)==con.charAt(r)){
	               l++;
	               r++;
	           }
	           else{
	                break;
	           }
	       }
	       arr[i]=r-i;
	   }
	   for(int i=0;i<len;i++){
	       if(arr[i]==pat.length()){
	           System.out.println("Found at position "+(i-pat.length()-1));
	       }
	   }
	}
}
