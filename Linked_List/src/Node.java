public class Node {
    private int info;
    Node next;
    Node prev;
    Node(int x) {
        info = x;
        prev = null;
        next = null;
    }
    public void terminate()
    {
        info = 0;
        prev = null;
        next = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    
}