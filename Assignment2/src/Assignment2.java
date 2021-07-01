import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Assignment2 {

   
    public static void main(String[] args) throws FileNotFoundException {
       InteractWithFile file = new InteractWithFile();
        BinaryTree tree = new BinaryTree(); 

        tree = file.scan("product.txt");
        System.out.println("=========================");
        System.out.println("In-order traverse to file");
        tree.inorder();
     
        System.out.println("========================");
        System.out.println("Breadth-first traverse");
        tree.BFS();
        
        
        //insert file
        Product data = new Product("B0812",100);
        tree.insert(data);

        // save File 
        System.out.println("========================");
        System.out.println("save file");
        ArrayList<Product> listBook = new ArrayList<>();
        listBook = tree.toList_Inorder(listBook);
        for (Product product : listBook) {
            System.out.print(product);
        }
        file.saveFile(listBook);
        
        
        //search
        System.out.println("========================");
        System.out.println("Search follow bcode");
        BinaryTreeNode nodeTree = new BinaryTreeNode();
        nodeTree = tree.search("B0");
        System.out.println(nodeTree.infor);
        
        //delete
        System.out.println("========================");
        System.out.println("Delete follow bcode");
        tree.delete("B02");
        tree.inorder();
        
        //rotate
        System.out.println("========================");
        System.out.println("Delete follow bcode");
        
        
        //height
        System.out.println("========================");
        System.out.println("Height of product tree");
        System.out.println(tree.height());
    }
    
}
