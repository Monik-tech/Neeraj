import java.util.*;
public class Queue2 {
    public static void main(String[] args) {
        Queue<String>q = new LinkedList<>();
        q.add("A");
        q.add("B");
        q.add("C");
        System.out.println(q);

        Queue<Integer>q1 = new LinkedList<>();
        q1.add(10);
        q1.offer(20);
        
    }
}
