package s30.binarySearch.b4;

import java.util.*;


//Algo: using hashMap to maintain freq of first array
// iterate through the second array and check if it exists in hashmap.
//TC: O(m + n);
// SC: O(min(m,n));


// Algo : if the input arrays are sorted
// Use Binary Search on the largest array and find the left most element or floorIndex of the element;
// start the next binary search from the floorIndex found;
//TC: O(mlogn)
//SC: O(1);
public class IntersectionOfTwoArrays {


    public int[] intersectBin(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> res = new ArrayList();


        if(len1 > len2){
            return intersectBin(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int start =0;

        for(int num : nums1){

            int floorIndex = getIndex(nums2, start, nums2.length -1, num);

            if(floorIndex != start - 1 && nums2[floorIndex] == num) {
                res.add(num);
            }
            start = floorIndex + 1;
        }


        int result [] = new int[res.size()];
        int index =0;

        for(int num : res){
            result[index++] = num;
        }


        return result;
    }

    private int getIndex(int[] arr, int start, int end, int target){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                if(mid == start || arr[mid-1] != target)   return mid;
                else end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else end = mid-1;

        }

        return end;
    }


    public int[] intersect(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> res = new ArrayList();

        if(len1 > len2){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num : nums2){

            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count-1);
                res.add(num);
                if(count -1 ==0) map.remove(num);
            }

        }


        int[] result = new int[res.size()];

        int index =0;
        for(int num : res){
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
