
class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        //hashmap appraoch
        return intersectUtil(nums1, nums2);
        //sorting approach
        return intersectUtilSorting(nums1, nums2);
    }
    /*approach 1: HashMap based. 
    I would be putting all the values of smaller array into hashmap with their count and
    while iterating over larger array. if the count of the number is greater than 0 then 
    i would be adding that number in the result and decrementing the count.
    It mean current number is common between 2 array
    time complexity: O(m+n) where m is the length of array1 and n is the length of array2
    Space Complexity: O(m) m is the length shorter array*/
    private int[] intersectUtil(int[] nums1, int[] nums2){
        Map<Integer, Integer> countMap;
        countMap = new HashMap<>();
        
        //just to save space. if num1 is larger size then we would end up inserting too
        //many values in the map which is not required. 
        if(nums1.length > nums2.length )
            return intersect(nums2, nums1);
        
        //create map of smaller array
        for(int i: nums1)
            countMap.put(i,countMap.getOrDefault(i, 0)+1);
        
        int index =0;
        for(int i: nums2){
            if(countMap.containsKey(i) && countMap.get(i) > 0){
                nums1[index++] = i;
                countMap.put(i, countMap.get(i)-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
    /*
    Sorting both arrays and then taking intersection
    Time Complexity: O(mlogm + nlogn) + (m+n) =  O(mlogm + nlogn) 
    where m and n is the size of the both the arrays respectively. 
    mlogm and nlogn is time required for sorting and then m+n is time required for finding intersection 
    Space Complexity would be O(1) as we are not using any extra space here.
    */
    
    private int[] intersectUtilSorting(int[] nums1, int[] nums2){
        
        if(nums1 == null && nums2== null && nums1.length ==0 && nums2.length ==0) return new int[]{};
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        int len1= nums1.length , len2= nums2.length;
        //finding intersection
        while(i< len1 && j< len2){
            //equal elements, intersection. add it to result and increment pointer
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            }
            //moving index of smaller element.
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] res = new int[list.size()];
        int index=0;
        for(int k: list)
            res[index++] = k;
        
        return res;
    }
}
