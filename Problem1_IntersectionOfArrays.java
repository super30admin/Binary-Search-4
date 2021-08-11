// Time Complexity : o(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    // using hashmap
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        List<Integer> result=new ArrayList<>();
        
        //iterate through nums1
        for (int i = 0; i < nums1.length; i++) {
            //check if already in counts
            if (map.containsKey(nums1[i])) {
                //increment count
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                //need to add it
                map.put(nums1[i], 1);
            }
        }
        
        for(int j=0;j<nums2.length;j++)
        {
             if(map.containsKey(nums2[j]) && map.get(nums2[j])!=0)
             {
                 result.add(nums2[j]);
            
                  map.put(nums2[j],map.get(nums2[j])-1); 
             }
                
        }
        
        int[] array=new int[result.size()];
        for(int k=0;k<result.size();k++)
            array[k]=result.get(k);
        
        return array;
    }
    
    // using two pointers
     public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j])
            {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }    
            
        }
        
        int[] arr = new int[ans.size()];
        int k = 0;
        for(int num: ans)
            arr[k++] = num;
        return arr;
    }
}
}