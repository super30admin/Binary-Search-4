// Time Complexity - O(mlogm + nlogn + Min(m,n)) where m is the length of nums1 and n is the length of nums2
// Space Complexity - O(Min(m,n)) since worst case the intersection output will be the length of either nums1 or nums2 whichever is minimum
// This Solution worked on LeetCode

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // Sort the arrays
        Arrays.sort(nums2);
        int ptr1 = 0;   // ptr1 for nums1
        int ptr2 = 0;   // ptr2 for nums2
        List<Integer> li = new ArrayList<>();   // Li to add the intersection elements
        while(ptr1 < nums1.length && ptr2 < nums2.length){  // Iterate until one of the ptr reaches the end of the array length
            if(nums1[ptr1] == nums2[ptr2]){         //If both the elements in the two arrays are equal add to the list and move ahead both the pointers
                li.add(nums1[ptr1]);
                ptr1++;ptr2++;  
            }
            else if(nums1[ptr1] < nums2[ptr2])          // if nums1 element is less than the nums2 element increment nums1 pointer since the arrays are sorted , it means the nums1 element does not exist in nums2 and we move to the next nums1 element
                ptr1++;
            else 
                ptr2++;             // else move to next nums2 element
        }
        int[] result = new int[li.size()];          // return output is integer array. so convert the list to array and return
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
