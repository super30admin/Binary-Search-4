// Time complexity: O(m+n)log(m+n)
//space complexity:O(m)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList<>();
        int n1=nums1.length-1;
        int n2=nums2.length-1;
        
        if(n1>n2) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int index=0;
        for(int num:nums1)
        {
            int el=binary(nums2,index,n2,num);
            if(el!=-1)
            {
               result.add(num);
                index=el+1;
            }
           
        }
        int size=result.size();
        int [] arr= new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=result.get(i);
        }
        return arr;
       
    }
    public int binary(int nums[], int low, int high,int target)
    {
          while(low<=high)
        {
            int mid=low+(high-low)/2;
              if(nums[mid]==target)
              {
                  if(mid==low || nums[mid]>nums[mid-1])
                  {
                      return mid;
                  }
                  else
                  {
                      high=mid-1;
                  }
              }
              else if(nums[mid]>target)
              {
                  high=mid-1;
              }
              else
              {
                  low=mid+1;
              }
            
        }
        return -1;
    }
}
