package com.shampre;

import com.shampre.demo10.Solution;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String result = null;
        String s=s = "aab", p = "c*a*b";
        Solution solution = new Solution();
        result=String.valueOf(solution.isMatch(s,p));
        System.out.println("result:\n"+result);
    }
}
