// Time Complexity : O(N + M)
// Space Complexity : O(n) n would be the length of smaller array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * creating a frequency map of smaller array and then iterating over the larger array to look for same elements
 * and adding those elements in a new list. Also, reducing the frequency when same elements are found.
 */

class Problem1 {
    public int[] intersect(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if(nums1==null || nums2== null) return new int[0];

        //to make sure nums2 is the smaller array every time
        if(nums1.length < nums2.length) return intersect(nums2,nums1);

        //taking a frequency map of smaller array
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums2){
            //creating a frequency map
            map.put(num, map.getOrDefault(num,0)+1);
        }

        //will have to take a list since we don't know the size of array
        List<Integer> li = new ArrayList<>();
        for(int num : nums1){

            //if number is there in larger array
            //add it to list and reduce the freq
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                //remove the element when frequency becomes zero
                map.remove(num,0);

            }
        }

        //converting the list into array
        int[] result = new int[li.size()];
        for(int i=0; i<result.length; i++){
            result[i]= li.get(i);
        }
        return result;
    }
}