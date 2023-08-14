// Time Complexity :O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Check which array is short and proceed accordingly
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();

        //Store numbers of short array into hashmap with it's frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //Go through all the numbers in 2nd array to find common numbers
        for(int num: nums2){
            if(map.containsKey(num)){
                result.add(num);
                int temp = map.get(num);
                if(temp == 1){
                    map.remove(num);
                }
                else{
                    map.put(num, temp-1);
                }
            }
        }

        //Put all the common numbers in array
        int size= result.size();
        int[] res = new int[size];
        for(int i=0; i<size; i++){
            res[i] = result.get(i);
        }

        return res;
    }
}