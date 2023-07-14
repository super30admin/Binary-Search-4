import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfTwoArrays_HashMap {

        //HASH MAP - O(M+N)
        public int[] intersect(int[] nums1, int[] nums2) {

            int m = nums1.length; int n = nums2.length;

            // make sure the first array is smaller
            if(m > n) return intersect(nums2, nums1);

            // build frequency map of smaller array
            HashMap<Integer, Integer> frequency = new HashMap<>(); //O(min(m,n))

            for(int ele1: nums1) { //O(m)

                frequency.put(ele1, frequency.getOrDefault(ele1, 0) + 1);

            }

            List<Integer> li = new ArrayList<>();

            for(int ele2: nums2) { //O(n)

                //add overlapping element in second array to li and reduce frequency by 1
                if(frequency.containsKey(ele2)) {

                    li.add(ele2);

                    frequency.put(ele2, frequency.get(ele2) - 1);

                    // remove zero frequency elements from map
                    frequency.remove(ele2, 0);
                }
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

            IntersectionOfTwoArrays_HashMap obj = new IntersectionOfTwoArrays_HashMap();

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

if there is no overlap - worst case - O(m+n)
O(m) - frequency map of smaller array
O(n) - iterating over larger array

SPACE COMPLEXITY = O(min(M, N))
only smaller array used for hash map of frequency
*/

