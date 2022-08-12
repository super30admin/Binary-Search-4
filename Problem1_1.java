//Time Complexity: O(m) + O(n); where m is the length of nums1 and n is the length nums2.
//Space Complexity: O(m);
//Code run successfully on LeetCode.

public class Problem1_1 {

    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> result = new ArrayList<>();
        
        if(n1 > n2)
            return intersect(nums2,nums1);
        
        for(int i =0; i < n1; i++)
           map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        
        for(int i =0; i < n2; i++){
            
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                int cnt = map.get(nums2[i]);
                cnt--;
                if(cnt == 0)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i], cnt);
            }
        }
        
        int n = result.size();
        int[] res = new int[n];
        
        for(int i =0; i < n; i++)
            res[i] = result.get(i);
        
        return res;
    }
}
