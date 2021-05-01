//intersection between two arrays
//tc - O(m+n)
//sc - O(n)
import java.util.*;
class Problem1{
    public static void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Problem1 p = new Problem1();
        int[] res = p.intersect(nums1, nums2);
        for(int i : res){
            System.out.print(i+" ");
        }

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;;
        if(n1> n2){
            return intersect(nums2, nums1);
        }
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i< nums2.length; i++){
            if(map.containsKey(nums2[i])){
                res.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
                if(map.get(nums2[i])==0){
                    map.remove(nums2[i]);
            }
            
            }
            
        }
        int[] ans = new int[res.size()];
        for(int i = 0;i< res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
        
        
    }

}