//Time complexity : //Time complexity : O(mlogn) where m is the size of smaller array for iterating over it and logn for doing binary search on the bigger array
//Space complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

//Binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>(); // <O(m)
        int low = 0; int high = nums2.length - 1;
        for(int i = 0; i < nums1.length; i++){
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bsIndex != -1){
                li.add(nums1[i]);
                low = bsIndex + 1;
            }
        }
        //iterate through list
        int [] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] != nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

/*
//2 pointers
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>(); // <O(m)
        int p1 = 0;
        int p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]);
                p1++;p2++;
            } else if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        
        int [] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
*/
/*
//Hashmap solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> li = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num,map.get(num)-1);
                map.remove(num,0);
            }
        }
        int [] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
*/