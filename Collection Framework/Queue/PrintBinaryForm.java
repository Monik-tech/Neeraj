
import java.util.*;

public class PrintBinaryForm {
    public static void main(String[] args) {
        int n = 5;
        generate(n);
    }


public static void generate(int n){
    Queue<String>q = new LinkedList<>();
    q.offer("1");
    for(int i = 0; i <n; i++){
        String curr = q.poll();
        System.out.println(curr);
        q.offer(curr+"0");
        q.offer(curr+"1");
    }

}
}
