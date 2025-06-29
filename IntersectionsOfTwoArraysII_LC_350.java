/*
Time complexity - O(n + m)
Space Complexity - O(min(m,n))
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Approach 1 - Using Hashmap
in Hashmap loop the smaller array and check if it against long array, if we find elements from map and if it matches with
current array copy that in element in result and then deduct from map
*/

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionsOfTwoArraysII_LC_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}


/*
Approach 2
sort the array and iterate the smaller array to check the elements against bigger array
tc - O(nlogn) + o(mlogn) + O(n)
sc - logn(for sorting) + logm(for sorting) + O(m+n) -> (if we are storing result in another array worst case is all elements are intersection)


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<Integer>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0,
                ptr2 = 0;

        while(ptr1 != nums1.length && ptr2 != nums2.length)
        {
            if(nums1[ptr1] == nums2[ptr2])
            {
                result.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] < nums2[ptr2])
            {
                ptr1++;
            }
            else
            {
                ptr2++;
            }
        }
        //copy the arraylist in array
        int index = -1;
        int[] intersect = new int[result.size()];

        for(Iterator it = result.iterator();it.hasNext();)
            intersect[++index] = (Integer)it.next();

        return intersect;
    }
}
*/