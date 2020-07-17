// Time Complexity : O(m+n) n-length of nums1 , m-length of nums2
// Space Complexity : O(m+n) Math.min(m,n) 
// Did this code successfully run on Leetcode : Yes
https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
       
        for(int i=0;i<nums1.length;i++)
        {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0)
            {
                list.add(nums2[i]);
                map.put(nums2[i],Math.abs(map.get(nums2[i])-1));  
            }
        }
        

        return list.stream().mapToInt(i->i).toArray();
        
        
    }
}

//Approaches after sorting the array
//Binary Search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        int n1=nums1.length; int n2=nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
        int index=0;
        
        for(int i=0;i<nums1.length;i++)
        {
            int bs=binarySearch(nums1[i],nums2,index);
            
            if(bs!=-1)
            {
                list.add(nums1[i]);
                index=bs+1; 
            }
            
                
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
    
    private int binarySearch(int target, int[] num,int index)
    {
        int low=index; int high=num.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(num[mid]==target) 
            {
                if(mid==low || num[mid-1]<target)
                return mid;
                
                else
                    high=mid-1;
            }
            
            else if(num[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}

//Two pointer approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        int ptr1=0;
        int ptr2=0;
        while(ptr1<nums1.length && ptr2<nums2.length)
        {
            if(nums1[ptr1]==nums2[ptr2])
            {
                list.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1]>nums2[ptr2])
            {
                ptr2++;
            }
            else
                ptr1++;
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}