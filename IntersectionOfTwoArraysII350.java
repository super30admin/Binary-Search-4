import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//time complexity : NlogN
//space complexity : O(m) m.size of array
//leet code : yes
//steps : sorted given arrays and applied binary search
class IntersectionOfTwoArraysII350 {

        public int[] intersect(int[] nums1, int[] nums2) {
            
            int first = 0,second =0;
            
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            
            List<Integer> result = new LinkedList<>();
            
            while(first<nums1.length && second <nums2.length){
                
                if(nums1[first] == nums2[second]){
                    result.add(nums1[first]);
                    first++;
                    second++;
                }
                else if (nums1[first]>nums2[second]){
                    second++;
                } else {
                    first++;
                }
                
            }
            
            int [] intersection = new int[result.size()];
            int i = 0;
            for(int m : result){
                intersection[i++] = m;
            }
            
            return intersection;
            
        }
    
        public static void main(String[] args) {
            IntersectionOfTwoArraysII350 ii = new IntersectionOfTwoArraysII350();
            for(int i : ii.intersect(new int[] {1,2,2,1}, new int[]{2,2}))
            System.out.println(i);
        }
}