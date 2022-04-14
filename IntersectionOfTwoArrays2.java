//Time Complexity O(m+n)
//Space Complexity O(1)
//leetcode tested

import java.util.Arrays;

public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        int output[] = new int[nums1.length];
        int k=0;
        while(first < nums1.length && second < nums2.length){
            if(nums1[first] == nums2[second]){
                output[k++] = nums1[first];
                first++;second++;
            }else if(nums1[first] > nums2[second]){
                second++;
            }else {
                first++;
            }

        }
        return Arrays.copyOfRange(output,0,k);
    }

}
