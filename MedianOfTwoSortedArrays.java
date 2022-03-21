/*
Time complexity: O(max(length of nums1, length of nums2))
Space Complexity: O(nums1+nums2)
Run on Leetcode: yes
Any difficulties: no

Approach:
1.These two arrays are sorted, and I am asked to calculate median of the two arrays, so I would be merging them to build
a new array all together,
2. When the new array is with me, I am gonna follow simple mathematics to calculate median of the array, if it is of even
length, would take mean of mid and mid+1 element, otherwise would return mid element as the median of the array
 */
public class MedianOfTwoSortedArrays {
    public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2){
        if(nums1 == null && nums2 == null){
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int a = 0;
        int b = 0;
        int k = 0;
        // resultant array
        int [] result = new int[m+n];

        // creating resultant array
        while(a<m && b<n){
            if(nums1[a]<nums2[b]){
                result[k] = nums1[a];
                a++;
                k++;
            }else{
                result[k] = nums2[b];
                b++;
                k++;
            }
        }

        // appending elements of the array nums1 to the resultant if size of nums1 and nums2 is different
        while(a< m){
            result[k] = nums1[a];
            k++;
            a++;
        }

        // appending elements of the array nums2 to the resultant if size of nums1 and nums2 is different
        while(b< n){
            result[k] = nums1[b];
            k++;
            b++;
        }

        // calculating median
        double median = 0;
        int length = result.length;
        int mid = (length-1)/2;
        if(length%2 == 0){
            double mid1 = result[mid];
            double mid2 = result[mid+1];
            median = (mid1+mid2)/2;
        }else{
            median = result[mid];
        }
        return median;
    }

    public static void main(String[] args){
        int nums1[] = {1,3};
        int nums2[] = {2};

        System.out.println(medianOfTwoSortedArrays(nums1, nums2));
    }
}
