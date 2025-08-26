package SlidingWindow;

public class characterReplacement {
    

    public static int CharacterReplacement(String s, int k) {
        
        char[]chars=s.toCharArray();

        int[]count=new int[26];

        int front=0;
        int longest=0;
        for(int i=0;i<chars.length;i++){
            count[chars[i]-'A']++;

            int maxCount=0;

            for(int j=0;j<26;j++){
                maxCount=Math.max(maxCount, count[j]);
            }

            while(i-front+1-maxCount>k){
                count[chars[front]-'A']--;
                front++;
            }
            for(int j=0;j<26;j++){
                maxCount=Math.max(maxCount, count[j]);
            }

            longest=Math.max(longest, i-front+1);
        }
        

        return longest;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(CharacterReplacement(s, k));
    }
}
