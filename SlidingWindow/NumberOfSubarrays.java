package SlidingWindow;

public class NumberOfSubarrays {
    

    public static int atMost(int[] nums, int k) {
        
        int front=0;
        int count=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                k--;
            }

            while(k<0 && front<=i){

                if(nums[front]%2==1){
                    k++;
                }
                front++;
            }

            count+=(i-front+1);
        }

        return count;
    }
    public static int numberOfSubarrays(int[] nums, int k) {

        return atMost(nums,k)-atMost(nums,k-1);
    }

    public static void main(String[] args) {
        int[]nums={2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
