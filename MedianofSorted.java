package s30.binarySearch.b4;


//Algo: 2 pointers => start the pointers at start index of two sorted arrays.
// Keep track of the count, if the count is equal to half of the total length. then calculate the median.

//TC: O(m + n)
//SC: O(1)

//Algo: binary search => Apply binary search, to pick the elements from first matrix and rest from second matrix
// for every picked elements check if it satisfies the median condition else travel accordingly

// TC: O(log(m+n))
// Sc : O(1)
public class MedianofSorted {


    //BinarySearch Algo
    public double findMedianSortedArraysBin(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2){
            return findMedianSortedArraysBin(nums2, nums1);
        }

        int half = (len1 + len2)/2;
        int start = 0, end = len1;

        while(start <= end){
            int mid = start + (end - start)/2;
            int firstIndex = mid-1;
            int secondIndex = half - mid -1;


            int l1 = firstIndex < 0 ? Integer.MIN_VALUE : nums1[firstIndex];
            int l2 = secondIndex < 0 ? Integer.MIN_VALUE : nums2[secondIndex];

            int r1 = firstIndex + 1 >= len1 ? Integer.MAX_VALUE : nums1[firstIndex+1];
            int r2 = secondIndex + 1 >= len2 ? Integer.MAX_VALUE : nums2[secondIndex+1];


            if(Math.max(l1, l2) <=  Math.min( r1, r2)){
                if( (len1 + len2) % 2 ==0 )
                    return (Math.max(l1, l2) + Math.min( r1, r2) )/2.0;

                return Math.min(r1, r2);
            }
            else if(l1 > r2){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }

    // 2 pointers Algo
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        int start1 = 0;
        int start2 =0;

        int count=0;
        int lastElement = Integer.MAX_VALUE;
        int secondLast= lastElement;

        double res;

        while(start1 < l1 && start2 < l2 && count <= (l1+ l2)/2  ){
            if(nums1[start1] < nums2[start2]){

                secondLast = lastElement;
                lastElement = nums1[start1];

                start1++;
            }
            else{
                secondLast = lastElement;
                lastElement = nums2[start2];
                start2++;
            }

            count++;
        }

        while(count <= (l1+ l2)/2){
            if(start1 < l1) {
                secondLast = lastElement;
                lastElement = nums1[start1];
                start1++;
            }
            else {
                secondLast = lastElement;
                lastElement = nums2[start2];
                start2++;
            }

            count++;
        }




        if((l1 + l2)%2 ==0){

            return (lastElement + secondLast)/2.0;
        }
        else return lastElement;

    }
    public static void main(String[] args) {

    }
}
