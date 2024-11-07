/*Time Complexity: O(n1) + O(n2) for hashmap when the arrays are not sorted. If the arrays are sorted, using BS it is O(n1log(n2)) where n1<n2
Space Complexity: O(n1) + O(k)  where n1<n2 while using hashmap and O(1) + O(k) where k is the count of the intersecting elements.
Approach: When the arrays are not sorted, use a hashmap with min size of the arrays and then store the frequencies of the elements in that array. Use this and find all the elements that are present in both arrays by iterating through the second array.
if the arrays are sorted, then we can search for each element in the smaller array by performing a BS on the larger size array.
*/

class intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
//         HashMap<Integer, Integer> map = new HashMap<>();
//         List<Integer> result = new ArrayList<>();
//         for(int value: nums1){
//             map.put(value, map.getOrDefault(value,0) + 1);
//         }
//         for(int value: nums2){
//             if(map.containsKey(value)){
//                 result.add(value);
//                 map.put(value, map.get(value)-1);
//                 if(map.get(value) == 0){
//                     map.remove(value);
//                 }
//             } 
//         }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int h = nums2.length-1;
        for(int value: nums1){
            int foundIndex = binarySearch(nums2, l,h,value);
            if(foundIndex!=-1){
                result.add(value);
                l = foundIndex+1;
            }
        }
        int[] intersection = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            intersection[i]  = result.get(i);
        }
        
        return intersection;
           
    }
    
    private int binarySearch(int[] arr, int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(( mid == l && arr[mid] == target ) || (arr[mid] == target && arr[mid] != arr[mid-1])){
                return mid;
            }
            else if(arr[mid]<target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;

    }
}