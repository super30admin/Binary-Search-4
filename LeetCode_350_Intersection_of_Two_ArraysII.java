//approach -1
//take one value from the smaller array and look for it into larger array.
//so for every number in smaller array look for that in larger array .
//tc -(m*n)
//sc -O(1)

//approach -2
//take small array and add it to the HashMap; key as number and value as frquency
//traverse through the large array, and see if that value is in map, if so , decremenet the frquency of that key and add it to the
//result 
//tc = O(m+n)
//sc - extra map - O(m)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length ==0 ) return new int[]{};
        
        int m = nums1.length;
        int n = nums2.length;
        
        if(m > n)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1)
        {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        //Now traverse through the larger array
        for(int num : nums2)
        {
            int count =0;
            if(map.containsKey(num))
            {
                count = map.get(num);
                list.add(num);
                count--;
                if(count <=0)
                    map.remove(num);
                else
                    map.put(num, count);
            }
        }
        //convert arraylist to array
        int[] result = new int[list.size()] ;
        
        for(int i=0; i< list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}