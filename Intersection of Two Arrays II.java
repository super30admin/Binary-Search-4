// Time Complexity = O(max(n,m))
// Space Complexity = O(min(n,m))
// HashMap solution

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         HashMap <Integer, Integer> map = new HashMap<>();
        
//         int n = nums1.length;
//         int m = nums2.length;
//         List <Integer> result = new ArrayList<>();
        
//         if(n > m) return intersect (nums2, nums1);
        
//         for(int i = 0; i < n; i ++){
//             map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//         }
        
        
//         for(int i = 0; i < m; i++){
//             if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
//                 result.add(nums2[i]);
//                 int temp = map.get(nums2[i]) - 1;
//                 map.put(nums2[i], temp);
//             }    
//         }
        
//         int [] intersect = new int [result.size()];
//         for(int i = 0; i < result.size(); i ++){
//             intersect[i] = result.get(i);
                
//         }
//         return intersect;
//     }
// }




// Time Complexity = O(mlogm)
// Space Complexity = O(n)
// Binary Search Solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {        
        if(nums1.length > nums2.length) return intersect (nums2, nums1);
        List <Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = nums2.length - 1;
        
        for(int i =0; i < nums1.length; i++){
            int bindex = binarySearch(nums2, low, high, nums1[i]);
            if(bindex != -1){
                result.add(nums1[i]);
                low = bindex + 1;
            }
        }
        
        int [] intersect = new int [result.size()];
        for(int i = 0; i < result.size(); i ++){
            intersect[i] = result.get(i);
        }
        return intersect;
    }
    
    private int binarySearch(int [] nums2, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if (nums2[mid] == target){
                if(mid == low || nums2[mid] != nums2[mid-1])
                    return mid;
                else
                    high = mid -1;
            }
            else if(nums2[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}
















































