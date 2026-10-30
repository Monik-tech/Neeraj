import java.util.*;
public class FirstNegOfEveryWindow {
    public static void main(String[] args) {
        int arr[] = {12,-1,-7,8,-15,30,16};
        int k = 3;

        Queue<Integer>q = new LinkedList<>();
        ArrayList<Integer>res = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                q.add(i);
            }

            if(!q.isEmpty() && q.peek()<=i-k){
                q.remove();
            }

            if(i >= k-1){
                if(!q.isEmpty()){
                    res.add(arr[q.peek()]);
                }
                else{res.add(0);}
            }

        }
        System.out.println(res);
    }
}
