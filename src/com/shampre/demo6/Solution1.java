package com.shampre.demo6;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P   I   N
 * A L S I G
 * Y A H R
 * P   I
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if (s.length() < 2) {
            return s;
        }
        String[] strArrs = new String[numRows];
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows; ++j) {
                if (i < s.length()) {
                    char tempChar = s.charAt(i);
                    strArrs[j] += tempChar;
                    ++i;
                }
            }
            for (int z = numRows - 2; z > 0; --z) {
                if (i < s.length()) {
                    char tempChar = s.charAt(i);
                    strArrs[z] += tempChar;
                    ++i;
                }
            }
        }
        String result = "";
        for (int l = 0; l < numRows; ++l) {
            result += strArrs[l];
        }
        return result.replaceAll("null", "");
    }
}
