
// Hashing based solution
// Add all elements in nums1 into a hashmap. Later iterate over nums2 and check if elements of it is present in HashMap
// TC - O(m+n)
// SC - O(min(m,n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }

        int intersectionSize = 0;
        for(int i=0;i<nums2.length;i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                intersectionSize++;
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }

        //reset the frequency map for nums1
        for(int i=0;i<nums1.length;i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }


        int k = 0;
        int[] result = new int[intersectionSize];
        for(int i=0;i<nums2.length;i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                result[k] = nums2[i];
                map.put(nums2[i],map.get(nums2[i])-1);
                k++;
            }
        }
    return result;
    }
}

// Two-pointer technique
// TC - O(nlogn + mlogm)
// SC = O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length == 0 || nums2.length==0) return result;
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]){
                p2++;
            } else {
                result[k] = nums1[p1];
                p1++;
                p2++;
                k++;
            }
        }
        return Arrays.copyOfRange(result, 0, k);
    }
}

