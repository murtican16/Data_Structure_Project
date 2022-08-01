
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args) {
    
    ListLinked<Informations> link = new ListLinked<>();
    Tree<Informations> tree = new Tree<>();
    Hash<Informations> hash = new Hash<>();
    Scanner scan = new Scanner(System.in);
    
 String  menu = "select operation from below  menu \n"+
               "0) Exit\n"+
               "1) Add Student\n"+
               "2) Delete Student\n"+
               "3) Find Student\n"+
               "4) List All Student\n"+
               "5) List Distinct Student\n"+
               "6) List Name Count\n"+
               "7) About";
    
    while(true){
          
       System.out.println("*************************************");
       System.out.println(menu);
       System.out.println("*************************************");
       int trans = scan.nextInt();
       switch(trans){
       
           case 0:System.out.println("Quit...");
            return;
            //****************************************************** 
           case 1: 
               System.out.println("Student ID: ");
               int id = scan.nextInt();
               scan.nextLine();
               System.out.println("Student Name ");
               String name = scan.nextLine();    
               System.out.println("Student Surname ");
               String surname = scan.nextLine();
               hash.add(name, surname, id);
               link.add(name, surname, id);
               tree.add(name, surname, id);
               break;
            //****************************************************** 
           case 2:
               System.out.println("Which student ID you want to delete ");
               int stu_id = scan.nextInt();
                hash.remove(stu_id);
                link.remove(stu_id);
                tree.remove(stu_id);
               break;
            //****************************************************** 
           case 3:
               System.out.println("Which student ID you want to find ");
               int stu_id_find = scan.nextInt();
               if(link.findUser(stu_id_find)==false){
                   System.out.println("User not found ...");
               }
               else{
               System.out.println("---------List---------"); 
               link.findUser_print(stu_id_find);
               System.out.println("----------Tree--------"); 
               tree.findUser_print(stu_id_find);
                System.out.println("---------Hash---------"); 
               hash.find_user(stu_id_find);
               }
            break;
            //******************************************************  
           case 4:
                System.out.println("Which structure Do you want to continue ?\n"+
                                   "1-List\n"
                                 + "2-Tree\n"
                                 + "3-Hash"); 
                    int k = scan.nextInt();
               if(k==1)
                System.out.println(link);
               else if(k==2){
                   System.out.println("----INORDER----");
                     tree.printInorder();
                        System.out.println("----POSTORDER----");  
                           tree.printPostorder();
                               System.out.println("----PREORDER----");   
                                   tree.printPreorder();
               }
               else if(k==3)
               hash.printHashTable();
               else
                   System.out.println("Please choose one of theese");
               break;
            //****************************************************** 
           case 5:
                  System.out.println("----HASH-----"); 
                     hash.distinct();
                        System.out.println("----TREE-----"); 
                            tree.print_noDup();
                               System.out.println("----LİST-----"); 
                                   link.print_distinct_name();
            break;
            //****************************************************** 
           case 6:
               System.out.println("----HASH-----"); 
                    hash.count_name();
                        System.out.println("----TREE-----"); 
                           tree.print_dupCount();
                              System.out.println("----LİST-----"); 
                                  link.distinct_count();
                                    
            break;
            //****************************************************** 
           case 7:
                System.out.println("------------------\n"+
                           "180316042     ****\n"
                         + "Muratcan      ****\n"
                         + "Erek          ****\n"
                         + "------------------");
            break;
            default: 
                System.out.println("Please Enter valid number !!");
            break;
       }  
 
   



    
    
    
    
    
    
    
    
} 
}
}
