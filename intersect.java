// Time Complexity - Min(n,m)log(Max(n,m)) where n and m is the size of 2 input arrays;
// Space Complexity - O(Min(n,m)) as we need to store the result in a list before adding them to an array

class Solution {
    int low;
    int high;
    
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resultList = new ArrayList<>();
        low = 0;

        if(nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }

        for(int i : nums2){
            int num = binarySearch(i, nums1);
            if(num != -1){
               resultList.add(num); 
            }
        }

        int[] result = new int[resultList.size()];
        int j = 0;
        for(int i : resultList){
            result[j] = i;
            j++;
        }
        
        return result;
    }

    private int binarySearch(int findNum, int[] nums1){
        high = nums1.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums1[mid] == findNum){
                if(mid != low && nums1[mid-1] == nums1[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                    return nums1[mid];
                }
            }
            else if(nums1[mid] > findNum){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return -1;
    }
}