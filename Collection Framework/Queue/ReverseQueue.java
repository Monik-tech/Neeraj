import java.util.*;
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q);

        Stack<Integer>s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());  // can use q.pool()
        }

        while(!s.isEmpty()){
            q.add(s.pop());   // can use q.offer()
        }
        
        System.out.println(q);
    }
}
