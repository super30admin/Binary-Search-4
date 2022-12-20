import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection2Arrays2 {
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/

/*
* Brute Force
* TC- O(m*n)
* SC - O(1)
*
*Hashmap - create a hashmap<elements, no.of times> of smaller array and check whether
* the elements are present in the second array. Once the elements are found reduce the count in value of hashmap
*TC - O(m+n)
* SC - O(n) for hashmap n = min. lengths of 2 arrays
*
* 2 pointers
* Sort 2 arrays put 2 pointers on start of both arrays if arr[i]= arrNew[i] then record element
* arr[i]<arrNew[i] move pointer on arr. Once any pointer reaches end return result.
* arrNew[i]<arr[i] move pointer on arrNew
*
* When pointers are assigned to the last elements  of arrays then move the pointer for the larger element
* if arr[i]= arrNew[i] then record element
 * arr[i]<arrNew[i] move pointer on arr. Once any pointer reaches end return result.
 * arrNew[i]<arr[i]
 * TC - O(nlogn)+O(mlogm) when arrays are not sorted. If sorted TC = O(m+n)
* SC - O(1)
*
* Binary Search
* apply bs on larger array and iterate over smaller array
*
*TC -O(nlogm)
* SC -O(1)
* */

    public static void main(String[] args) {
        int[] nums1 ={4,9,5};
        int[] nums2 ={9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
    //Binary Search Solution
    public static int[] intersect(int[] nums1, int[] nums2) {
        if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) return new int[]{-1, -1};
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0;
        for (int i = 0; i < nums1.length; i++) {
            int bsIndex = binarySearch(nums2,low, nums2.length-1, nums1[i]);
            if(bsIndex!=-1){
                result.add(nums1[i]);
                low=bsIndex+1;
            }
            
        }

        int[] resultN = new int[result.size()];
        for (int i = 0; i < resultN.length ; i++) {
            resultN[i]= result.get(i);

        }

        return resultN;

    }

    private static int binarySearch(int[] nums2, int low, int high, int target) {
    while(low<=high){
        int mid = low+(high-low)/2;
        if(nums2[mid]==target){
            if(mid==low || nums2[mid-1]!=target) return mid;
            high =mid-1;
        }
        else if(target>nums2[mid]) {
            low=mid+1;
        }
        else high = mid-1;
    }
    return -1;

    }

    //2Pointers based solution
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 ==null) || (nums1.length==0&&nums2.length==0)) return new int[]{-1,-1};
        if(nums1.length> nums2.length) return intersect(nums2,nums1);
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
       while(p1< nums1.length && p2< nums2.length){
           if(nums2[p2]>nums1[p1]){
               p1++;
           }
          else if(nums1[p1]==nums2[p2]) {
               result.add(nums1[p1]);
               p1++;
               p2++;
           }
           else p2++;
       }


        int[] resultN = new int[result.size()];
        for (int i = 0; i < resultN.length ; i++) {
            resultN[i]= result.get(i);
        }

        return resultN;

    }

     */

    //HashMap based solution
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 ==null) || (nums1.length==0&&nums2.length==0)) return new int[]{-1,-1};
        if(nums1.length> nums2.length) return intersect(nums2,nums1);
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            //if(map.containsKey(nums1[i]))  count = map.get(nums1[i]);
            //map.put(nums1[i],count+1);
            // optimization
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                int count = map.get(nums2[i]);
                count--;
                if(count==0){
                    map.remove(nums2[i]);
                }
                else {
                    map.put(nums2[i],count );
                }
            }
        }
        int[] resultN = new int[result.size()];
        for (int i = 0; i < resultN.length ; i++) {
            resultN[i]= result.get(i);
        }

        return resultN;

    }


     */
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 ==null) || (nums1.length==0&&nums2.length==0)) return new int[]{-1,-1};
        if(nums1.length< nums2.length) return intersect(nums2,nums1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j]==nums1[i]){

                    result.add(nums1[i]);
                    nums2[j]=Integer.MIN_VALUE;
                    nums1[i]=Integer.MAX_VALUE;
                }
            }
        }
    int[] resultN = new int[result.size()];
        for (int i = 0; i < resultN.length; i++) {
            resultN[i]=result.get(i);
        }


return resultN;

    }

     */
}
