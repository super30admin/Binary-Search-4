import java.util.*;

// Approach 1: Using HashMap
// TC : O(m+n)
// SC : O(m) where m is the size of the nums1
public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n1 : nums1) {
            if (!hm.containsKey(n1))
                hm.put(n1, 1);
            else
                hm.put(n1, hm.get(n1) + 1);
        }
        for (int n2 : nums2) {
            if (hm.containsKey(n2)) {
                list.add(n2);
                hm.put(n2, hm.get(n2) - 1);
                if (hm.get(n2) == 0)
                    hm.remove(n2);
            }
        }

        int i = 0;
        int ans[] = new int[list.size()];
        for (int x : list) {
            ans[i++] = x;
        }
        return ans;
    }
}


// Approach 2: Using Sorting and Two Pointers
// TC: O(mlogm + nlogn + m + n) = O(mlogm + nlogn)
// SC: O(1)
class LC350_1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0, q = 0;
        while (p < n1 && q < n2) {
            if (nums1[p] < nums2[q])
                p++;
            else if (nums1[p] > nums2[q])
                q++;
            else {
                list.add(nums1[p]);
                p++;
                q++;
            }
        }
        int i = 0;
        int ans[] = new int[list.size()];
        for (int x : list) {
            ans[i++] = x;
        }
        return ans;
    }
}

// Approach 3: Using Sorting and Binary Search
// TC: O(mlogm + nlogn + mlogn) = O(mlogm + nlogn)
// SC: O(1)
class LC350_3 {
    private int binarySearch(int arr[], int s, int e, int tar) {
        int pos = -1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (arr[mid] == tar) {
                pos = mid;
                e = mid - 1;
            } else if (arr[mid] < tar) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return pos;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // m<n
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int s = 0;
        for (int i = 0; i < m; i++) {
            int x = binarySearch(nums2, s, n - 1, nums1[i]);
            if (x >= 0) {
                list.add(nums1[i]);
                s = x + 1;
            }
        }

        int len = list.size();
        int ans[] = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}