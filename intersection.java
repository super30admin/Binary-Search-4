//Time: O(m + n), Space: O(min(m, n)) (m = nums1.length, n = nums2.length)

/*Approach :
Count elements of nums2 using a HashMap.

Traverse nums1 and collect elements also present in the map (considering frequency).

Convert the list of common elements to an array and return it.*/

import java.util.*;
public class intersection {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            if(!map.containsKey(nums2[i]))
            {
                map.put(nums2[i],1);
            }
            else
            {
                int get = map.get(nums2[i]);
                map.put(nums2[i],get+1);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                int get = map.get(nums1[i]);
                if(get==1)
                {
                    map.remove(nums1[i]);
                }
                else
                {
                    map.put(nums1[i],get-1);
                }
                al.add(nums1[i]);
            }
        }
        int[] op = new int[al.size()];
        for(int i=0;i<al.size();i++)
        {
            op[i] = al.get(i);
        }
        return op;
    }
}