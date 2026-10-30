import java.util.*;
public class Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();}

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(arr[i] % 2 == 0) {
                    list.add(arr[i]);
                }

            }

            for(int i = 0; i < n; i++) {
                if(arr[i] % 2 != 0) {
                    list.add(arr[i]);
                }
            }

            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            
    }
}
