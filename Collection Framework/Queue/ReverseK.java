import java.util.*;
public class ReverseK {
    public static void main(String[] args) {
        Queue<Integer>q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        int k = 3;

        System.out.println("Before: " + q);
        reverse(q,k);
        System.out.println("After: " + q);
    }

    public static void reverse(Queue<Integer>q,int k){
        if(k<=0 || k>q.size()){
            return;
        }

        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < k; i++){
            st.push(q.poll());
        }

        while(!st.isEmpty()){
            q.offer(st.pop());
        }

        int remain = q.size()-k;
        for(int i = 0; i < remain; i++){
            q.offer(q.poll());
        }
    }
}
