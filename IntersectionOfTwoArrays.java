/*
  Time : O(N) | N : length of longer array
  Space : O(M) | M : size of smaller array - stored in HashMap
  Leetcode : YES
*/

/*
  Approach :
  1. take smaller array and put it's element and frequency inside hashmap.
  2. iterate over larger array and check if element exists in Hashmap. 
  3. If exists then add element to result, decrement the count by 1 and remove if freq becomes zero.
  4. add all elements to array from arrayList.
*/
class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        int l1 = nums1.length; int l2 = nums2.length;
        
        if(l1 > l2) return intersect(nums2, nums1);
        
        HashMap<Integer,Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
            hMap.put(nums1[i], hMap.getOrDefault(nums1[i],0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < l2; i++){
            if(hMap.containsKey(nums2[i])){
                result.add(nums2[i]);
                hMap.put(nums2[i], hMap.getOrDefault(nums2[i],0) - 1);
                hMap.remove(nums2[i], 0);
            }
        }
        
        int[] arr = new int[result.size()];
        for(int i =0; i< arr.length; i++){
            arr[i] = result.get(i);
        }
        
        return (arr);
        
    }
}
