// Time Complexity: O(M+N)
// Space Complexity:O(M)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++) 
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);

        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) { 
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);     
            }
        }
       int[] r = new int[list.size()];

       for(int i = 0; i < list.size(); i++)
       {
           r[i] = list.get(i);
       }    
       return r;            
    }
}

// Time Complexity: O(MlogM+NlogN)
// Space Complexity:O(K)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        List<Integer> result = new ArrayList<>();
        int one = 0, two = 0; 
        //sort arrays
        Arrays.sort(nums1);        
        Arrays.sort(nums2);
        
        int m = nums1.length, n = nums2.length;
        while(one < m && two < n) {
            if(nums1[one] < nums2[two])     
                one++;
            else if(nums1[one] > nums2[two])   
                two++;
            else {      
                result.add(nums1[one]);
                one++;
                two++;
            }
        }
        
        int[] array = new int[result.size()];
        int idx = 0;
        for(int num: result) {
            array[idx++] = num;
        }
        return array;
    }
}