//Time Complexity:O(nlogm) , n denotes size of smaller array, if they are already sorted
//Space Complexity:O(1)
/*Approach 
- for every element in shorter array we  binary search it in the other array and we need
to find its left most occurrence in that array.
- the next time we do this our index would have moved by +1 so we will be able to handle duplicate 
occurrence
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IntersectionArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1)return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < n1;i++){
            int bsIndex = binarySearch(nums2, nums1[i],index,n2-1);
            if(bsIndex != -1){
                list.add(nums1[i]);
                index = bsIndex + 1;
            }  
        }
        int[] result = new int[list.size()];
        for(int i=0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private int binarySearch(int arr[],int target,int low, int high){
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                if(mid== low || arr[mid-1]<arr[mid]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        IntersectionArrays obj = new IntersectionArrays();
        int result[] = obj.intersect(new int[]{2,2}, new int[]{1,2,2,1});
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}