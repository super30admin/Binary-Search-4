// Time Complexity :O(n1+n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // if(nums1.length<nums2.length)
        // {
        //     return intersect(nums2,nums1);
        // }
        //Two pointer

        int p1=0,p2=0;
        int n1=nums1.length;
        int n2=nums2.length;
        List<Integer> res= new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(p1<n1 && p2<n2)
        {
            if(nums1[p1]==nums2[p2])
            {
                res.add(nums1[p1]);
                p1++;
                p2++;

            }
            else if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else
            p2++;

        }

        //HashMap Approach
        // Map<Integer,Integer> map= new HashMap<>();
        // List<Integer> res= new ArrayList<>();

        // for(int i=0;i<nums1.length;i++)
        // {
        //     map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        
        // }
        // for(int i=0;i<nums2.length;i++)
        // {
        //     if(map.containsKey(nums2[i]))
        //     {
        //     if(map.get(nums2[i])>0)
        //     {
        //         res.add(nums2[i]);
        //         map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);

        //     }
        //     }
        // }


    int[] r= new int[res.size()];
    for(int j=0;j<res.size();j++)
    {
        r[j]=res.get(j);
    }
    return r;


    }
}