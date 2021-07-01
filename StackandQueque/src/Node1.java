
public class Node1 {
      public Object info;
    public Node1  next;
    public Node1(Object x, Node1 p)
      { info=x; next=p; }
    public Node1(Object x)
      { this(x,null); }
}
