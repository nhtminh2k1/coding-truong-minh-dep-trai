package assignmentcdd;


public class MyList {
      Node head;
    Node tail;
    int size;

    public MyList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void addToHead(Song x) {
        if (size == 0) {
            head = tail = new Node(x);
            size = 1;
        }
        else {
            Node p = new Node(x);
            p.next = head;
            head = p;
            size++;
        }
    }
    
    public void traverse() {
        System.out.println("Display list: ");
        if (size == 0) {
            System.out.println("List is empty");
        }
        else {
            Node curNode = head;
            while (curNode != null) {
                System.out.println(curNode.toString());
                curNode = curNode.next;
            }
        }
    }
    
    public boolean checkEqual(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    
    public Node search(String x) {
        Node curNode = head;
        while (curNode != null) {
            if (checkEqual(curNode.info.name, x)) return curNode;
            curNode = curNode.next;
        }
        return null;
    }
    
    public void dele(String x) {
        Node p = search(x);
        if (p != null) {
            Node curNode = head;
            while (curNode != null) {
                if (checkEqual(curNode.info.name, x)) {
                    curNode.next = p.next;
                    size--;
                    break;
                }
                curNode = curNode.next;
            }
        }
    }
    
}
