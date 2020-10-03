
/*
 * #350. Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

1. Each element in the result should appear as many times as it shows in both arrays.
2. The result can be in any order.

Follow up:

1. What if the given array is already sorted? How would you optimize your algorithm?
2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */


/*
* Approach 1: Hash Map
* 
* Algorithm:

1. If nums1 is larger than nums2, swap the arrays. 
    -> It's a good idea to check array sizes and use a hash map for the smaller array. It will reduce memory usage when          one of the arrays is very large.

2. For each element in nums1:

        Add it to the hash map m.

            Increment the count if the element is already there.
            
3. Initialize the insertion pointer (k) with zero.

4. Iterate along nums2:

        If the current number is in the hash map:

            Copy the number into nums1[k], and increment k.

            Decrement the count in the hash map.
            
            Remove the number with count 0 from hash map.

5. Return first k elements of nums1.

   -> For our solution here, we use one of the arrays to store the result. As we find common numbers, we copy them to the first array starting from the beginning. Then return the copy of that array as output from index 0 to k.

*/


/*
 * Approach 2: Sort
 * 
 *Algorithm:
 * 
1. Sort nums1 and nums2.

2. Initialize i, j and k with zero.

3. Move indices i along nums1, and j through nums2:

		Increment i if nums1[i] is smaller.

		Increment j if nums2[j] is smaller.

		If numbers are the same, copy the number into nums1[k], and increment i, j and k.

4. Return first k elements of nums1.
 * 
 * 
 */


/* Approach 1: Hash Map
 * 
 * Time Complexity: O (n + m) -> where n and m are the lengths of the arrays. We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.
 * 
 * Space Complexity: O (min(n,m)) ->  We use hash map to store numbers (and their counts) from the smaller array. 'n' and 'm' are length of arrays
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

/*
 * Approach 2: Sort
 * 
 * Time Complexity: O(nlogn + mlogm) -> where n and m are the lengths of the arrays. We sort two arrays independently, and then do a linear scan. 
 * 
 * Space Complexity: O (1) ->  No extra space used
 * 
 */

package com.s30.edu.binarysearch4;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfArrays {
	public int[] intersect(int[] nums1, int[] nums2) {
        
        // Base condition 
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        
        // *********** Approach 1: HashMap *******************//
        // 1. 
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 2. 
        for(int n : nums1){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // 3. 
        int k = 0;
        
        // 4. 
        for(int n : nums2){
            if(map.containsKey(n)){
                nums1[k] = n;
                k++;
                map.put(n, map.get(n) - 1);
                map.remove(n, 0);
            }
        }
        
        // 5. 
        //return Arrays.copyOfRange(nums1, 0, k);
        
        
        // ************** Approach 2: Sort ****************//
        
        // #1. Sort nums1 and nums2.
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // #2.Initialize i, j and k with zero.
        int i = 0, j = 0, l =0;
        
        // #3. Move indices i along nums1, and j through nums2:
        while(i < nums1.length && j < nums2.length){
            
            // Increment i if nums1[i] is smaller.
            if(nums1[i] < nums2[j]){
                i++;
            }
            
            // Increment j if nums2[j] is smaller.
            else if(nums2[j] < nums1[i]){
                j++;
            }
            
            // If numbers are the same, copy the number into nums1[k], and increment i, j and k.
            // we use one of the arrays to store the result. As we find common numbers, we copy them to the first array                          starting from the beginning. Then return the copy of that array as output from index 0 to k.
            else{
               nums1[l] = nums1[i];
               i++;
               j++;
               k++;
            }
        }
        
        // #4. Return first k elements of nums1.
        return Arrays.copyOfRange(nums1, 0, l);
    }

}
