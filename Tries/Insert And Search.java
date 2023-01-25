class Trie{
    Trie[] children;
    boolean eow;
    Trie(){
        children=new Trie[26];
        eow=false;
    }
}
public class Main
{
    static Trie t=new Trie();
    public static void insert(String s){
        Trie root=t;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(root.children[idx]==null){
                root.children[idx]=new Trie();
            }
            if(i==s.length()-1){
                root.children[idx].eow=true;
            }
            root=root.children[idx];
        }
    }
    public static int search(String s){
        Trie root=t;
         for(int i=0;i<s.length();i++){
             int idx=s.charAt(i)-'a';
             if(root.children[idx]==null)
              return 0;
             if(i==s.length()-1&&root.children[idx].eow==false)
              return 0;
             root=root.children[idx];
         }
         return 1;
    }
	public static void main(String[] args) {
		 insert("antimony");
		 insert("anti");
		 insert("unique");
		 insert("candy");
		 System.out.println(search("anti"));
	}
}
