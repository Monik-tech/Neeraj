import java.util.LinkedList;
import java.util.Queue;

public class HalfElements {
    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        System.out.println("Before: " + q);
        interLeave(q);
        System.out.println("After: " + q);
    }

    public static void interLeave(Queue<Integer>q){
        int n = q.size();
        Queue<Integer>fh = new LinkedList<>();
        for(int i = 0; i < n/2; i++){
            fh.offer(q.poll());
        }

        while(!fh.isEmpty()){
            q.offer(fh.poll());
            q.offer(q.poll());
        }
    }
}
