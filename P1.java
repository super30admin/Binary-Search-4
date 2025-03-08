//HashMap Soln

/*
 Time Complexity (TC):
O(m + n) where m is the length of nums1 and n is the length of nums2. The time is spent on populating the HashMap and iterating through nums2.

Space Complexity (SC):
O(min(m, n)) for storing the intersection elements in the list and HashMap.

Code Explanation:
The code counts the occurrences of elements in nums1 using a HashMap.
It iterates through nums2, adding common elements to a list and decreasing their counts in the map.
Finally, the list is converted to an array and returned as the result.
 */

 class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Edge case: If either array is null or empty, return null.
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }

        int m = nums1.length;
        int n = nums2.length;

        // Ensure nums1 is the smaller array for optimized memory usage.
        if (m > n) {
            return intersect(nums2, nums1);
        }

        List<Integer> li = new ArrayList<>(); // List to store the intersection elements
        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap to store frequency of elements in nums1

        // Populate the HashMap with counts of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through nums2 and find common elements
        for (int num : nums2) {
            if (map.containsKey(num)) { // If the element exists in nums1
                li.add(num); // Add it to the list
                map.put(num, map.get(num) - 1); // Decrease its count in the map
                map.remove(num, 0); // If count becomes 0, remove it from the map
            }
        }

        // Convert List to an array
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }

        return result; // Return the intersection array
    }
}


//Binary Search

/*
Time Complexity (TC):
O(m log m + n log n), where m and n are the lengths of nums1 and nums2, respectively.
O(m log m) and O(n log n) for sorting the arrays.
O(m log n) for iterating through nums1 and performing a binary search (O(log n)) for each element in nums2.

Space Complexity (SC):
O(min(m, n)) for storing the intersection elements in the list, where m and n are the lengths of the two input arrays. The result array size is proportional to the number of common elements.

Code Explanation (3 lines):
The algorithm first sorts both input arrays, then uses a binary search to find common elements in nums1 within nums2.
If a match is found, the element is added to the result list, and the index is updated to continue searching after the found element.
Finally, the list of common elements is converted into an array and returned.
 */

 class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
 
        // If either of the arrays is empty, return an empty array
        if(nums1.length == 0 || nums2.length == 0 ) return new int[0];
 
        // Sort both arrays to enable binary search on nums2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
 
        // List to store the intersection of both arrays
        List<Integer> list = new ArrayList<>();
        int index = 0;  // To track the current position in nums2 during binary search
 
        // Loop through each element in nums1
        for(int i = 0; i < nums1.length; i++) {
            // Perform binary search for nums1[i] in nums2 starting from the current index
            int loc = binarySearch(nums2, index, nums1[i]);
 
            // If the element is found in nums2, add it to the list and update the index
            if(loc < nums2.length && nums2[loc] == nums1[i]){
                list.add(nums1[i]);
                index = loc + 1; // Move the index after the found element to avoid duplicates
            }
        }
 
        // Convert the result list into an array
        int[] res = new int[list.size()];
        int i = 0;
 
        // Copy elements from the list to the result array
        for(int element : list) {
            res[i++] = element;
        }
 
        return res;  // Return the intersection array
    }
 
    // Binary search function to find the index of target in nums2 starting from index
    public int binarySearch(int[] nums , int index , int target) {
        int left = index, right = nums.length - 1;
 
        // Binary search loop to find the appropriate position for target
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;  // Move right if target is greater than mid
            else right = mid - 1;  // Move left if target is smaller than mid
        }
 
        return left;  // Return the position where the target should be inserted or found
    }
 
 }
 