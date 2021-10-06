class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        Arrays.sort(nums1); Arrays.sort(nums2);
        int low=0;int high=nums2.length-1;
        for(int i=0;i<nums1.length;i++){
          int Index= binarySearch(nums2,low,high,nums1[i]);
          
            if(Index != -1){
                result.add(nums1[i]);
                low = Index + 1;
            }
            
        }
        int[] out = new int[result.size()];
        for(int i=0;i<out.length;i++){
            out[i] = result.get(i);
        }
        return out;
    }
    
    public int binarySearch(int[] arr,int low, int high, int target)
    {
         while(low <= high)
         {
                int mid = low + (high-low)/2;
                if(arr[mid]==target){
                    if(mid==low || arr[mid]>arr[mid-1])
                    {
                        return mid;
                    }
                     else{
                         high=mid-1;
                     }
                }
                else if(arr[mid]>target){
                   high=mid-1; 
                }
                else{
                    low=mid+1;
                }
            }
        return -1;
    }
}