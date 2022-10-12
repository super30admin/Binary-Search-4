
intersection-of-two-arrays-ii
public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    for(int num : nums1) map.put(num,map.getOrDefault(num,0) + 1);
    for(int num : nums2){
        if(map.containsKey(num)){
            list.add(num);
           if(map.get(num) == 1) map.remove(num);
           else map.put(num,map.get(num)-1);
        }
    }
    int[] res = new int[list.size()];
    for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
    return res;
}




Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0;
        }
        
        if(nums1 == null){
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }
        
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;
        
        while(left < right){
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;
            
            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else{
                right = i;
            }
        }
        
        int first = left;
        int second = (n + m) / 2 - left;
        
        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];
        
        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];
        
        if((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
 

        
    }
}

TC:O(log(mn)

