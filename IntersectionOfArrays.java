// Time Complexity : O(m+n)
// Space Complexity : O(m) , size of hashmap which is equal to size of smaller array here
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach: For unsorted arrays
1. For the smaller size array, store the elements and their frequency in a Hashmap
2. Traverse through the other array and check if its elements are present in the map
3. Add each common element to a list and reduce its frequency by 1 in the hashmap
4. return the list elements in an output array.
 */

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        int n1=nums1.length;
        int n2= nums2.length;

        if(n1>n2){
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res= new ArrayList<>();

        for(int num:nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num:nums2){

            if(map.containsKey(num)&&map.get(num)>0){
                res.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int arr[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}

/* Followup: If arrays are sorted
Approach: Using two pointers

Time: O(m+n)
Space: O(1)
*/
class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        int n1=nums1.length;
        int n2= nums2.length;

        if(n1>n2){
            return intersect(nums2, nums1);
        }

        List<Integer> res= new ArrayList<>();

        int ptr1=0,ptr2=0;

        while(ptr1<n1&&ptr2<n2){

            if(nums1[ptr1]==nums2[ptr2]){
                res.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1]<nums2[ptr2]){
                ptr1++;
            }
            else{
                ptr2++;
            }
        }

        int arr[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}