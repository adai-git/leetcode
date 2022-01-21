package com.shampre.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = -1;

//        构造长度为奇数得字符串
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

//        各个位置得最长回文字串臂长n（2n+1）
        List<Integer> arm_len = new ArrayList<Integer>();

//        最大右边界
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
//            当前臂长
            int cur_arm_len;

//            最大右边界大于当前位置
            if (right >= i) {
//                当前位置关于拥有最大右边界的位置的对称位置
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);

//            更新最大右边界
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }

//            更新最大回文子串信息
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

//        返回最大回文字串
        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    /**
     * 中心扩展函数
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}