import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    //sorted, binary search - O(nlogn + mlogm + mlogn)
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low = 0, high = n2-1;
        for(int num: nums1){
            int bsIndex = binarySearch(nums2, num, low, high);
            if(bsIndex != -1){
                result.add(num);
                low = bsIndex + 1;
            }
        }

        int re[] = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            re[i] = result.get(i);
        }
        return re;
    }

    private int binarySearch(int arr[], int target, int low, int high){
        while(low <= high){
            int mid = low + (high- low)/2;
            if(arr[mid] == target){
                //check for first occurence
                if(mid == low || arr[mid] != arr[mid-1]){
                    return mid;
                }else{
                    high = mid -1;
                }   
            }else if(arr[mid] < target){
                //move right 
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    //sorted 2 pointers - O(nlogn + mlogm + m + n)
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length, n2 = nums2.length;
    //     if(n1 > n2) return intersect(nums2, nums1);
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     List<Integer> result = new ArrayList<>();
    //     int p1 = 0, p2 = 0;
    //     while(p1 < n1 && p2 < n2){
    //         if(nums1[p1] == nums2[p2]){
    //             result.add(nums1[p1]);
    //             p1++; p2++;
    //         }else if(nums1[p1] < nums2[p2]){
    //             p1++;
    //         }else{
    //             p2++;
    //         }
    //     }
      

    //     int re[] = new int[result.size()];
    //     for(int i = 0; i < result.size(); i++){
    //         re[i] = result.get(i);
    //     }
    //     return re;
    // }


    //not sorted - O(m+n)
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length, n2 = nums2.length;
    //     if(n1 > n2) return intersect(nums2, nums1);

    //     Map<Integer, Integer> freq = new HashMap<>();
    //     for(int num: nums1){
    //         freq.put(num, freq.getOrDefault(num,0)+1);
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     for(int num: nums2){
    //         if(freq.containsKey(num)){
    //             result.add(num);
    //             freq.put(num, freq.get(num)-1);
    //             freq.remove(num, 0);
    //         }
    //     }

    //     int re[] = new int[result.size()];
    //     for(int i = 0; i < result.size(); i++){
    //         re[i] = result.get(i);
    //     }
    //     return re;
    // }
}
