import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            if(nums1[ptr1] == nums2[ptr2]){
                li.add(nums1[ptr1]);
                ptr1++; ptr2++;
            } else if(nums1[ptr1] < nums2[ptr2]) ptr1++;
            else ptr2++;
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}