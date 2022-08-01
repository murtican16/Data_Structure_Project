            
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;


public class ListLinked<AnyType> 
{
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int theSize;
   
    public ListLinked()
    {
        clear();
    }
    
    public int size()
    {
        return theSize;
    }
    
    public boolean isEmpty()
    {
        return theSize == 0;
    }
    
    public void clear()
    {
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.next = tail;
        
        theSize = 0;
    }
  
    public boolean add(String a, String b, int c)
    {
        Informations stu = new Informations(a, b, c);
        add(theSize, stu);   
        return true;         
    }
    
    private void add(int idx, Informations x)
    {
              
        Node<AnyType> p = getNode(idx);
        Node<AnyType> newNode = new Node<>( p.prev, x, p );
        newNode.prev.next = newNode;
        p.prev = newNode; 
        
        theSize++;
    }
    //************************************************* 
    public void remove(int number)
    {
       if(find_Idx(number)==-1)
         System.out.println("Index " + find_Idx(number) + "; size " + theSize);  
       else{
        Node<AnyType> p = getNode(find_Idx(number));
        p.prev.next = p.next;
        p.next.prev = p.prev;
        
        theSize--;
       }
        
    }
    
    //*************************************************  
    
   
    private Node<AnyType> getNode(int idx)
    {
        Node<AnyType> p;
            
        if( idx <= theSize / 2 )
        {
            p = head.next;
            for( int i = 0; i < idx; i++ )
                p = p.next;            
        }
        else
        {
            p = tail;
            for( int i = theSize; i > idx; i-- )
                p = p.prev;
        } 
        
        return p;
    }
    //*************************************************   
    public boolean findUser(int number){
        
        Node<AnyType> p = head.next;
        
        for(int i =0;i<theSize;i++){
          
           if(p.data.getStudent_key()==number){
               
               return true;
           }
        p=p.next;
        }  
               
       return false;
        
    }
    public int Levels(int number){
        
        Node<AnyType> p = head.next;
        int count=0;
        for(int i =0;i<theSize;i++){
          
           if(p.data.getStudent_key()==number){
               
             return count;
           }
       p=p.next;
       count++;
        }  
   return -1;
    }
    public void findUser_print(int number){
        
        
            int idx= find_Idx(number);
            int level = Levels(number);
         
        System.out.println("Level: "+ (level+1)+"\n"+
                     "Student Name: "+getNode(idx).data.getStudent_name()+"\n"+
                     "Surname: "+getNode(idx).data.getStudent_surname());
            
         
        
     
    } 
    public int find_Idx(int number){
        
        
        Node<AnyType> p = head;
        int temp = 0,i =0;
        for(i =0;i<theSize;i++){
          
           if(p.next.data.getStudent_key()== number){
               return i ;
           }
           else{
               temp=-1;
           }  
           p=p.next;
        } 
           return temp ;
      }
    //*************************************************     
    
    public void print_distinct_name(){
       
        Node<AnyType> p = head.next;        
        Node<AnyType> k;    
        String temp ;
        int count=0;
        for(int i=0;i<theSize;i++){          
            temp = p.data.getStudent_name();                   
            k=p;
            for(int j=find_Idx(k.data.getStudent_key());j>=0;j--){                  
                if(k.data.getStudent_name().equals(temp)){                                     
                    count++;
               }   
                k =k.prev;              
            }
                 
            if(count==1){
                System.out.println(temp);    } 
       p=p.next;
       count=0;
        }
    }
    
    //************************************************* 

    private LinkedList allName(){
         
        LinkedList<String> name = new LinkedList<>();
         Node<AnyType> p = head.next;        
        for(int i =0;i<theSize;i++){
             
        name.add(p.data.getStudent_name());
        p = p.next;
            
        }
        return name;
        
    }
  //************************************************* 
    private LinkedList distinct_name(){
        LinkedList<String> name = new LinkedList<>();
        Node<AnyType> p = head.next;        
        Node<AnyType> k;    
        String temp ;
        int count=0;
        for(int i=0;i<theSize;i++){          
            temp = p.data.getStudent_name();                   
            k=p;
            for(int j=find_Idx(k.data.getStudent_key());j>=0;j--){                  
                if(k.data.getStudent_name().equals(temp)){                                     
                    count++;
               }   
                k =k.prev;              
            }
                 
            if(count==1){                 
               name.add(temp);
            } 
       p=p.next;
       count=0;
        }
   return name;
    }
    public void distinct_count(){
       
        int count =0;
       int i=0,j=0;
      
        System.out.print("{");
       for(i =0;i<distinct_name().size();i++){
           for( j =0;j<allName().size();j++){
               if(distinct_name().get(i).equals(allName().get(j))){
                   count++;
               }
           }
           System.out.print(distinct_name().get(i)+"="+count);
           System.out.print(" ");
           count=0;
       }
        System.out.print("}\n");
           }
   //***************************************************
   
    public String toString(){
         
          String rStr ="<><><><><><><><><><><><><><><><>\n";
         Node<AnyType> temp = head.next;
        for(int i=0; i<theSize; i++)
        {    
            rStr = rStr +"["+(i+1)+"]"+"--->  "+ temp.data.getStudent_key() + " ";
            rStr = rStr + temp.data.getStudent_name()+ " ";
            rStr = rStr + temp.data.getStudent_surname() + " \n";
            temp = temp.next;
        }    
        rStr = rStr + "<><><><><><><><><><><><><><><><>";
         return rStr;
     }
   
    //************************************************* 
  
    
    private class Node<AnyType>
    {
        private Node<AnyType> prev;
        private Informations data;
        private Node<AnyType> next;
        
        public Node(Node<AnyType> p, Informations d, Node<AnyType> n)
        { 
            prev = p;
            data = d;
            next = n;
        }
    }
}