package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring{

    public static int LengthOfLongestSubstring(String s){
        int n=s.length();

        Map<Character,Integer> m=new HashMap<>();

        int front=0;
        int longest=0;
        for(int i=0;i<n;i++){
           if(m.containsKey(s.charAt(i))){
            front=m.get(s.charAt(i))+1;
           }
           longest=Math.max(longest,i-front+1);
           m.put(s.charAt(i),i);
        }

        return longest;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(LengthOfLongestSubstring(s));
    }
}