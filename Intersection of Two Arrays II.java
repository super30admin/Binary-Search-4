/*
# tc - O(n) 
# space - O(min(m,n))
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2) == 0:
            return []
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)
        
        mapping = collections.defaultdict(int)
        
        for num in nums1:
            mapping[num] += 1
            
        result = []
        for num in nums2:
            if num in mapping:
                result.append(num)
                mapping[num] -= 1
                if mapping[num] == 0:
                    del mapping[num]
        return result
*/
/*
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2) == 0:
            return []
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)
        nums2.sort()
        nums1.sort()
        result = []
        low = 0
        for i in range(n1):
            index = self.binary(nums2, low, n2-1, nums1[i])
            if index != -1:
                result.append(nums1[i])
                low = index + 1
        return result
    
    def binary(self, arr, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            
            if arr[mid] == target:
                if mid == low or arr[mid] > arr[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
*/

// Time - O(mlogn) where m is size of small list and n is size of bigger
// Space - O(k) where k is size of arraylist 
// Logic - If both lists are sorted then just iterate over small list and search in bigger list using binary search

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[] {};
        
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return intersect(nums2, nums1);
        
        List<Integer> result = new ArrayList<>();
        int low = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i=0; i<n1; i++){
            int index = binary(nums2, low, n2-1, nums1[i]);
            if (index != -1){
                result.add(nums1[i]);
                low = index + 1;
            }
        }
        int[] ans = new int[result.size()];   
        for (int i=0; i<result.size(); i++)
            ans[i] = result.get(i);
        
        return ans;
    }
    private int binary(int[] arr, int low, int high, int target){
        while (low <= high){
            int mid = low + (high-low)/2;
            if (arr[mid] == target){                        
                if (mid == low || arr[mid] > arr[mid - 1])          // if duplicates are present then we want the first number
                    return mid;
                else
                    high = mid - 1;
            }
            else if (arr[mid] > target)
                high = mid - 1;
            
            else
                low = mid + 1;
        }
        return -1;
    }
}