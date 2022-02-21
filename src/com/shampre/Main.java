package com.shampre;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String result = null;
        String s=s = "aab", p = "c*a*b";
        Solution1 solution = new Solution1();
        result=String.valueOf(solution.isMatch(s,p));
        System.out.println("result:\n"+result);
    }
}
