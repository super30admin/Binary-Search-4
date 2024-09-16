// Time Complexity : O(mn) for brute force, O(m+n) is sorted, O(m+n) for hash, for binary Search its O(mlogn)
// Space Complexity : O(k) for min heap, O(1) for merge.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1); //mlogm
        Arrays.sort(nums2); //nlogn
        
        List<Integer> res = new ArrayList<>();
        int low = 0, high = nums2.length - 1;
        for(int i = 0; i < nums1.length; i ++){
            int idx = binarySearch(nums2, low, high, nums1[i]);
            if(idx !=-1){
                res.add(nums1[i]);
                low = idx + 1;
            }     
        }

        int result [] = new int [res.size()];
        for(int i = 0;i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }

    private int binarySearch(int [] arr, int low , int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                if(mid == low || arr[mid] > arr[mid - 1]){
                    return mid;
                }else {
                    mid = high - 1;
                }
            }else if (arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }


    public int[] intersectHash(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i ++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }

        List<Integer> res = new ArrayList<>();            
        for(int i = 0; i < nums2.length; i ++){
            if(map.containsKey(nums2[i])){
                res.add(nums2[i]);
                if(map.get(nums2[i]) - 1 == 0){
                    map.remove(nums2[i]);
                }else{
                    int val = map.get(nums2[i]);
                    val--;
                    map.put(nums2[i],val);
                }
            }
        }
      
      int result [] = new int [res.size()];
      for(int i = 0;i < res.size(); i++){
        result[i] = res.get(i);
      }

      return result;
    }

    public int[] intersectTP(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        int p1 = 0, p2 =0;
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
            }
        }
      
        int result [] = new int [res.size()];
        for(int i = 0;i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }

    public int[] intersectBF(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        int [] res = new int[nums1.length];
        boolean [] visited = new boolean[nums2.length];
        int idx = 0;
        //below block O(mxn)
        for(int i = 0; i < nums1.length; i ++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j] && !visited[j]){
                    res[idx++] = nums1[i];
                    visited[j] = true;
                    break;
                }
            }
        }

        int result [] = new int[idx];
        //O(m)
        for (int i = 0; i < res.length; i++){
            if(res[i] != 0){
                result[i] = res[i];
            }
        }
        return result;
    }
}