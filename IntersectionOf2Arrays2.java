class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Using Binary search and using finding first occurence of repeating element pattern
        // TC=O(mlogn) where m and n are the lengths of 2 arrays
        
        int m = nums1.length;
        int n = nums2.length;
        // to ensure that always the first argument is the smaller array
        if(m>n) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int target = 0;
        int low = 0; int high = n-1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            target = nums1[i];
            int bidx = search(nums2,low,high,target);
            if(bidx != -1){
                list.add(target);
                low = bidx + 1;
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private int search(int[] nums2,int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums2[mid] == target){
                if(mid==low || nums2[mid]!=nums2[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(target>nums2[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}

// class Solution {
//     // Using 2 pointer solution assuming that the 2 arrays are sorted
//     // TC = O(Max(m,n)) - m,n are the lengths of the 2 arrays
//     public int[] intersect(int[] nums1, int[] nums2) {
        
//         int m = nums1.length;
//         int n = nums2.length;
//         // to ensure that always the first argument is the smaller array
//         if(m>n) return intersect(nums2,nums1);
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int p = 0; int q = 0; // 2 pointers p and q
//         List<Integer> list = new ArrayList<>();
//         while(p<m && q<n){
//             if(nums1[p] == nums2[q]){
//                 list.add(nums1[p]);
//                 p++;q++;
//             }else if(nums1[p]>nums2[q]){
//                 q++;
//             }else{
//                 p++;
//             }
//         }
//         int[] result = new int[list.size()];
//         for(int i=0;i<list.size();i++){
//             result[i] = list.get(i);
//         }
//         return result;
//     }
// }

// Using freq Map
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         // to ensure that always the first argument is the smaller array
//         if(m>n) return intersect(nums2,nums1);
//         HashMap<Integer,Integer> map = new HashMap<>();
//         // Iterating through the smaller array
//         for(int i=0;i<m;i++){
//             map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
//         }
//         List<Integer> list = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             if(map.containsKey(nums2[i])){
//                 int temp = map.get(nums2[i]);
//                 temp--;
//                 if(temp == 0) map.remove(nums2[i]);
//                 else map.put(nums2[i],temp);
//                 list.add(nums2[i]);
//             }
//         }
//         int[] result = new int[list.size()];
//         for(int i=0;i<list.size();i++){
//             result[i] = list.get(i);
//         }
//         return result;
//     }
// }