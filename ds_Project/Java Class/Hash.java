
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;




public class Hash<AnyType> {
    
    private static final int DEFAULT_TABLE_SIZE = 10;

        private LinkedList<Informations>[] theLists; 
    
    public Hash()
    {
        theLists = new LinkedList[DEFAULT_TABLE_SIZE];
        
        for(int i=0; i<theLists.length; i++)     
            theLists[i] = new LinkedList<>();    
    }

    public void add(String a,String b,Integer c)
    {
        Informations ınf = new Informations(a, b, c);
        LinkedList<Informations> whichList = theLists[myHash(c)];
        
        if(!containss(c)){
             whichList.add(ınf);
        }
    //*******************************************************
    }
    public void remove(Integer c)
    {
        LinkedList<Informations> whichList = theLists[myHash(c)];
        
        if(containss(c))  {     
            int s = find_idx(c);
            if(s == -1){
                System.out.println("There is no user for this number");
            }
            whichList.remove(s);
        }
    }
     //*******************************************************
    
    public int find_idx(Integer c){
        LinkedList<Informations> whichList = theLists[myHash(c)];
        for(int i =0;i<whichList.size();i++){
            if(whichList.get(i).getStudent_key()==c){
                
                return i;
            }
            
        }
       return  -1;
    }
    //*******************************************************
    public boolean containss(Integer c)
    {
        LinkedList<Informations> whichList = theLists[myHash(c)];
	 for(int i= 0 ;i<whichList.size();i++){
             if(whichList.get(i).getStudent_key()==c){
                 return true;
             }
         }
            
              return false;  
    }
    //*******************************************************
    public void find_user(Integer c){
        LinkedList<Informations> whichList = theLists[myHash(c)];
         int s = find_idx(c);
      
        System.out.println("Levels: "+(s+1));
        System.out.println("Student Name: "+whichList.get(s).getStudent_name());
        System.out.println("Surname: "+whichList.get(s).getStudent_surname());
                          
    }
    public LinkedList distinct_name(){
        LinkedList<String> names = new LinkedList<>();
        LinkedList<Informations> whichList;
        
        for(int i=0; i<theLists.length; i++)
        {
            whichList = theLists[i];        
            for(int j=0; j<whichList.size(); j++) {                                                                                
            names.add(whichList.get(j).getStudent_name());
              
            }    
        }       
    return names;
    }
    public void distinct(){
       
        HashSet<String> list = new HashSet<String>(distinct_name());
        for(String temp : list){
            System.out.println(temp);
        }
    }
   //*******************************************************
   
    public void count_name(){
        LinkedList<String> link = distinct_name();
        HashMap<String,Integer> map = new HashMap<>();
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
    
    //*******************************************************
    public void makeEmpty()
    {
        for(int i=0; i<theLists.length; i++)   
            theLists[i].clear();               
    }
    //*******************************************************
   
    public void printHashTable()
    {
        LinkedList<Informations> whichList;
        
        for(int i=0; i<theLists.length; i++)
        {
            whichList = theLists[i];
			
            System.out.print("|" + i + "|" + " --> ");            
            
            for(int j=0; j<whichList.size(); j++) {                                                                                
                System.out.print("("+whichList.get(j).getStudent_key()+
                                 ")"+whichList.get(j).getStudent_name()+" "+
                                 whichList.get(j).getStudent_surname()+" --> "); 
            }    
            
            System.out.println();                                
        }
    }
    //*******************************************************
    private int myHash(Integer x)
    {
        return (x % theLists.length);    
    }
}
