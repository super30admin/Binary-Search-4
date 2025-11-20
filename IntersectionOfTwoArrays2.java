// 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/


/**
 * Time Complexity: O(m + n)
 * Space Complexity: O(min(m,n))
 */

/**
 * Approach: We store the elements of smaller array into map with its frequency
 * We iterate over bigger array, and check if map has element with frquency greater than 0
 * If yes, we add to result and decrease frequency
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] ans = new int[result.size()];

        for(int i = 0 ; i < result.size() ; i++){
            ans[i] = result.get(i);
        }

        return ans;
    }
}


/**
 * Time Complexity: O(mlogm) + O(nlogn) + O(mlogn) since we sort both arrays and do binary search on larger array
 * Space Complexity: O(1)
 */

/**
 * Approach: We sort both arrays. We iterate over smaller array and find the element in larger array using binary search
 * If element is found, we add to result and update the search space from found element
 */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int n1 = nums1.length; 
        int n2 = nums2.length;

        if(n1 > n2){
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int start = 0;

        for(int i = 0 ; i < n1 ; i++){
            int target = nums1[i];

            int targetIdx = binarySearch(nums2, start, target, result);

            if(targetIdx != -1){
                result.add(nums2[targetIdx]);
                start = targetIdx + 1;
            }
        }

        int[] ans = new int[result.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = result.get(i);
        }
        
        return ans;
    }

    private int binarySearch(int[] arr, int start, int target, List<Integer> result){

        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                if(mid == start || arr[mid - 1] != target){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }
}