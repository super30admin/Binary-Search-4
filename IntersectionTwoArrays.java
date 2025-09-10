import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Idea is to sort two arrays and use two pointers to compare the elements to find the common numbers

//Time Complexity: O(nlogn+mlogm+min(m,n))
//Space Complexity: O(min(m,n))
public class IntersectionTwoArrays {
     public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
            return intersect(nums2,nums1);
        }

        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2=0;

        while(p1<n1 && p2<n2)
        {
            if(nums1[p1]==nums2[p2])
            {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else
            {
                p2++;
            }
        }

        int[] re = new int[result.size()];
        for(int i=0;i<result.size();i++){
            re[i] = result.get(i);
        }
        return re;
    }   
}
