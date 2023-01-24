import java.util.*;
class HashTable{
    
    private String keys[];
    private String values[];
    private int maxSize; 
    private int currentSize=0; 
     
    //Initialising the size of arrays and maxSize
    HashTable(int maxSize){
        this.maxSize=maxSize;
        keys=new String[maxSize]; 
        values=new String[maxSize];
        for(int i=0;i<maxSize;i++){
            keys[i]=null;
            values[i]=null;
        }
    }
    
    //To get the size of hash table
    public int getSize(){
        return currentSize;
    }
    
    //To check if the hash table is full or not
    public boolean isFull(){
        if(currentSize==maxSize)
         return true;
        return false;
    }
    
    //To check if the hash table is empty or not
     public boolean isEmpty(){
        if(currentSize==0)
         return true;
        return false;
    }
    
    //To get particular for the value for mapping in hash table
    private int hash(String key)
    {
        return key.hashCode()%maxSize;
    }
    
    public void insert(String key,String value){
        int hashKey=hash(key); 
        int i=hashKey;
        //when slot is empty
        if(keys[i]==null)
        {
            keys[i]=key;
            values[i]=value;
            currentSize++;
            return;
        }
        //when keys(String) are same,update the value 
        if(keys[i].equals(key)){
            values[i]=value;
            return;
        }
        i=(i+1)%maxSize;
        while(i!=hashKey){
            if(keys[i]==null){
               keys[i]=key;
               values[i]=value; 
               currentSize++;
               return;
            }
            if(keys[i].equals(key)){
            values[i]=value;
            return;
           }
            i=(i+1)%maxSize;
        }
    }
    
    public String search(String key){
         int hashKey=hash(key);
         int i=hashKey;
         if(keys[i]==null)
          return null;
         if(keys[i].equals(key))
          return values[i];
         i=(i+1)%maxSize;
         while(i!=hashKey){
             if(keys[i]==key){
              return values[i];
             }
             i=(i+1)%maxSize;
         }
         return null;
    }
    
    public void delete(String key){
        int hashKey=hash(key);
        int i=hashKey;
        if(keys[i]==null){
         System.out.println("Invalid key");
         return;
        }
        while(!key.equals(keys[i])){
            i=(i+1)%maxSize;
            if(i==hashKey){
              System.out.println("Invalid key");
              return;
            }
        }
        keys[i]=null;
        values[i]=null;
        
        for(i=(i+1)%maxSize;keys[i]!=null;i=(i+1)%maxSize){
            String temp1=keys[i];
            String temp2=values[i];
            keys[i]=null;
            values[i]=null;
            currentSize--;
            insert(temp1,temp2);
        }
        currentSize--;
    }
    
    public void display(){
        System.out.println("Displaying the hash table");
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
