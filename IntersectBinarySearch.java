// Time Complexity : O(n1 log n2) //ignored sorting
// Space Complexity : O(n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2)
            return intersect(nums2, nums1);
        
        int l = 0;
        int h = n2 - 1;
        
        for(int num: nums1){
            int m = binarySearch(nums2, l, h, num);
            if(m != -1){
                list.add(num);
                l = m + 1;
            }
        }
        
        int[] result = new int[list.size()]; 
        for(int i = 0;i < result.length; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private int binarySearch(int[] nums2, int l, int h, int num){
        while(l <= h){
            int m = l + (h - l) / 2;
            if(nums2[m] == num){
                if(m == l || nums2[m - 1] < nums2[m])
                    return m;
                else
                    h = m - 1;
            }
            else if(nums2[m] > num)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}