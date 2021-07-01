public class Main {
    public static void main(String[] args) {
        int[] b = {3, 10, 9, 3, 8, 3, 10};
        MyList list = new MyList();
        System.out.println("is Empty? "+list.isEmpty());
        list.display();
        Node p;
        for(int i = 0; i < b.length; i++) {
            p = new Node(b[i]);
            list.addFirst(p);
        }
        list.display();
        System.out.println("Count: "+list.size);
        
    }
    
    // 15
    
}