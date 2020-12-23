/**
 * TC : O(N) SC: O(N)
 * Approach : Keep track of the frequency of the first array in a map and iterate over other array reducing the frequency.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        // List<Integer> res = new ArrayList<>();
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int low = 0, high = nums2.length -1;
        // for(int i : nums1){
        //     while(low < high){
        //         int mid = low + (high - low) / 2;
        //         if(nums2[mid] == i){
        //             if(mid-1 >= 0 && nums2[mid-1] == nums2[mid]){
        //                 high = mid -1;
        //             }else {
        //                 res.add(i);
        //             }
        //         }else if(nums2[mid] > i){
        //             high = mid -1;
        //         }else{
        //             low = mid + 1;
        //         }
        //     }
        // }
        // int[] result = new int[res.size()];
        // for(int i = 0 ; i  <res.size(); i++){
        //     result[i] = res.get(i);
        // }
        // return result;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums2){
            map.put(i,map.getOrDefault(i,0)+1);
        }   
        for(int i : nums1){
            if(map.containsKey(i)){
                int temp = map.get(i) - 1;
                map.put(i,temp);
                if(temp <= 0) map.remove(i);
                // map.put();
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0 ; i  <res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}