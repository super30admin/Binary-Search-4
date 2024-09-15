// Using Hashmap
// time: O(m+n)
// space: O(m)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length ==0 || nums2.length == 0)
            return new int[]{};
        
        int m = nums1.length;
        int n = nums2.length;
        
        List<Integer> list = new ArrayList<>();
        
        //int[] result = new int[m+n];
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //we ll put smaller length array in hashmap
        if(m < n)
        {
            for(int i=0; i<m; i++)
            {
                if(hm.containsKey(nums1[i]))
                    hm.put(nums1[i], hm.get(nums1[i])+1);
                else
                    hm.put(nums1[i], 1);
            }
            
            //iterate over the next array
            for(int k=0; k<n; k++)
            {
                if(hm.containsKey(nums2[k]) && hm.get(nums2[k]) > 0)
                {
                   list.add(nums2[k]);
                   hm.put(nums2[k], hm.get(nums2[k])-1);
                   //count++;
                }     
            }
        }else
        {
           for(int i=0; i<n; i++)
            {
                if(hm.containsKey(nums2[i]))
                    hm.put(nums2[i], hm.get(nums2[i])+1);
                else
                    hm.put(nums2[i], 1);
            } 
            
               //iterate over the next array
            for(int k=0; k<m; k++)
            {
                if(hm.containsKey(nums1[k]) && hm.get(nums1[k]) > 0)
                {
                   list.add(nums1[k]);
                   hm.put(nums1[k], hm.get(nums1[k])-1);
                   //count++;
                }     
            }
        }
        
       return list.stream().mapToInt(i -> i).toArray(); 
    }
}



// Sort both the arrays and use two pointers to compare the elements
//Time: O(mlogm + nlogn)
//Space: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> result = new ArrayList<>();
        
        if(nums1.length ==0 || nums2.length == 0)
            return result.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int m = nums1.length;
        int n = nums2.length;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < m && p2 < n)
        {
            if(nums1[p1] == nums2[p2])
            {
               result.add(nums1[p1]);
               p1++;
               p2++;
            }
            else
            {
                if(nums1[p1] < nums2[p2]) p1++;
                else p2++;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
 
    }
}
