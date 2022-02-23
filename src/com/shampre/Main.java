package com.shampre;

import com.shampre.demo11.Solution;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String result = null;
        String s=s = "aab", p = "c*a*b";
        int[] arrs= {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        result=String.valueOf(solution.maxArea(arrs));
        System.out.println("result:\n"+result);
    }
}
