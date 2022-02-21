package com.shampre.demo10;

/**
 * 正则表达式匹配
 * 方法一：动态规划
 * 思路与算法
 *
 * 题目中的匹配是一个「逐步匹配」的过程：我们每次从字符串 pp 中取出一个字符或者「字符 + 星号」的组合，
 * 并在 ss 中进行匹配。对于 pp 中一个字符而言，它只能在 ss 中匹配一个字符，匹配的方法具有唯一性；而
 * 对于 pp 中字符 + 星号的组合而言，它可以在 ss 中匹配任意自然数个字符，并不具有唯一性。因此我们可以
 * 考虑使用动态规划，对匹配的方案进行枚举。
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}