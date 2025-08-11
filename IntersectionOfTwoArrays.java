
//Time Complexity : O(m log m + n log n + m log n) -> sorting two arrays and performing binary search m times on array with size n.
//Space Complexity : O(1) -> No additional space is required.


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //Binary Search solution
        int m = nums1.length;
        int n = nums2.length;

        //to make sure number of elements in nums1 is always less than equal to nums2
        if(m > n){
            return intersect(nums2, nums1);
        }

        //sort arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int low = 0;
        int high = n - 1;
        for(int i = 0; i < m; i++){
            int target = nums1[i];

            int bsIndex = binarySearch(nums2, target, low, high);
            if(bsIndex != -1){
                result.add(target);
                
                //reduce the search space
                low = bsIndex + 1;
            }
            
        }

        int[] re = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            re[i] = result.get(i);
        }

        return re;

    }

    public int binarySearch(int[] nums2, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low) / 2; //prevent integer overflow

            if(nums2[mid] == target){
                //find the first occurance of the element.
                if(mid == low || nums2[mid - 1] != nums2[mid]){
                    return mid;
                }
                //if this is not the first occurance then it is more likely to be found on the left side.
                else{
                    high = mid - 1;
                }
            }
            else if(nums2[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }

        //if not found
        return -1;

    }
}