//TC: o(n + m)
//SC: o(min[n,m])

//explanation:
//Use a HashMap to store the first array, then check each element of the second array and see if it is in the map

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length==0  || nums2.length==0)
            return new int[0];
        // step1: Put elements in nums1 into the map
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1)
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
// step 2: iterate the nums2 and get the result        
        List<Integer> result = new ArrayList<>();
        
            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) > 0) 
                {   result.add(num);
                    int freq = map.get(num);
                    freq--;
                    map.put(num, freq);
            }
        }
         
        return listToArray(result);
    }
     
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
         
        return result;
    }
}