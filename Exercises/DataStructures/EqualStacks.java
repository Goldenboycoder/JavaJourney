import java.util.*;

class EqualStacks{


    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        // solution is to keep track on sum of list and compare then subtract on each iteration
        int res = 0;
        int h1s = h1.forEach(null);
        return res;
    }
    

    public static void main(String[] args) {
        //
        List<Integer> h1 = new Stack<Integer>();
        List<Integer> h2 = new Stack<Integer>();
        List<Integer> h3 = new Stack<Integer>();

        int[] arr1 = new int[]{3, 2, 1, 1, 1};
        for (int arr12 : arr1) {
            h1.add(arr12);
        }

        int[] arr2 = new int[]{4,3,2};
        for (int arr12 : arr2) {
            h2.add(arr12);
        }

        int[] arr3 = new int[]{1,1,4,1};
        for (int arr12 : arr3) {
            h3.add(arr12);
        }

        
        System.out.println(equalStacks(h1, h2, h3));
    }
}