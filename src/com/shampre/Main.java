package com.shampre;

import com.shampre.demo8.Solution;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String result = null;
        String s="9223372036854775808";
        Solution solution = new Solution();
        result=String.valueOf(solution.myAtoi(s));
        System.out.println("result:\n"+result);
    }
}
