package SlidingWindow;

public class longestOnes {
    
    public static int longestOnes(int []nums,int k){

        int n=nums.length;

        int zeroCount=0;
        int front =0;

        int longest=0;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[front]==0){
                    zeroCount--;
                }
                front++;
            }
            longest=Math.max(longest,i-front+1);

        }
        return longest;
    }
    public static void main(String[] args) {
        int[]nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums, k));
    }
}
