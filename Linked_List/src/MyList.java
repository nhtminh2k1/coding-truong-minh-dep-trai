
public class MyList {

    Node head;
    Node tail;
    int size;

    // contructor
    public MyList() {
        head = null;
        tail = null;
        size = 0;
    }

    //check Empty linkedlist??
    public boolean isEmpty() {
        return (size == 0);
    }

    // add node to list has size = 0
    public void addFirstNode(Node p) {
        head = p;
        tail = p;
        size = 1;
    }

    // find  Node at index = index
    Node nodeAt(int index) {
        if (index > size || index < 1 || size == 0) {
            return null;
        }
        Node current = head;
        while (index > 1) {
            current = current.next;
            index--;
        }
        return current;

    }

    // 1
    public void addFirst(Node p) {
        if (isEmpty()) {
            addFirstNode(p);
            return;
        }
        head.prev = p;
        p.next = head;
        head = p;
        size++;
    }

    // 2 
    public void addLast(Node p) {
        if (isEmpty()) {
            addFirstNode(p);
            return;
        }
        tail.next = p;
        p.prev = tail;
        tail = p;
        size++;
    }

    // 3
    public void addAfter(Node p, int index) {
        Node current = nodeAt(index);
        if (current == null) {
            return;
        }
        Node next = current.next;
        current.next = p;
        p.prev = current;
        p.next = next;
    }

    // 4
    public void display() {
        System.out.println("Display list: ");
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node p = head;
            while (p != null) {
                System.out.print(p.getInfo() + "-->");
                p = p.next;
            }
            System.out.println("null");
        }
    }

    // 5
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Warning !!!!  Size of list is 0!!");
            return;
        }
        Node next = head.next;
        if (next != null) {
            next.prev = null;
        }
        head = next;
        size--;
    }

    // 6
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Warning !!!!  Size of list is 0!!");
            return;
        }
        Node prev = tail.prev;
        if (prev != null) {
            prev.next = null;
        }
        tail = prev;
        size--;
    }

    // 7
    public void deleteAfter(Node p) {
        if (isEmpty()) {
            System.out.println("Warning !!!!  Size of list is 0!!");
            return;
        }
        if (!isExist(p) || p.next == null) {
            System.out.println("This node doesn't exist in LL or p is end of List");
            return;
        }
        delete(p.next);
    }

    // 8 delete value
    public void deleteValue(int value) {
        if (isEmpty()) {
            return;
        }
        Node prev;
        Node current = head;
        while (current != null) {
            prev = current;
            current = current.next;
            if (prev.getInfo() == value) {
                delete(prev);
            }
        }

    }

    //9
    public Node search(int value) {
        if (isEmpty()) {
            System.out.println("size == 0");
            return null;
        }
        Node current = head;
        while (current != null) {
            if (current.getInfo() == value) {
                return current;
            }
            current = current.next;

        }
        return current;
    }

    //10
    public int count() {
        return size;
    }

    //11 dele index;
    public void delete(int index) {
        Node current = nodeAt(index);
        if (current == null) {
            return;
        }
        delete(current);
    }

    //12
    public void sort() {
        int n = count();
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                Node pi = nodeAt(i);
                Node pj = nodeAt(j);
                if (pi.getInfo() > pj.getInfo()) {
                    int temp = pj.getInfo();
                    pj.setInfo(pi.getInfo());
                    pi.setInfo(temp);
                }
            }
        }
    }

    // 13
    public void delete(Node p) {
        Node prev = p.prev;
        Node next = p.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        p.terminate();
    }

    //14
    public int[] parseArray() {
        int[] array = new int[size];
        Node current = head;
        if (isEmpty()) {
            return array;
        }
        int index = 0;
        while (current != null) {
            array[index] = current.getInfo();
            current = current.next;
            index++;
        }
        return array;
    }

    //15  same with 17
    
    
    // 16
    
    public void addBefore(Node p,int index)
    {
        Node current = nodeAt(index);
        if(current == null ) return ;
        if(current.prev== null) addFirst(p);
        else addAfter(p, index-1);
    }
    
    
    //17
    public MyList concat(MyList a, MyList b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        a.tail.next = b.head;
        b.head.prev = a.tail;
        return a;
    }

    //18
    // bool check Node p exists in LL
    public boolean isExist(Node p) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current == p) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 23 insert x 
    public void insert(int value) {
        Node p = new Node(value);
        addLast(p);
    }

    // 24 inverse
    public void inverse() {
        int n = count();
        for (int i = 1; i <= n / 2; ++i) {
            int j = n - i + 1;
            Node pi = nodeAt(i);
            Node pj = nodeAt(j);

            int temp = pj.getInfo();
            pj.setInfo(pi.getInfo());
            pi.setInfo(temp);
        }
    }
    
    
    // is exist infor
    
    public boolean isExistInfo(int value)
    {
        if (size == 0) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.getInfo() == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // 25
    public boolean sameInfo(MyList a , MyList b)
    {
        if(a.isEmpty()) return false;
        Node current = head;
        while(current != null)
        {
            if(b.isExistInfo(current.getInfo())) return true;
            current = current.next;
        }
        return false;
    }
    //
    

}
