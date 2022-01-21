package com.shampre.demo3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class Solution {
	/*
	 * 方法一： public int lengthOfLongestSubstring(String s) { if (s.isEmpty() ||
	 * s.equals("")) { return 0; }
	 * 
	 * int maxLength = 0, currentLength = 0; List<Character> currentCharList = new
	 * ArrayList<>();
	 * 
	 * for (int currentPosition = 0; currentPosition < s.length();
	 * ++currentPosition) { char temp = s.charAt(currentPosition);
	 * 
	 * if (!currentCharList.contains(temp)) { currentCharList.add(temp);
	 * ++currentLength; } else if (currentCharList.contains(temp)) { currentPosition
	 * = s.indexOf(temp, currentPosition - currentLength); currentLength = 0;
	 * currentCharList.clear(); }
	 * 
	 * if (maxLength < currentLength) { maxLength = currentLength; } } return
	 * maxLength; }
	 */

	/* 方法二 */
	public int lengthOfLongestSubstring(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i != 0) {
				// 左指针向右移动一格，移除一个字符
				occ.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
				// 不断地移动右指针
				occ.add(s.charAt(rk + 1));
				++rk;
			}
			// 第 i 到 rk 个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}
}
