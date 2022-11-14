class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n=nums1.length;
        int m=nums2.length;
        
        if(n>m)
        {
            return intersect(nums2,nums1);
        }
        
        List<Integer> result=new ArrayList<>();
        int l=0;
        int h=m-1;
        for(int i=0;i<n;i++)
        {
            int idx=bs(nums2,nums1[i],l,h);
            if(idx!=-1)
            {
                result.add(nums2[idx]);
                l=idx+1;
            }
        }
        
        int[] arr=new int[result.size()];
        
        for(int i=0;i<result.size();i++)
        {
            arr[i]=result.get(i);
        }
        
        return arr;    
        
    }
    
    private int bs(int[] arr, int target, int l, int h)
    {
        while(l<=h)
        {
            int m=l+(h-l)/2;
            
            if(arr[m]==target && (m==l || arr[m]!=arr[m-1]))
                return m;
            else if(arr[m]<target)
                l=m+1;
            else
                h=m-1;
                
        }
        
        return -1;
    }
}

// Time Complexity : O(MlogM + NlogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no