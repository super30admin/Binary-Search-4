//****INTERSECTION OF TWO ARRAY-2: HASHMAPSOLUTION****
//Time complexity:o(m+n) m and n are the length of both the arrays.
//Space complexity:o(m) where m is the length of smaller array;
//Leetcode runnable:Y;
//Any doubts:N;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Getting the smallest array out of num1 and num2
        if(nums1.length>nums2.length)
        {
            intersect(nums2,nums1);
        }
        //For sure now nums1 is smaller and nums2 is greater
        //Add all the elements into the map with its frequency
        HashMap<Integer, Integer> map =new HashMap<>();
        
        for(int i=0;i<nums1.length;i++)
        {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        //Iterating through 2nd array
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]))
            {
                //Add to result set
                res.add(nums2[i]);
                //Reduce the value in map as one is pulled out
                map.put(nums2[i], map.get(nums2[i])-1);
                //If the value is 0, remove
                map.remove(nums2[i], 0);
                
            }
        }
        int[] arr=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            arr[i]=res.get(i);
        }
        
        return arr;
    }
}
//****INTERSECTION OF TWO ARRAY-2: TWO POINTER IF ARRAY GIVEN ARE SORTED****
//Time complexity:o(m+n) m and n are the length of both the arrays OR max(mn) both are same.
//Space complexity:o(1) where m is the length of smaller array;
//Leetcode runnable:Y;
//Any doubts:N;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Iterating through 2nd array
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();
        
        int p1=0;
        int p2=0;
        
        while(p1<nums1.length && p2<nums2.length)
        {
            if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else if(nums1[p1]>nums2[p2])
            {
                p2++;
            }
            else
            {
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        
        int[] arr=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            arr[i]=res.get(i);
        }
        
        return arr;
    }
}
//****INTERSECTION OF TWO ARRAY-2: bIN****
//Time complexity:O(mlogn)
//Space complexity:o(1) where m is the length of smaller array;
//Leetcode runnable:Y;
//Any doubts:N;


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
    
        if(nums1.length>nums2.length)
        {
            intersect(nums2, nums1);
        }
        //Hence we have made sure now our nums1 is of smaller length than nums2 is bigger length
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();
        //We are planning to perform b.s on bigger array and giving the target from the smaller array
        int low=0;
        int high=nums2.length-1;
        for(int i=0;i<nums1.length;i++)
        {
            int bs= Binarysearch(nums2,low, high, nums1[i]);
                
                if(bs!=-1)
                {
                    res.add(nums1[i]);
                    low=bs+1;
                    
                }
            
        }

        
        int[] arr=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            arr[i]=res.get(i);
        }
        
        return arr;
    }
    
    private int Binarysearch(int[] nums2, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums2[mid]==target)
            {
                if(mid==low || nums2[mid]!=nums2[mid-1])
                {
                    return mid;
                }
                else
                {
                    high=mid-1;
                }
            }
            else if(nums2[mid]>target)
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
