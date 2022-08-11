//O(n + m)
//O(n)


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
    int l1 = nums1.length;
    int l2 = nums2.length;
        
    if(l2 < l1){
        return intersect(nums2, nums1);
    }
        
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    for(int num : nums1){
        map.put(num, map.getOrDefault(num, 0)+1);
    }
        
        
    for(int num: nums2){
        if(map.containsKey(num)){
            result.add(num);
            int cnt = map.get(num);
            cnt--;
            if(cnt == 0)
                map.remove(num);
            else
                map.put(num, cnt);
        }
      }
        
    int[] ans = new int[result.size()];
    for(int i = 0; i < ans.length; i++){
        ans[i] = result.get(i);
    }
        return ans;
    }
}