public class Main
{
    public static void getZarr(String str,int z[]){
        int l=0;
        int r=0;
        z[0]=0;
        for(int i=1;i<str.length();i++){
         
            if(i>r){
                l=r=i;
                while(r<str.length()&&str.charAt(r)==str.charAt(r-l)){
                    r++;
                    
                }
                z[i]=r-l;
                r--;
            }
            else{
                int k=i-l;
                if(z[k]<r-i+1){
                    z[i]=z[k];
                }
                else{
                     l=i;
                    while(r<str.length()&&str.charAt(r)==str.charAt(r-l)){
                      r++;
                    }
                     z[i]=r-l;
                     r--;
                }
            }
        }
          
    }
    public static void search(String text,String pat){
        String con=pat+"$"+text;
	    int len=con.length();
	    int arr[]=new int[len];
	    getZarr(con,arr);
	    
	    for(int i=0;i<len;i++){
	       if(arr[i]==pat.length())
	           System.out.println("Found at position "+(i-pat.length()-1));
	    }
    }
	public static void main(String[] args) {
		String text = "afsdssdaaab";
        String pattern = "aab";
        search(text, pattern);
	}
}
