import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums1)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<Integer> resultlist = new ArrayList<>();
        for(int n : nums2)
        {
            if(map.getOrDefault(n, 0) > 0)
            {
                resultlist.add(n);
                int val = map.get(n);
                map.put(n, val - 1);
            }
        }
        int[] result = new int[resultlist.size()];
        for(int i = 0; i < resultlist.size(); i++)
        {
            result[i] = resultlist.get(i);
        }
        return result;
    }
}