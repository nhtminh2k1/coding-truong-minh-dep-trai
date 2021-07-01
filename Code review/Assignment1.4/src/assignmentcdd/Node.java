
package assignmentcdd;


public class Node {
     Song info;
    Node next;

    public Node() {
    }

    public Node(Song info) {
        this.info = info;
        this.next = null;
    }

    @Override
    public String toString() {
        return info.name + "|" + info.artist + "|" + info.Rated;
    }
}
