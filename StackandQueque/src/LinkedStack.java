import static java.lang.System.exit;
import java.util.EmptyStackException;

public class LinkedStack {
    Node1 head;
  public LinkedStack(){
      head = null;
  }

      //1
      public boolean isEmpty() {
          return (head == null);
      }

      //2
      public void clear() {
          head = null;
      }

      //3
      public void push(int x) {
          head = new Node1(x, head);
      }

      //4
      public int pop() throws EmptyStackException {
          if (isEmpty()) {
              throw new EmptyStackException();
          }
          int x = (int) head.info;
          head = head.next;
          return (x);
      }

      //5
      public int top() throws EmptyStackException {
          if (isEmpty()) {
              throw new EmptyStackException();
          }
          return (int) (head.info);
      }

      ///6/
      public void display() {
          // check for stack underflow
          if (head == null) {
              System.out.printf("\nStack Underflow");
              exit(1);
          } else {
              Node1 temp = head;
              while (temp != null) {

                  // print node data
                  System.out.printf("%d ", temp.info);

                  // assign temp link to temp
                  temp = temp.next;
              }
          }
      }

      //7 
      public void decToBin(int k){
          LinkedStack s= new LinkedStack();
          System.out.println();
          System.out.print(k + " in binary system is: ");
        while(k>0){
            s.push(new Integer(k%2));
            k=k/2;
        }
        while(!s.isEmpty())
            System.out.print(s.pop());
            System.out.println();
    }
}
