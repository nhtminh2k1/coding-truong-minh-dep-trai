
package assignmentcdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc_console = new Scanner(System.in);
        String p = "";
        MyList list = new MyList();
        File file = new File("D:\\javaProject\\CSD\\Code review\\Assignment1.4\\src\\songs.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            p = sc.nextLine();
            // khai bao song để gán giá trị cho thuộc tính cảu song
            String[] t = p.split("\\|");
            Song s = new Song(t[0],t[1],Integer.parseInt(t[2]));
            //System.out.println(t[0] + "--" +t[1] +"--" + t[2]);
            list.addToHead(s);
            //System.out.println(p);
        }
        // them cau 2 3 4 5 
        System.out.println("question 2: ");
        list.traverse();
        
        System.out.println("question 3: ");
      String ip = sc_console.nextLine();
      for ( int i=0;i<list.size;i++){
          System.out.println("");
           Node tmp = new Node();
           tmp= list.search(ip);
           //System.out.println(tmp.info);
          list.dele(ip);
     }
       list.traverse();
        
    }
}
