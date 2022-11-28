public class Main
{
	public static void main(String[] args) {
		String str="ababcacdvbtddfttxztdscdf";
		String pat="dft";
		boolean flag=false;
		for(int i=0;i<str.length()-2;i++){
		    if(pat.charAt(0)==str.charAt(i)&&pat.charAt(1)==str.charAt(i+1)&&pat.charAt(2)==str.charAt(i+2)){
		        System.out.println(pat+" is found at index "+i+" of main string");
		        flag=true;
		    }
		}
		if(!flag){
		    System.out.println(pat+"does not exist in main string");
		}
	}
}
