/* Time Complexity :
  Approach 1 : HashMap - TC: O(m+n)    SC: O(n) where m is the length of shorter array and n is length of longer array
  Approach 2 : Two Pointer- TC: O(nlogn + mlogm + m + n)    SC: O(1) where m is the length of array 1 and n is length of array 2
  Approach 3 : Binary Search- TC: O(mlogm + nlogn + mlogn)    SC: O(1) where m is the length of shorter array and n is length of longer array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: We have three approaches to go for in this problem. In the first approach, we store the
longer array in hashmap and traverse the shorter array to find if the hashmap contains the key, if yes, decrement the count and on 0 remove the key.
In the second approach, two pointer approach, we have sorted both the arrays. This makes each element comes into its sorted positions. Hence, we parse
through both the arrays simultaneously and if the elements are common they would occur in the same position. In the third approach, we are going over
the shorter array and for each element in shorter array we are doing a binary search in the longer array from the index position till the end.
*/

// APPROACH 1 : HASHMAP
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> store = new HashMap<>();
        if(nums1 == null && nums2 == null){return new int[0];}                              // Base Case
        if(nums1 == null){return nums2;}
        else if(nums2 == null){return nums1;}
        ArrayList<Integer> result = new ArrayList<>();                                              // Result array
        for(int i: nums1){
            store.put(i, store.getOrDefault(i, 0) + 1);                                             // Put the longer array into the hashmap
        }
        for(int i = 0; i < nums2.length; i++){
            if(store.containsKey(nums2[i])){                                            // if the elements in shorter array contains in hashmap
                result.add(nums2[i]);                                                       // Add it to the result
                store.put(nums2[i], store.get(nums2[i])-1);                         // Decrement the count of occurance
                store.remove(nums2[i], 0);                                          // if 0 count => remove from the map
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// APPROACH 2 :  TWO POINTERS
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){return new int[0];}                                              // Base Case
        if(nums1 == null){return nums2;}
        else if(nums2 == null){return nums1;}
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);                                                 // Sort both the arrays
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){                                          // While any of the pointers reaches the end of the array
            if(nums1[p1] == nums2[p2]){                                                             // If the elements are equal
                result.add(nums1[p1]);                                                      // Common element, add it to the result
                p1++;
                p2++;                                                                       // Lets check for the next element
            } else if(nums1[p1] < nums2[p2]){                                               // Not common, move one of the pointer whose value is lesser
                p1++;
            } else {
                p2++;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// APPROACH 3 : BINARY SEARCH
class Solution {
    ArrayList<Integer> result;
    int index = 0;
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){return new int[0];}
        if(nums1 == null){return nums2;}
        else if(nums2 == null){return nums1;}
        result = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);                                                 // Sort both the arrays/
        for(int i = 0; i < nums1.length; i++){                  
            binarySearch(nums1[i], nums2);                                                      // Binary search for each of element of nums 1
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    private void binarySearch(int num, int[] nums2){
        int start = index, end = nums2.length-1;                                                        // Start from the index in nums 2
        while(start <= end){
            int mid =  start + (end - start)/2;
            if(nums2[mid] == num){                                                                  // if you reach the target
                if(mid == index || nums2[mid] > nums2[mid-1]){                                  // if repetition occurs, check for the first occurance
                    result.add(nums2[mid]);
                    index = mid + 1;                                                                // Move the index to the next position
                    return;
                } else {
                    end = mid-1;                                                                // If left side duplicate occurs, reduce the search space to the left for re binary search
                }
            } else
            if(nums2[mid] > num){                                                                   // if the element is greater than the target
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return;                                                                                         // Couldn't find the element
    }
}