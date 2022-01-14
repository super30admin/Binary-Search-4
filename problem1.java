// 350 Intersection of Two Arrays II
// solved on Leetcode
// Time Complexity :  O(nlog(m))
// Space Complexity :  O(1)


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int start = 0;
        int end = nums2.length - 1;
        
        ArrayList<Integer> result = new ArrayList();
        
        for(int i = 0; i < nums1.length; i++){
           int  target = nums1[i];
            int index = BinarySearch(nums2, start, end, target);
            
            if(index != -1){
                result.add(nums2[index]);
                start = index + 1;
            }
        }
        
        int[] result2 = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            
            result2[i] = result.get(i);
        }
        
        return result2;
    }
    
    public int BinarySearch(int []arr, int start, int end, int target){
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(arr[mid] == target){
                
                if(mid == start || arr[mid - 1] != arr[mid]){
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
        
        
        