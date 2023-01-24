class node{
    private int data;
    private int key;
    private node next;
    node(int data,int key){
        this.data=data;
        this.key=key;
    }
    public int get_data(){
        return data;
    }
    public int get_key(){
        return key;
    }
    public node get_next(){
        return next;
    }
    public void set_next(node next1){
        next=next1;
    }
    
}

public class Main
{
    int size=10;
    node[] hashTable=new node[size];
    public int generateKey(int key1){
       return key1%size; 
    }
    public void insert(int key1,int data1){
        int hashKey=generateKey(key1);
        int ind=hashKey;
        node new_node=new node(data1,key1);
        if(hashTable[ind]==null){
            hashTable[ind]=new_node;
        }
        else{
            node ptr=hashTable[ind];
            while(ptr.get_next()!=null){
                ptr=ptr.get_next();
            }
            ptr.set_next(new_node);
        }
    }
    public void display(int key1){
        int hashKey=generateKey(key1);
        if(hashTable[hashKey]==null)
          System.out.println("Item not found");
        else{
            node ptr=hashTable[hashKey];
            while(ptr!=null){
                System.out.print(ptr.get_data()+" ");
                ptr=ptr.get_next();
            }
        }
    }
    
    public  void delete(int key1,int data1){
         int hashKey=generateKey(key1);
         int ind=hashKey;
         
         if(hashTable[ind].get_data()==data1){
             hashTable[ind]=hashTable[ind].get_next();
         }
         else{
             node ptr=hashTable[ind];
             while(ptr.get_next().get_data()!=data1){
                 ptr=ptr.get_next();
             }
             
             ptr.set_next(ptr.get_next().get_next());
         }
    }
    public void count(int key1){
        int c=0;
         int hashKey=generateKey(key1);
          if(hashTable[hashKey]==null)
          System.out.println("Items:0");
        else{
            node ptr=hashTable[hashKey];
            while(ptr!=null){
                c++;
                ptr=ptr.get_next();
            }
        }
        System.out.println("Items:"+c);
    }
	public static void main(String[] args) {
	  Main m1=new Main();
	  m1.insert(4,676);
	  m1.insert(24,686);
	  m1.insert(24,696);
	  m1.display(4);
	  m1.count(4);
	  System.out.println();
	  m1.delete(4,696);
	  m1.display(4);
	  m1.count(4);
	}
}
