/*approach 1: HashMap based. 
I would be putting all the values of smaller array into hashmap with their count and
while iterating over larger array. if the count of the number is greater than 0 then 
i would be adding that number in the result and decrementing the count.
It mean current number is common between 2 array
time complexity: O(m+n) where m is the length of array 1 and n is the length of array 2
Space Complexity: O(m) m is the length array 1 */
class Solution {
    Map<Integer, Integer> countMap;
    public int[] intersect(int[] nums1, int[] nums2) {
        
        countMap = new HashMap<>();
        
        //just to save space. if num1 is larger size then we would end up inserting too
        //many values in the map which is not required. 
        if(nums1.length > nums2.length )
            return intersect(nums2, nums1);
        
        //create map of smaller array
        for(int i: nums1)
            countMap.put(i,countMap.getOrDefault(i, 0)+1);
        
        int index =0;
        for(int i: nums2){
            if(countMap.containsKey(i) && countMap.get(i) > 0){
                nums1[index++] = i;
                countMap.put(i, countMap.get(i)-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
