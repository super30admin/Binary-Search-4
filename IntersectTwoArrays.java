/*
Time Complexity - O(m+n)
Space Complexity - O(1)
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length==0) return new int[0];
        if(nums2.length>nums1.length) return intersect(nums2,nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        
        /*
        int i = 0;
        int j = 0;
        
        
        while(i < nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        */
        int low = 0;
        int high = nums1.length-1;
        for(int i=0;i<nums2.length;i++){
            int bIndex = binarySearch(nums1,low,high,nums2[i]);
            if(bIndex!=-1){
                result.add(nums2[i]);
                low = bIndex+1;
            }
            
        }
        
        
        int[] resultArray = new int[result.size()];
    
        for(int k=0;k<result.size();k++){
            resultArray[k] = result.get(k); 
        }
        
        return resultArray;
        
    }
    
    private int binarySearch(int[] nums1, int low,  int high , int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums1[mid]==target){
                if(low == mid || nums1[mid-1]<nums1[mid]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            
            else if(nums1[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return -1;
    }
}
