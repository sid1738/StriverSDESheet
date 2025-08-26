package SlidingWindow;

public class NumSubarraysWithSum {


    public static int atMost(int[] nums, int goal) {
        
        int front=0;
        int sum=0;
        int count=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            while(sum>goal && front<=i){
                sum=sum-nums[front];
                front++;
            }
            count+=(i-front+1);
        }

        return count;
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
    public static void main(String[] args) {
        int[]nums={0,0,0,0,0};
        int goal=0;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
