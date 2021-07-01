
import java.util.Arrays;
import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* excercise1,calculate sum*/
        System.out.println("Excercise1:");
        int n = sc.nextInt();
        int result = sum(n);
        System.out.println(result);
        /* excercise2,find min in array*/
        System.out.println("Excercise2:");
        int b = sc.nextInt();
        int[] a = new int[b];
        for (int i = 0; i < b; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = sc.nextInt();

        }

        System.out.println(findMinRec(a, b));
        /* excercise3,calculate sum in array*/
        System.out.println("Excercise3:");
        int y = sc.nextInt();
        int[] x = new int[y];
        for (int i = 0; i < y; i++) {
            System.out.printf("x[%d] = ", i);
            x[i] = sc.nextInt();

        }
        System.out.println(findSumRec(x, y));
        /* excercise4,check palindrome in array*/
        System.out.println("Excercise4:");
        int c = sc.nextInt();
        int[] arr = new int[c];
        for (int i = 0; i < c; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = sc.nextInt();

        }
        if (isPalRec(arr, 0, c - 1) == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        /* excercise5,binary search and sort array*/
        System.out.println("Excercise5:");
        Recursion ob = new Recursion();
        int ars[] = {2, 3, 4, 40, 10};
        int h = ars.length;
        int z = 10;
        int result2 = ob.binarySearch(ars, 0, h - 1, z);
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result2);
        }
        insertionSortRecursive(ars, ars.length);

        System.out.println(Arrays.toString(ars));
        /* excercise6,GCD*/
        System.out.println("Excercise6:");
        System.out.println(GCD(20, 4));
        /* excercise7,POW*/
        System.out.println("Excercise7:");
        System.out.println(pow(5, 4));
        /* excercise8,FACT*/
        System.out.println("Excercise8:");
        System.out.println(fact(4));
        /* excercise9,FIBO*/
        System.out.println("Excercise9:");
        System.out.println(Fibonacci(5));
        /* excercise10,ADD Reciprocals*/
        System.out.println("Excercise10:");
         System.out.println(addReciprocals(4));
        /* excercise11,Stirling numbers*/
        System.out.println("Excercise11:");
        System.out.println(StirlingNumbers(5,3));
        
         /* excercise12AND13,Tree height and size*/
         System.out.println("Excercise12and13:");
        binaryTree bt = new binaryTree();
        bt.root = new Node(3);
        bt.root.left = new Node(4);
        bt.root.right = new Node(4);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(2);
        System.out.println("The size of binary tree is : " + bt.size());
        System.out.println("The height of binary tree is : " + bt.height());
    }

    public static int sum(int n) {
        if (n > 0) {
            return n + sum(n - 1);
        } else {
            return 0;
        }
    }

    public static int findMinRec(int a[], int b) {

        if (b == 1) {
            return a[0];
        }

        return Math.min(a[b - 1], findMinRec(a, b - 1));
    }

    public static int findSumRec(int x[], int y) {

        if (y > 0) {
            return findSumRec(x, y - 1) + x[y - 1];
        } else {
            return 0;
        }
    }

    public static int isPalRec(int arr[], int begin, int end) {

        if (begin >= end) {
            return 1;
        }
        if (arr[begin] == arr[end]) {
            return isPalRec(arr, begin + 1, end - 1);
        } else {
            return 0;
        }
    }

    int binarySearch(int ars[], int l, int r, int z) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (ars[mid] == z) {
                return mid;
            }

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (ars[mid] > z) {
                return binarySearch(ars, l, mid - 1, z);
            }

            // Else the element can only be present
            // in right subarray
            return binarySearch(ars, mid + 1, r, z);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    static void insertionSortRecursive(int arr[], int n) {
        // Base case
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        insertionSortRecursive(arr, n - 1);

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n - 1];
        int j = n - 2;

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    private static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }

    private static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = pow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return temp * temp * x;
    }
    private static int fact (int n) {
        if ( n <= 1 ) return 1; 
        return n*fact(n-1);
    }
    private static int Fibonacci(int n){
        if ( n <=2  ) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    private static double addReciprocals(int n){
        double zero = 0.0, _n = n;
        if(n==0) 
            return zero;
        return (double)(1/_n) + addReciprocals(n-1);
    }
    private static int StirlingNumbers(int n,int k){
        if ( n == 0 && k == 0 ) return 1 ; 
        if ( n > 0 && k == 0 ) return 0;
        if (k == 1 || k == n) return 1;
        return StirlingNumbers(n-1,k-1) + k*StirlingNumbers(n-1,k);
    }
    
}
