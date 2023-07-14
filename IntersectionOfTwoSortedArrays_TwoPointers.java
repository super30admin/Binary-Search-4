import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfTwoSortedArrays_TwoPointers {

    //SORTED ARRAYS - TWO POINTERS - O(M+N)

    public int[] intersect(int[] nums1, int[] nums2) {

        int m = nums1.length; int n = nums2.length;

        //sort arrays
        Arrays.sort(nums1); Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>(); // assuming List<Integer> is in return part of problem statement

        int p1 = 0; int p2 = 0;

        while(p1 < m && p2 < n) {

            if(nums1[p1] == nums2[p2]) {

                li.add(nums1[p1]);

                p1++; p2++;
            }

            else if(nums1[p1] > nums2[p2])   p2++;

            else   p1++;
        }

        // making result array from li
        int[] result = new int[li.size()];

        for(int i = 0; i < li.size(); i++) {

            result[i] = li.get(i);
        }
        // output intersection array
        return result;
    }

    public static void main(String[] args) {

        IntersectionOfTwoSortedArrays_TwoPointers obj = new IntersectionOfTwoSortedArrays_TwoPointers();

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

        System.out.println("Intersection array is ");
        for (int ele: answer) {
            System.out.println(ele);
        }
    }

}

/*
TIME COMPLEXITY = O(M+N)

Sorted arrays assumed
each pointer moves fully over its array = O(m+n) - worst case

SPACE COMPLEXITY = O(1) - only pointers
Assuming return type is List of integers
*/