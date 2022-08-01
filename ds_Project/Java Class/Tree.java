
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tree<AnyType> {

   private Node root;	
   private LinkedList<String> link = new LinkedList<>();
   private int amount = 0;
    public Tree() {
       
   }   
    //*************************************************************
    public void add(String name,String surname,int id) 
    {
        Informations stu = new Informations(name, surname, id);
        root = insertRecursively(stu, root);
    }
    
    private Node insertRecursively(Informations newValue, Node tempNode) 
    {
        if( tempNode == null )
            return new Node(null,newValue,null);
            
        if( newValue.getStudent_key() < tempNode.getData().getStudent_key())
            tempNode.setLeft(insertRecursively(newValue, tempNode.getLeft()));
        else if(newValue.getStudent_key() > tempNode.getData().getStudent_key())
            tempNode.setRight(insertRecursively(newValue, tempNode.getRight()));
        else{
            System.out.println("It is Private key so try to other thing");
        }
        return tempNode;
    }
    //*************************************************************
    public void remove(int key) 
    { 
        
        root = deleteNode(root,key);
    }
 

    //*************************************************************
    public  Node min(Node root) {
		if (root.left == null)
			return root;
		else {
			return min(root.left);
		}
	}
 
	public Node deleteNode(Node root, int number) {
		if (root == null)
			return null;
		if (root.data.getStudent_key() > number) {
			root.left = deleteNode(root.left, number);
		} else if (root.data.getStudent_key() < number) {
			root.right = deleteNode(root.right, number);
 
		} else {
			
			if (root.left != null && root.right != null) {
				Node temp = root;
				
				Node TempNode = min(temp.right);
				
				root.data = TempNode.data;
				
				root.right = deleteNode(root.right, TempNode.data.getStudent_key());
 
			}
			
			else if (root.left != null) {
				root = root.left;
			}
			
			else if (root.right != null) {
				root = root.right;
			}
			
			else
				root = null;
		}
		return root;
	}
    public Node find_node(Node root, int number) 
    {
    if (root==null || root.data.getStudent_key()==number) 
        return root; 
  
    
    if (root.data.getStudent_key() < number) {
        
       return find_node(root.right, number); 
    }
    else{
      
       return find_node(root.left, number); 
    }
    }  
    //*************************************************************
   
    public String find_name(int num){
     
       return find_node(root, num).getData().getStudent_name();
     
    }
    
    public void findUser_print(int number){
        Node Temp =find_node(root, number);            
        searchLevels(root, number);    
       
            System.out.println("Level: "+(amount+1));
         amount=0;  
        
        System.out.println("Student Name: "+Temp.data.getStudent_name());
        System.out.println("Surname: "+Temp.data.getStudent_surname());
        
     
    }
    //*************************************************************  
    
    public void searchLevels(Node root, int number)  
    { 
   
    if (root==null || root.data.getStudent_key()==number) {    
       return  ;
      }
    
    if (root.data.getStudent_key() < number) {
      amount++;      
       searchLevels(root.right, number); 
      
    }
    else{
       amount++;   
       searchLevels(root.left, number); 
 
    }
    
    }  
   
    //*************************************************************
    
    public void printPreorder()
    {
        printPreorder(root);
    }
    
    private void printPreorder(Node tempNode)
    {
        if(tempNode == null)
            return;
        
        System.out.print("-----> "+tempNode.getData().getStudent_key() + " "+
                                   tempNode.getData().getStudent_name()+" "+
                                   tempNode.getData().getStudent_surname()+"\n");
        printPreorder(tempNode.getLeft());
        printPreorder(tempNode.getRight());     
    }
    //*************************************************************
    public void printPostorder()
    {
        printPostorder(root);
    }
    
    private void printPostorder(Node tempNode)
    {
        if(tempNode == null)
            return;
        
        printPostorder(tempNode.getLeft());
        printPostorder(tempNode.getRight());    
        System.out.print("-----> "+tempNode.getData().getStudent_key() + " "+
                                   tempNode.getData().getStudent_name()+" "+
                                   tempNode.getData().getStudent_surname()+"\n");
    }
   //*************************************************************
    public void printInorder()
    {
        printInorder(root);
    }
    
    private void printInorder(Node tempNode)
    {
       if(tempNode == null)    
           return;
        
            
           
        printInorder(tempNode.getLeft());
        System.out.print("-----> "+tempNode.getData().getStudent_key() + " "+
                                   tempNode.getData().getStudent_name()+" "+
                                   tempNode.getData().getStudent_surname()+"\n");
        printInorder(tempNode.getRight());     
    }
     //*************************************************************
     public void distinct(){
     distinctname(root);
    
     }
     public void distinctname(Node root){
       
          if(root == null){     
       return;
        }
        
        distinctname(root.getLeft());
        link.add(root.data.getStudent_name());      
        distinctname(root.getRight());   
    
    }
   //*************************************************************
     public void print_noDup(){     
       link.clear();
       distinct();
      TreeSet<String> list = new TreeSet<String>(link);
      for(String temp : list){
          System.out.println(temp);
      }
     
   }  
     
   //*************************************************************
     
     public void print_dupCount(){
       link.clear();
       distinct();
       TreeMap<String,Integer> map = new TreeMap<>();
       String[] array = link.toArray(new String[link.size()]);
       int count ;
        
       for(String temp : array){
           String word = temp.toLowerCase();
      
          if(map.containsKey(word)){
              count=map.get(word);
              map.put(word,count+1);
          }
          else{
              map.put(word,1);
          }
          
       }
        System.out.println("Word count: ");
           System.out.println(map);
  
   
   }
   
   //*************************************************************  
    public boolean isEmpty() 
    {
        return root == null;
    }

  
    
    public class Node<AnyType> 
{
    private Node left;
    private Informations data;
    private Node right;

    public Node(Node l, Informations d, Node r) 
    {
        left = l;
        data = d;
        right = r;
    }

    public Node getLeft() 
    {
        return left; 
    }
    
    public Informations getData() 
    { 
        return data; 
    }

    public Node getRight() 
    {
        return right; 
    }

    public void setLeft(Node newLeft) 
    {
        left = newLeft; 
    }
    
    public void setData(Informations newData) 
    { 
        data = newData; 
    }

    public void setRight(Node newRight) 
    {
        right = newRight; 
    }
}
}
