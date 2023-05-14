
class RemoveElement {
    
    public static void swap(int[] nums,int idx1,int idx2){
        nums[idx1] = nums[idx2];
        nums[idx2] = -1; 
    }

    public static int removeElement(int[] nums, int val) {
        int k=0;
        int lastIdx = nums.length -1;
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] == val){
                swap(nums, i, lastIdx);
                lastIdx--;
                i--;
            }
            else{
                k++;
            }
            if(i == lastIdx){
                break;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
}
