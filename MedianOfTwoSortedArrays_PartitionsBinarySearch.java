import java.util.Scanner;
public class MedianOfTwoSortedArrays_PartitionsBinarySearch {

        // BINARY SEARCH - PARTITIONS - O(log(min(N1, N2)))

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int n1 = nums1.length;    int n2 = nums2.length;

            if(n1 == 0 && n2 == 0)   return 0.0;

            // first input array be smaller
            if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

            int l = 0;
            int h = n1;

            while(l <= h) {  // O(log n1)

                // partition two arrays by using mid-formula initially
                int partX = l + (h-l)/2;
                int partY = (n1 + n2)/2 - partX;

                int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
                int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
                int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
                int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

                // correct partition, return median
                if(L1 <= R2 && L2 <= R1) {

                    // odd length together
                    if((n1+n2)%2 == 0) {

                        // average of max of LHS and min of RHS
                        // sorted ness maintained
                        //2.0 returns a double
                        return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                    }

                    //even length together
                    else {

                        return Math.min(R1, R2);
                    }
                }

                // clockwise rotation of pointers
                else if(L2 > R1)   l = partX + 1;

                //maximum movements are asymptotically logarithmic in the length of smaller array

                // counter-clockwise rotation of pointers
                else               h = partX - 1;
            }
            //unreached output
            return 9999.9;
        }

        public static void main(String[] args) {

            MedianOfTwoSortedArrays_PartitionsBinarySearch obj
                    = new MedianOfTwoSortedArrays_PartitionsBinarySearch();

            Scanner scanner = new Scanner(System.in);

            // Input the size of the first sorted array
            System.out.print("Enter the size of the first array: ");
            int size1 = scanner.nextInt();

            // Input the elements of the first sorted array
            int[] array1 = new int[size1];
            System.out.println("Enter the elements of the first array:");
            for (int i = 0; i < size1; i++) {
                array1[i] = scanner.nextInt();
            }

            // Input the size of the second sorted array
            System.out.print("Enter the size of the second array: ");
            int size2 = scanner.nextInt();

            // Input the elements of the second sorted array
            int[] array2 = new int[size2];
            System.out.println("Enter the elements of the second array:");
            for (int i = 0; i < size2; i++) {
                array2[i] = scanner.nextInt();
            }

            double answer = obj.findMedianSortedArrays(array1, array2);

            System.out.println("Median of two sorted arrays is  " + answer);

        }


}


/*
TIME COMPLEXITY = O(log N)

N = length pf smaller array
Pointers are rotated and partitions are remade only in logarithmic of smaller array length times

SPACE COMPLEXITY = O(1) - only pointers
*/