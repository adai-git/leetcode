package com.shampre.demo5;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }

        int maxLen=1;
        int begin=0;
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;++i){
            dp[i][i]=true;
        }

        char[] sChars=s.toCharArray();
        
        for(int l=1;l<=len;++l){
            for (int i = 0; i < len; i++) {
                int j=i+l-1;
                if(j>len){
                    break;
                }
                if(sChars[i]!=sChars[j]){
                    dp[i][j]=false;
                }else{
                    if(l<4){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(maxLen<l&&dp[i][j]==true){
                    maxLen=l;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}