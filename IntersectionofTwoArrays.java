//Time complexoty = O(nlogn) + O(mlogn) = O((m+n)logn)
//space complexity = O(min(m,n)) : in worst case , if all elements in any array matches


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n>m){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //if nums2(lgt n) is larger , perform binary search on nums2
        int low = 0;
        int high = n-1;
        List<Integer>output = new ArrayList<>(); //resultant list
        //perform linear search on nums1 and binary search on nums2
        for(int i = 0 ; i < m ; i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2,low,high,target);
            if(bsIndex!=-1){ //
                output.add(target);

                low = bsIndex+1;
            }
        }
        int[] resultArray = new int[output.size()];
        for(int i = 0 ; i < output.size() ; i++){
            resultArray[i] = output.get(i);
        }
        return resultArray;
        
    }
     private int binarySearch(int [] arr,  int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){  //check if its the first index
                if(mid == low || arr[mid] > arr[mid - 1]){ //if yes , it is the first index
                    return mid;
                } else { //if not , to get first index move high towards mid-1
                    high = mid -1;
                }
            } else if(arr[mid] > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}