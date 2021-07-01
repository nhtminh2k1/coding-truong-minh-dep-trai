
import java.io.File;
import java.util.Scanner;


public class MusicList {

    public MusicNode head, tail;

    public MusicList() {
        head = tail = null;
    }

    //kiem tra rong
    public boolean isEmpty() {
        return (head == null);
    }

    //tra ve size cua music
    public int size() {
        int count = 0;
        MusicNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    //them vao cuoi
    public void addLast(Music x) {
        MusicNode p = new MusicNode(x);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public void scanFile(Scanner scannerFile) {
        int count = 0;
        try {
            //read file
            while (scannerFile.hasNextLine()) { //kiem tra co dong tiep theo khong thi dung
                String line = scannerFile.nextLine();
                //divide word into array
                String arr[] = line.split(" | ");
                for (String s : arr) {
                    System.out.print(s);
                    count++;
                }
                System.out.println();//xuong dong
            }
            if (count == 0) {
                System.out.println("Can not found in file");
            }
        } catch (Exception e) {
        }
    }

    public void traverse() {
        MusicNode p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }
    // DAT TEN SAI ( HAM SORT -> return head) 
    public int findMaxByRated() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                MusicNode pi = get(i), pj = get(j);
                if (pi.info.getRated() < pj.info.getRated()) {
                    Music t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
        // tail.info -> HEAD.INFOR 
        return head.info.getRated();
    }

    public MusicNode get(int k) {
        MusicNode p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }
    //DAT TEN SAI ( HAM FINDMAX BY RATE )
    // doi Music -> void để gọi vì để return chỉ ra 1 giá trị
    public void searchByRated() {
        for (int i = 0; i < size(); i++) {
            //if (getMusic(i).getRated()==findMaxByRated()) {
            if (get(i).info.getRated()==findMaxByRated()) {
                //return getMusic(i);
                getMusic(i);
            }
        }
        return ;
    }

    // doi thanh void de print chứ không return 
    public void getMusic(int i) {
        int count = 0;
        for (MusicNode temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                // KHONG RETURN -> in ket qua
                //return temp.info;
                System.out.println(temp.info);
            }
            count++;
        }
        return ;
    }

}
