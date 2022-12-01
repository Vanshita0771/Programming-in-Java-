public class Main
{
    public static void computeLps(String pat,int lps[]){
        int m=pat.length();
        lps[0]=0;
        int len=0;
        int i=1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                lps[i]=len+1;
                len++;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    i++;
                }
            }
        }
    }
    public static void kmpSearch(String txt,String pat){
        int n=txt.length();
        int m=pat.length();
        int[] lps=new int[m];
        computeLps(pat,lps);
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j!=0){
                    j=lps[j-1];    
                }
                else{
                    i++;
                }
            }
        }
        if(j==m){ 
            System.out.println("Found at index "+i-j);
        }
        else{
            System.out.println("Not found");
        }
        
    }
	public static void main(String[] args) {
		kmpSearch("AAAAABBBBCAAABBCAAAR","AAD");
	}
}
