//350. Intersaction of Two Arrays 2 - https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
//Time Complexity: O(m+n)
//Space Complexity: O(min(m+n))

//Using Frequency HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m){
            return intersect(nums2, nums1);
        }
        //create map and add default frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>result = new ArrayList<>();
        //if contains, add to result, subtract 1 from frequency, remove if 0
        for(int num : nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num, 0);
            }
        }

        int arr[] = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            arr[i] = result.get(i);
        }

        return arr;
    }
}


//Time Complexity: n log(n) + (m+n)
//Space Complexity: O(1)
//2-Pointer Solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //base case
        if(nums1 == null || nums2 == null || n1 == 0 || n2 == 0){
            return new int[0];
        }

        if(n1 > n2){
            intersect(nums2, nums1);
        }
        //2 pointer will only work if the arrays are sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0; int p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
                p1++; p2++;
            } else if(nums1[p1] < nums2[p2]){
                p1++;
            } else {
                p2++;
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i]=list.get(i);
        }
        return result;
    }
}