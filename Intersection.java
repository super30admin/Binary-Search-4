
// Time Complexity : O(m) + O(n)
// Space Complexity : O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        if(nums1.length<=nums2.length){
            for(int i=0;i<nums1.length;i++){
                map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
            }
            for(int i=0;i<nums2.length;i++){
                if(map.containsKey(nums2[i])){
                    map.put(nums2[i],map.get(nums2[i])-1);
                    map.remove(nums2[i],0);
                    result.add(nums2[i]);
                }
            }
        }else{
            return intersect(nums2,nums1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

//Time Complexity:O(n log m)
//Space Complexity:O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[] {};
        List<Integer> result = new ArrayList<>();
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0;
        for(int i=0;i<nums1.length;i++){
            int index=binarySearch(nums2,low,nums2.length-1,nums1[i]);
            if(index!=-1){
                result.add(nums1[i]);
                low=index+1;
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    private int binarySearch(int [] nums,int low, int high,int target){
        if(nums==null || nums.length==0)
            return -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
                
            }else if(target>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
