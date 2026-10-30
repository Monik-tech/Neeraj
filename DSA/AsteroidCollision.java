import java.util.*;

public class AsteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] asteroids = new int[n];
        for(int i = 0; i < n; i++){
            asteroids[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        for(int a : asteroids){
            boolean alive = true;

            while(a < 0 && !st.isEmpty() && alive && st.peek() > 0){
                if(st.peek() < -a){
                    st.pop();
                }

                else if(st.peek() == -a){
                    st.pop();
                    alive = false;
                }

                else{alive = false;}}
                if(alive){
                    st.push(a);
                }

        }

        int res[] = new int [st.size()];
        for(int i = 0; i < st.size(); i++){
            res[i] = st.get(i);
        }

        for(int i = 0 ;i < res.length; i++){
            System.out.print(res[i] + " ");
        }
}
}
