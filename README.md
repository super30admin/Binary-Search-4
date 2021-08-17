# Binary-Search-4

## Problem1

Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

//Time Complexity = O(MlogN + MlogM + NlogN)
//Space Complexity = O(1)

class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
List<Integer> list = new ArrayList();
Arrays.sort(nums1);
Arrays.sort(nums2);
int low = 0;
for(int i = 0; i < nums2.length; i++) {
int target = nums2[i];
int high = nums1.length-1;
while(low <= high) {
int mid = low + (high - low) / 2;
if(target == nums1[mid]) {
if(mid == low || nums1[mid] > nums1[mid-1]) {
list.add(target);
low = mid+1;
break;
} else {
high = mid - 1;
}
} else if(nums1[mid] > target){
high = mid -1;
} else {
low = mid + 1;
}
}

        }
        int[] result = new int[list.size()];
        int index = 0;
        for(Integer i : list) {
            result[index] = i;
            index++;
        }
        return result;
    }

}

## Problem2

Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

//Time Complexity = O(logN)
//Space Complexity = O(1)

class Solution {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
if(nums1 == null || nums2 == null) {
return 0.0;
}
if(nums1.length == 0 && nums2.length == 0) {
return 0.0;
}

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = n1;
        int partx = 0;
        int party = 0;

        while(low <= high) {
            partx = low + (high-low) / 2;
            party = (n1 + n2)/2 - partx;

            int l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx-1];
            int l2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            int r1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            int r2 = party == n2 ? Integer.MAX_VALUE : nums2[party];

            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 != 0) {
                    return Math.min(r1,r2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
            } else if(l2 > r1) {
                low = partx + 1;
            } else {
                high = partx -1;
            }
        }
        return 0.0;
    }

}
