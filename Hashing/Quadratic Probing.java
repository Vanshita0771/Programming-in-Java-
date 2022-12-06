import java.util.*;
class HashTable{
     private String keys[];
     private String values[];
     private int maxSize;
     private int currentSize=0;
     
     HashTable(int maxSize){
         this.maxSize=maxSize;
         keys=new String[maxSize];
         values=new String[maxSize];
     }
     
     private int getSize(){
         return currentSize;
     }
     
     private boolean isFull(){
         return currentSize==maxSize;
     }
     
     private boolean isEmpty(){
         return currentSize==0;
     }
   
     private int hash(String key){
         return key.hashCode()%maxSize;
     }
     
     public void insert(String key,String value){
         int hashKey=hash(key);
         int i=hashKey;
         int h=1;
         if(keys[i]==null){
             keys[i]=key;
             values[i]=value;
             currentSize++;
             return;
         }
         if(keys[i].equals(key)) 
         { 
             values[i] = value; 
             return; 
         }       
         i=(i+h*h)%maxSize;
         h++;
         while(i!=hashKey){
             if(keys[i]==null){
                 keys[i]=key;
                 values[i]=value;
                 currentSize++;
                 return;
             }
             if(keys[i].equals(key)) 
             { 
             values[i] = value; 
             return; 
             } 
              i=(i+h*h)%maxSize;
              h++;
         }
     }
     
     public String search(String key){
          int hashKey=hash(key);
          int i=hashKey;
          int h=1;
          
          do{
             if(keys[i]==null){
                 return null;
             }    
             if(keys[i].equals(key)){
                 return values[i];
             }
             h++;
             i=(i+h*h)%maxSize;
          }while(i!=hashKey);
          return null;
     }
     
     void delete(String key){
          int hashKey=hash(key);
          int i=hashKey;
          int h=1;
          if(keys[i]==null)
           return;
          
          while(!keys[i].equals(key)){
              i=(i+h*h)%maxSize;
              h++;
              if(i==hashKey)
               return;
          }
          keys[i]=null;
          values[i]=null;
          for(i=(i+h*h)%maxSize;keys[i]!=null;i=(i+h*h++)%maxSize){
              if(keys[i].equals(key)){
                  String t1=keys[i],t2=values[i];
                  keys[i]=values[i]=null;
                  insert(t1,t2);
                  currentSize--;
              }
              
          }
          currentSize--;
     }
     
    public void display(){
        for(int i=0;i<maxSize;i++){
            if(keys[i]!=null){
                System.out.println("Key:"+keys[i]+" Value:"+values[i]);
            }
        }
    }
    
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Enter the size of Hash Table");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		HashTable h1=new HashTable(size);
		System.out.println("1 Insert key and data\n2 Search the key\n3 Delete the key from HashTable\n4Display\n5Exit");
		int choice;
		do{
		        System.out.println("Enter your choice");
		    	choice=sc.nextInt();
		    	if(choice==1){
		    	    System.out.println("Enter the key and value");
		    	    h1.insert(sc.next(),sc.next());
		    	}
		    	else if(choice==2){
		    	    System.out.println("Enter the key to be searched");
		    	    String value=h1.search(sc.next());
		    	    if(value==null)
		    	     	System.out.println("Invalid Key");
		    	 	else{
		    	 	    System.out.println("Value: "+value);
		    	 	}
		    	}
		    	else if(choice==3){
		    	      System.out.println("Enter the key to be deleted");
		    	      h1.delete(sc.next());
		       }
		       else if(choice==4)
		           h1.display();
		       
		       else if(choice==5)
		        break;
		       
		       else 
		        System.out.println("Invalid Choice");
		}while(true);
	}
}
