//TC: O(m+n) m is the length of first array and n is the length of second array
//SC: O(n) where n is the length of common elements

import java.util.*;

public class IntersectionOfArrays {
    // Input: nums1 = [1,2,2,1], nums2 = [2,2]
    // Output: [2,2]
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> m=new ArrayList<>();
        int a=nums1.length;
        int b=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        //Adding common elements from both the arrays into the list 
        while(i!=a && j!=b)
        {
            if(nums1[i]==nums2[j])
            {
                m.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        int arr[]=new int[m.size()];
        for(int e=0; e<m.size();e++)
            arr[e]=m.get(e);
        return arr;

    }
}