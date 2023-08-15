// Time Complexity :O(mlogn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//For every element in the smaller array , we will do a binary search to get the elements in the bigger array.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n) return intersect(nums2,nums1);
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //Iterate throught the smaller array
        int low=0,high=n-1;
        for(int i=0;i<m;i++)
        {
            int bsIndex=binarySearch(nums2,low,high,nums1[i]);
            if(bsIndex!=-1) //if the element is present in nums2
            {
                li.add(nums1[i]);   //add it to the List
                low=bsIndex+1;  //increment the low pointer to the next element
            }
           
        }


        int[] result=new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            result[i]=li.get(i);
        }
        return result;
    }

//this function will return the index of the first occurence of the element
    private int binarySearch(int [] arr,int low,int high,int target)
    {
        while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(arr[mid]==target)
                {
                    //check the previous element
                    if(mid==low || arr[mid]>arr[mid-1])
                    {
                        return mid;
                    }
                    else
                    {
                        high=mid-1;
                    }
                }
                else if(target<arr[mid])
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


//Using Two Pointer

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n) return intersect(nums2,nums1);
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
      int p1=0,p2=0;
      while(p1<m && p2<n)
      {
          if(nums1[p1]==nums2[p2])
          {
              li.add(nums1[p1]);
              p1++;
              p2++;
          }
          else if(nums1[p1]<nums2[p2])
          {
              p1++;
          }
          else 
          {
              p2++;
          }
      }

        int[] result=new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            result[i]=li.get(i);
        }
        return result;
    }

}

//Using HashMap

//Using HashMap

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n) return intersect(nums2,nums1);
        List<Integer> li=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        //add the elements from the smaller array in the hashmap
       for(int num:nums1)
       {
               map.put(num,map.getOrDefault(num,0)+1);
       }
        for(int num:nums2)
       {
           //if map contains the value from nums2, then decrement the value by 1
           if(map.containsKey(num))
           {
               li.add(num);                     // add the key to the result
               map.put(num,map.get(num)-1);     //decrement the value
               map.remove(num,0);              //remove it the value has become 0
           }
       }
        int[] result=new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            result[i]=li.get(i);
        }
        return result;
    }

}