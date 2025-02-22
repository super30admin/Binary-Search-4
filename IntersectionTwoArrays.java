import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(nm)
//Space Complexity: O(n)

public class IntersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i : nums1){
            hmap.put(i, hmap.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(hmap.getOrDefault(i,0) > 0 ){
                l.add(i);
                hmap.put(i, hmap.get(i) -1);
            }
        }
        return l.stream().mapToInt(i->i).toArray();
    }
}
