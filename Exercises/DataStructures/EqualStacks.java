import java.util.*;

class EqualStacks{


    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        // solution is to keep track on sum of list and compare then subtract on each iteration
        int h1s = 0;
        int h2s = 0;
        int h3s = 0;
        int min = -1;
        for(int i : h1){
            h1s+=i;
        }
        for(int i : h2){
            h2s+=i;
        }
        for(int i : h3){
            h3s+=i;
        }

        while(h1s != h2s ||  h2s != h3s){
            min = Math.min(h1s, Math.min(h2s, h3s));
           
            if(h2s> min){
                h2s-=h2.remove(0);
            }
            if(h1s> min){
                h1s-=h1.remove(0);
            }
            if(h3s> min){
                h3s-=h3.remove(0);
            }
            //System.out.println(String.format("H1: %1$s, H2: %2$s, H3: %3$s",  h1s,h2s,h3s));
        }
        
        return min;
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

        int[] arr2 = new int[]{0};//{4,3,2};
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