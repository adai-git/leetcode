package com.shampre.demo4;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sumSize=nums1.length + nums2.length;
		boolean hasSum=sumSize%2==0?true:false;
		int kLimit=sumSize/2+1;
		int[] combine = new int[kLimit];
		
		int i = 0, j = 0,k=0;
		while (i<nums1.length&&j<nums2.length&&k<kLimit) {
			if(nums1[i]<nums2[j]) {
				combine[k]=nums1[i];
				++k;
				++i;
			}else {
				combine[k]=nums2[j];
				++k;
				++j;
			}
		}
		while(i<nums1.length&&k<kLimit) {
			combine[k]=nums1[i];
			++i;
			++k;
		}
		while(j<nums2.length&&k<kLimit) {
			combine[k]=nums2[j];
			++j;
			++k;
		}
		
		double result=0D;
		if(hasSum) {
			result=(combine[kLimit-1]+combine[kLimit-2])/2.0D;
		}else {
			result=combine[kLimit-1];
		}
		return result;
	}
}
