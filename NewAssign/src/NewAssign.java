
import java.util.*;

public class NewAssign {

    

    public static void main(String[] args) {

       MyList listNumber = new MyList();
        listNumber.addToTail(2);
        listNumber.addToTail(4);
        listNumber.addToTail(5);
        listNumber.addToTail(1);
        listNumber.addToTail(7);
        listNumber.addToTail(6);
        //listNumber.addToHead(0);
        // listNumber.display();
        // listNumber.head = listNumber.mergeSort(listNumber.head);
        // listNumber.display();
        // listNumber.head = listNumber.reverse(listNumber.head);
        // listNumber.display();
        //Node p = new Node();
        //p = listNumber.search(2);
        //listNumber.addBefore(p, 10);
        listNumber.display();

        System.out.println("---");
        listNumber.sort(1, 4);
        listNumber.display();

        listNumber.mergeSort();
        listNumber.display();
        
        System.out.println(listNumber.max());
        
        System.out.println(listNumber.maxSecond()+"--");
        listNumber.deleteAll();
        listNumber.display();
        
    }

}
