class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int low = 0; int high = nums2.length - 1;
        
        for(int i = 0; i < nums1.length; i++){
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bsIndex != -1){
                result.add(nums1[i]);
                low = bsIndex + 1;
            }
            
        }
        int [] resultArr = new int [result.size()];
        for(int i= 0; i< resultArr.length; i++){
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target){
                if(mid == low || arr[mid] > arr[mid - 1]){
                   return mid; 
                }else{
                    high = mid - 1;
                }
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

//TC: O(m * log N)
//SC: O(log N)
