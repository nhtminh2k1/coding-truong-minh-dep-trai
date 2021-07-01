
import com.sun.org.apache.bcel.internal.generic.LLOAD;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment15 {

    Node head;

    // Create a node
    class Node {

        int item;
        Node next;

        Node(int d) {
            item = d;
            next = null;
        }
    }

    public void insertAtBeginning(int data) {
        // insert the item
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new Node(data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        return;
    }

    void deleteNode(int position) {
        if (head == null) {
            return;
        }

        Node node = head;

        if (position == 0) {
            head = node.next;
            return;
        }
        // Find the key to be deleted
        for (int i = 0; node != null && i < position - 1; i++) {
            node = node.next;
        }

        // If the key is not present
        if (node == null || node.next == null) {
            return;
        }

        // Remove the node
        Node next = node.next.next;

        node.next = next;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("src\\data\\song.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
