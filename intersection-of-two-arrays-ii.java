//Hashmap solution
//TC: O(m+n)
//SC: O(min(m,n))
import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //Let nums1 be the smaller array
        if(nums2.length < nums1.length) return intersect(nums2, nums1);

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums1)
            freq.put(num, 1+freq.getOrDefault(num, 0));

        List<Integer> ans = new ArrayList<>();
        for(int num : nums2)    {
            int cnt = freq.getOrDefault(num, 0);
            if(cnt > 0) {
                ans.add(num);
                freq.put(num, cnt-1);
            }
        }
            
        return ans.stream().mapToInt(x->x).toArray();
    }
}

//Two Pointer Solution
//TC: O(m+n)
//SC: O(1)

class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m=nums1.length, n=nums2.length;
        int i=0, j=0;
        List<Integer> ans = new ArrayList<>();
        while(i<m && j<n)   {
            if(nums1[i] == nums2[j])    {
                ans.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j])    
                i++;
            else
                j++;
        }
        
        return ans.stream().mapToInt(x->x).toArray();
    }
}

//Binary Search
//TC: O(mlgn)
//SC: O(1)
class Solution3 {

    int binarySearch(int[] nums, int l, int r, int target)    {
        while(l < r)   {
            int mid = l + (r-l)/2;
            if(target <=  nums[mid]) r = mid;
            else    l = mid+1;
        }
        return nums[l] == target ? l : -1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //Ensure nums1 be the smaller array
        if(nums2.length < nums1.length) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m=nums1.length, n=nums2.length;
        List<Integer> ans = new ArrayList<>();
        int s=0, e=n-1;
        for(int num : nums1)    {
            int idx = binarySearch(nums2, s, e, num);
            if(idx != -1)   {
                ans.add(num);
                s = idx+1;
            }
            if(s > e) break;
        }
        
        return ans.stream().mapToInt(x->x).toArray();
    }
}