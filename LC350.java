//Time Complexity : O(nLogm)
//Space Complexity : O(n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        //null
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length==0)
        {
            return nums1;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        if(n>m)
        {
            return intersect(nums2,nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        int low = 0;
        int high = m-1;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        
        for(int i=0;i<n;i++)
        {
            int searchindex = binarySearch(nums1,low,high,nums2[i]);
            
            if(searchindex != -1)
            {
                low = searchindex + 1;
                result.add(nums2[i]);
            }
        }
        
        int target[] = new int[result.size()];
        
        for(int i=0;i<target.length;i++)
        {
            target[i] = result.get(i);
        }
        
        return target;
    }
    
    private int binarySearch(int arr[],int low,int high,int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target)
            {
                if(mid == low || arr[mid-1]!=arr[mid])
                {
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(arr[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}