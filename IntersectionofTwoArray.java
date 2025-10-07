/*
* Approach1: Find out which array is smaller, iterate through the smaller array and add the freq of elements in the map
* Iterate through the larger array and if the element exists in the map, 
    - add it to the list
    - decrement the freq
    - if the freq == 0, remove the element
* create an array a and add all the elements from the list to the array
* TC: O(m + n) -> length of smaller and larger array
* SC: O(m + m) -> O(m) -> map to store smaller array elemenets and the resultant list will contain at max min of both the array elements
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        if (nums1Len > nums2Len) {
            return intersect(nums2, nums1);
        }
        //add the smaller array elements in the map along with the frequency
        for (int i = 0; i < nums1Len; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        // iterate through the larger array and check if that element exists, if it does, reduce the frequency
        for(int i = 0; i < nums2Len; i++){
            if(map.containsKey(nums2[i])){
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if(map.get(nums2[i]) == 0)
                    map.remove(nums2[i]);
            }
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}

