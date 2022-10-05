class Solution {
    //tc - nlogm
    
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1 == null || nums2 == null) return new int[0];
        //nums2 is small
        if(nums1.length < nums2.length) return intersect(nums2,nums1);

        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        
        int low =0;
        int high = m-1;
        for(int i=0;i<n;i++)
        {
            int bIndex = binarySearch(nums1,low,high,nums2[i]);
            if(bIndex != -1)
            {
                low = bIndex+1;
                li.add(nums2[i]);
            }
        }

         int[] result = new int[li.size()];
         for(int k=0;k<result.length;k++)
         {
             result[k] = li.get(k);
         }
          return result;
    }
     
     private int binarySearch(int[]nums, int low, int high, int target)
     {
         while(low <= high)
         {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
               if(mid == low || nums[mid-1] < nums[mid])
               {
                   return mid;
               }
               else{
                   high = mid-1;
               }
            }
            else if(nums[mid] < target)
            {
                low = mid+1;
            }
            else{
                high = mid-1;
            }
         }
         return -1;
     }
}