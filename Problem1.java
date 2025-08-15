class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return intersect(nums2,nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer>result = new ArrayList<>();
        int low = 0;
        for(int i = 0; i < m ; i++){
            int bsIndex = BinarySearch(nums1[i],nums2,low,n-1);
            if(bsIndex != -1){
                result.add(nums2[bsIndex]);
                low = bsIndex + 1;
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++)
        {
            answer[i] = result.get(i);
        }
        return answer;
        
    }

    private int BinarySearch(int target,int[] arr, int low,int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                if(mid == low || arr[mid]!=arr[mid-1]){
                return mid;
                }high = mid-1;
            }

            else if(arr[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }return -1;
    }
}
