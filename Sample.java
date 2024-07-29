//Problem 1
// TC O(nlogn)
//SC O(n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      int m=nums1.length;
      int n=nums2.length;
      List<Integer> result= new ArrayList<>();
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int p1=0;
      int p2=0;
      while(p1<m&&p2<n)
      {
        if(nums1[p1]==nums2[p2])
        {
            result.add(nums1[p1]);
            p1++;
            p2++;
        }
        else if(nums1[p1]>nums2[p2])
        {
            p2++;
        }
        else{
            p1++;
        }
      }  
      int res[]=new int[result.size()];
      for(int i=0;i<result.size();i++)
      {
        res[i]=result.get(i);
      }
      return res;
    }
}

//Problem 2
// TC O(logn)
//SC O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if(nums1==null || nums2==null)
    {
        return -1.0;
    }    
    // calculate size
    int m=nums1.length;
    int n=nums2.length;
    if(m >n)
    {
        return findMedianSortedArrays(nums2,nums1);
    }
    int low=0;
    int high=m;
    while(low<=high)
    {
        int partx=low+(high-low)/2; // integer overflow
        int party=(m+n)/2-partx;
        double l1= partx==0? Integer.MIN_VALUE:nums1[partx-1];
        double r1=partx==m? Integer.MAX_VALUE:nums1[partx];
        double l2=party==0?Integer.MIN_VALUE:nums2[party-1];
        double r2=party==n?Integer.MAX_VALUE:nums2[party];
        if(l1<=r2 && l2<=r1)// because l1<=r1 as the array is sorted
        {
            if((m+n)%2==0)
            {
                return (Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
            return Math.min(r1,r2);
        }
        else if(l1>r2)
        {
            high=partx-1;
        }
        else if(l2>r1)
        {
            low=partx+1;
        }


    }
    return 10.00;
    }
}