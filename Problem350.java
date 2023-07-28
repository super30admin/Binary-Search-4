import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem350 {
    public int[] intersectUsingBinarySearch(int[] nums1, int[] nums2) {
        /*
        TC=O(nlogm)
        SC=O(m)
         */
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)
            intersectUsingBinarySearch(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result=new ArrayList<>();
        int low=0;
        int high=n-1;
        for(int i=0;i<m;i++){
            int target=nums1[i];
            int bsIndex=binarySearch(nums2,low,high,target);
            if(bsIndex!=-1)
                result.add(target);

        }
        int[] finalResult=new int[result.size()];
        for(int i=0;i<result.size(); i++){
            finalResult[i]=result.get(i);
        }

        return finalResult;
    }

    private int binarySearch(int[] nums2, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums2[mid]==target){
               if(mid==low || nums2[mid]!=nums2[mid-1]){
                   return mid;
               }
            }
            else if(nums2[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    public int[] intersectUsingTwoPointers(int[] nums1, int[] nums2) {
        /*
        TC=O(m+n)
        SC=O(m)
         */
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)
            intersectUsingTwoPointers(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result=new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1<m && p2<n){
            if(nums1[p1]==nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]>nums2[p2])
                p2++;
            else
                p1++;
        }
        int[] finalResult=new int[result.size()];
        for(int i=0;i<result.size(); i++){
            finalResult[i]=result.get(i);
        }

        return finalResult;
    }

    public int[] intersectUsingHashMap(int[] nums1, int[] nums2) {
        /*
        TC=O(m+n)
        SC=O(m+m)
         */
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)
            intersectUsingHashMap(nums2,nums1);
        HashMap<Integer, Integer> nums1Map=new HashMap<>();
        for(int num: nums1){
            nums1Map.put(num, nums1Map.getOrDefault(num,0)+1);
        }
        List<Integer> result=new ArrayList<>();
        for(int num: nums2){
            if(nums1Map.containsKey(num)){
                result.add(num);
                nums1Map.put(num, nums1Map.get(num)-1);
                nums1Map.remove(num,0);
            }
        }
        int[] finalResult=new int[result.size()];
        for(int i=0;i<result.size(); i++){
            finalResult[i]=result.get(i);
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Problem350 problem=new Problem350();
        System.out.println(Arrays.toString(problem.intersectUsingBinarySearch(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(problem.intersectUsingBinarySearch(new int[]{4,9,5},new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(problem.intersectUsingTwoPointers(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(problem.intersectUsingTwoPointers(new int[]{4,9,5},new int[]{9,4,9,8,4})));
        System.out.println(Arrays.toString(problem.intersectUsingHashMap(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(problem.intersectUsingHashMap(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
