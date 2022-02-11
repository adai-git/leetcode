package com.shampre.demo10;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] charArrS = s.toCharArray();
        char[] charArrP = p.toCharArray();
        int indexS = 0;
        int indexP = 0;
        boolean hasCompliant = true;
        while (hasCompliant) {
            char charS = charArrS[indexS];
            char charP = charArrP[indexP];
            if (charS == charP) {
                indexS++;
                indexP++;
            } else if (charP == '.') {
                indexS++;
                indexP++;
            } else if (charP == '*') {
                if (charArrP[indexP - 1] != '.') {
                    if (charArrP[indexP - 1] != charArrS[indexS - 1]) {

                    } else if (charArrS[indexS - 1] != charS) {

                    }
                }

                if (charS == charArrS[indexS]) {
                    indexS++;
                }
            } else {
                return false;
            }
        }
        return hasCompliant;
    }
}
