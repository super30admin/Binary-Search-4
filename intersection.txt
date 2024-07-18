/*  
//Using Binary Search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1.length > nums2.length) return intersect(nums2,nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> li = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < nums1.length; i++) {
            int bsIndex = binarySearch(nums2, start, nums2.length - 1, nums1[i]);
            if (bsIndex != -1) {
                li.add(nums1[i]);
                start = bsIndex + 1; 
            }
        }

        // Convert the list to array
        int[] res = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }

        return res;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        int index = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                index = mid; 
                end = mid - 1; 
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

}

*/

//Using 2 pointers
import java.util.*;
/* 
//Tc: O(NlogN+MlogM) Sc: O(min(N,M))
List<Integer> res = new ArrayList<>();
Arrays.sort(nums1);
Arrays.sort(nums2);

int p1 = 0; 
int p2 = 0;

while(p1 < nums1.length && p2 < nums2.length)
{
    if(nums1[p1] == nums2[p2]) 
    {
        res.add(nums1[p1]);
        p1++;
        p2++;
    }
    else if(nums1[p1] > nums2[p2]) p2++;
    else p1++;
}
int[] ans = new int[res.size()];
for(int i = 0; i < res.size(); i++)
{
    ans[i] = res.get(i);
}
return ans;

*/

//Using HashMap
class Solution {
    // Tc: O(M+N) Sc: O(N)
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]) && map.get(nums1[i]) > 0) {
                ans.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}