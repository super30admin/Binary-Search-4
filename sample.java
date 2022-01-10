//intersection of 2 arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num : nums1){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        List<Integer> result = new ArrayList<>();
//         for(int num : nums2){
            
//             if(map.containsKey(num)){
//                 result.add(num);
//                 map.put(num, map.get(num) - 1);
                
//                 if(map.get(num) == 0) map.remove(num, 0);
//             }
            
//         }
        
//         int [] output = new int[result.size()];
//         for(int i = 0; i < result.size(); i++){
//             output[i] = result.get(i);
//         }
//         return output;
        
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1); Arrays.sort(nums2);
        while(p1<nums1.length && p2<nums2.length){
            
            if(nums1[p1]==nums2[p2]) {
                
                result.add(nums1[p1]);
                p1++; p2++;
            }
            
            else if(nums1[p1] > nums2[p2]) p2++;
            else p1++;
        }
        
        int [] output = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            output[i] = result.get(i);
        }
        return output;
    }
}
//h index

//tc log n
//sc 1
class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
//         for(int i = 0; i<n; i++){
            
//             int diff = n - i; // how many papers are equal to or more
            
//             if(diff<=citations[i]) return diff;
            
//         }
        int low = 0;
        int high = n -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int diff = n - mid;
            if(citations[mid] == diff) return diff;
            else if(citations[mid] > diff) high = mid-1;
            else low = mid+1;
        }
        return n-low;
    }
}

//median of sorted arrays
//tc log (nums1.length)(considering nums1.length<nums2.length)
//sc 1
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
//         int[] arr = new int[nums1.length + nums2.length];

//         //copy both arrays into one
//         System.arraycopy(nums1, 0, arr, 0, nums1.length);
//         System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        
//         //sorting array
//         Arrays.sort(arr);
        double median = 0.0;
        
//         //check if we can get direct median
//         if (arr.length%2==0) {
//             median = arr[arr.length/2]+arr[(arr.length/2) - 1];
//             median = median/2;
//         } else {
//             median = arr[(arr.length/2)];
//         }
        
//         return median;
        // to do->use two pointers the final array will be sorted and we can apply the median basic logic (m+n logic)
        
//         int[] temp = new int[nums1.length + nums2.length];
        
//         int p1 = 0;
//         int p2 = 0;
        
//         int index = 0;
        
//         while(p1<nums1.length && p2<nums2.length && index<temp.length){
            
//             if(nums1[p1]>nums2[p2]){
//                 temp[index] = nums2[p2];
//                 p2++;
//             }
//             else if(nums1[p1]<nums2[p2]){
//                 temp[index] = nums1[p1];
//                 p1++;
//             }
//             else{
//                 temp[index] = nums1[p1];
//                 p1++;
//             }
//              index++;   
//         }
        
//         while(p2<nums2.length && index<temp.length){
//             temp[index] = nums2[p2];
//             index++;
//             p2++;
//         }
        
//         while(p1<nums1.length && index<temp.length){
//             temp[index] = nums1[p1];
//             index++;
//             p1++;
//         }
        
//         for(int i = 0; i < temp.length; i++){
//             System.out.print(temp[i] + " ");
//         }
//         if(temp.length % 2 == 0){
            
//             median = temp[temp.length/2]+temp[(temp.length/2) - 1];
//             median = median/2;
//         }
//         else {
//             median = temp[(temp.length/2)];
//         }
//         return median;
        
        //main algo binary search using partitions
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1==0 && n2==0) return 0.000;
        
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        
        int low = 0;
        int high = n1;
        
        while(low<=high){
            
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double L1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX==n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY==n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1<=R2 && L2<=R1){
                if((n1+n2)%2==0){
                    return (Math.max(L1,L2) + Math.min(R1, R2))/2;
                }
                else
                    return Math.min(R1, R2);
                
            }
            else if(L2>R1){
                low = partX + 1;
            }
            else
                high = partX - 1;
            
        }
        return 1.000;
    }
}
