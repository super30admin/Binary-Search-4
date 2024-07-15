//Time Complexity - O(m + n) and m log m and n log n for sorting. O(m log m + n log n)
//Space - O(min(m,n))
//Approach - Binary search approach. Sorting must be done as a the first step. Perform binary search on the smaller array
//and iterate over the larger array. Each element in larger array is selected as the target and then using low as 0 and high as n-1 
//perform binary search. If element is found, then check if its the first occurrence by checking prev element OR if its the first element. 
//else if target is > then, search second half else first half. 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        //Perform binary search on smaller array
        if(m < n){
            intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n - 1;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2,low,high,target);
            if(bsIndex != -1){
                result.add(nums1[i]);
                low = bsIndex + 1;
            }


        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;    
    }
    private int binarySearch(int[] nums2,int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums2[mid] == target){
                if(mid == low || nums2[mid - 1] != target){
                    return mid;
                }
                high = mid - 1;
            }
            else if(target > nums2[mid]){
                low = mid + 1;

            }
            else{
                high = mid - 1;
            }
            
        }
        return -1;
    }
}
    

