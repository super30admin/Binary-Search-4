//Time complexity O(nlog(n))
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0){
            
            return null;
        }
        if(nums1.length > nums2.length){
            
            return intersect(nums2,nums1);
        }
        
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = nums2.length - 1;
        for(int i = 0; i < nums1.length; i ++){
             
              int index = binarySearch(nums1[i], nums2, left, right );
            
            if(index != -1){
                
                left = index + 1;
                temp.add(nums2[index]);
            }
                
            
        }
        
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i ++){
            
            
            result[i] = temp.get(i);
            
        }
        
        return result;
    }
    private int binarySearch(int num, int[] arr, int left, int right){
        
      
        
        while(left <= right){
            
            int mid = left + (right - left) / 2;
            
            if(arr[mid] < num){
                
                left = mid + 1;
            }
            else if(arr[mid] > num){
                
                right = mid - 1;
            }
            
            else if(arr[mid] == num ){
                
            if( mid == left || arr[mid] > arr[mid - 1]){
                
                return mid;
            }
            
            else {
                
                right = mid - 1;
            }
                
            }
            
                
         
        }
        
        return -1;
    }
}