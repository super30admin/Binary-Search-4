// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store in hashmap, count of occurence of each element
// iterate the other array and find common elements
// update map count value

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer,Integer> map = new HashMap();

        for(int i=0;i<n1;i++){
            if (!map.containsKey(nums1[i])) 
                map.put(nums1[i],1);
            else
                map.put(nums1[i],map.get(nums1[i])+1);
        }

        List<Integer> li = new ArrayList();
        for(int i=0;i<n2;i++){
            if (map.containsKey(nums2[i])) {
                li.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
                map.remove(nums2[i],0);
            }
        }

        int [] result = new int[li.size()];
        for(int i=0;i<li.size();i++)
            result[i] = li.get(i);
        
        return result;
    }

    // When araay is sorted, 2 Pointer - O(m+n), BS - O(mlogN)
    public int[] intersectBS(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1); Arrays.sort(nums2);

        List<Integer> li = new ArrayList();
        int low = 0;
        for(int i=0;i<n1;i++){
           int index = binarySearch(nums2, low, n2-1, nums1[i]);
           if(index != -1){
                li.add(nums1[i]);
                low = index +1;   
           }
        }

        int [] result = new int[li.size()];
        for(int i=0;i<li.size();i++)
            result[i] = li.get(i);
        
        return result;
    }

    public int binarySearch(int[] a, int l,int h, int target){
        while (l<=h) {
            int mid = l + (h-l)/2;
            if(a[mid] == target){
                if(mid == l || a[mid] > a[mid-1]) // find the first occurence of the element
                    return mid;
                else
                    h=mid-1;
            }
            else if(a[mid] > target)
                h = mid -1;
            else
                l =mid+1;
        }

        return -1;
    }
}