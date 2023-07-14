import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class IntersectionOfTwoSortedArrays_BinarySearch {

        //SORTED - BINARY SEARCH - MOVING (LOW POINTER OF) SEARCH RANGE - O(MlogN)

        public int[] intersect(int[] nums1, int[] nums2) {

            int m = nums1.length; int n = nums2.length;

            Arrays.sort(nums1); Arrays.sort(nums2);

            // make sure first input array is smaller
            if(m > n) return intersect(nums2, nums1);

            // binary search pointers on second (larger) array
            int low = 0; int high = n-1;

            List<Integer> li = new ArrayList<>();

            // iterate on smaller array - O(MlogN)
            for(int ele1: nums1) { // O(M)

                // call binary search function on each element of smaller array
                int bsIndex = binarySearch(nums2, low, high, ele1); // O(logN)

                // if a match in larger array is found
                if(bsIndex != -1) {

                    // add element to li
                    li.add(ele1);

                    // move low pointer of search range by 1 rightwards
                    low = bsIndex + 1;
                }
            }

            // li to array result
            int[] result = new int[li.size()];

            for(int r = 0; r < result.length; r++) {

                result[r] = li.get(r);
            }

            return result;

        }


        private int binarySearch(int[] arr, int l, int h, int target) {

            // invariant
            while (l <= h) {

                int m = l + (h - l) / 2;

                // if mid is target
                if (arr[m] == target) {

                    // make sure first(or leftmost on remaining search range) occurrence of target is returned
                    if (m > l && arr[m] == arr[m - 1]) {

                        h = m - 1;

                    } else {

                        return m;
                    }
                } else if (arr[m] > target) h = m - 1;

                else l = m + 1;
            }
            return -1;
        }

        public static void main(String[] args) {

            IntersectionOfTwoSortedArrays_BinarySearch obj = new IntersectionOfTwoSortedArrays_BinarySearch();

            Scanner scanner = new Scanner(System.in);

            // Input the size of the first array
            System.out.print("Enter the size of the first array: ");
            int size1 = scanner.nextInt();

            // Input the elements of the first array
            int[] array1 = new int[size1];
            System.out.println("Enter the elements of the first array:");
            for (int i = 0; i < size1; i++) {
                array1[i] = scanner.nextInt();
            }

            // Input the size of the second array
            System.out.print("Enter the size of the second array: ");
            int size2 = scanner.nextInt();

            // Input the elements of the second array
            int[] array2 = new int[size2];
            System.out.println("Enter the elements of the second array:");
            for (int i = 0; i < size2; i++) {
                array2[i] = scanner.nextInt();
            }

            int[] answer = obj.intersect(array1, array2);

            System.out.println("Intersection array is  ");
            for (int ele: answer) {
                System.out.println(ele);
            }
        }

}


/*
TIME COMPLEXITY = O(MlogN)
Assuming sorted arrays are given

SPACE COMPLEXITY = O(1) - only pointers of binary search used
Assuming return type is List of integers
*/