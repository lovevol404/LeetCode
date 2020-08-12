package solution;/*solution.MedianSortedArrays.java
Copyright 2011-2020 Qunhe Tech, all rights reserved.
Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.

@Author: tianming
@created: 2020/4/16
*/

/**
 * @author tianming
 */
public class MedianSortedArrays {
    public static void main(String[] args) {

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0) {
            if (length2 == 1) {
                return nums2[0];
            }
            if (length2 % 2 != 0) {
                return nums2[length2 / 2];
            }
            return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) * 1.0 / 2;
        }
        if (length2 == 0) {
            if (length1 == 1) {
                return nums1[0];
            }
            if (length1 % 2 != 0) {
                return nums1[length1 / 2];
            }
            return (nums1[length1 / 2 - 1] + nums1[length1 / 2]) * 1.0 / 2;
        }

        int allLength = length1 + length2;

        boolean evenLength = allLength % 2 == 0;

        int[] nums = new int[allLength];

        int i = 0, j = 0, k = 0;

        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                k++;
                i++;
            } else {
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i < length1) {
            nums[k] = nums1[i];
            k++;
            i++;
        }
        while (j < length2) {
            nums[k] = nums2[j];
            k++;
            j++;
        }
        if (evenLength) {
            return (nums[allLength / 2 - 1] + nums[allLength / 2]) * 1.0 / 2;
        }
        return nums[allLength / 2];
    }
}
