class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        List<Integer>list = new ArrayList<>();
        int low =0; int high = n-1;
        for(int i=0; i<m; i++){
            int target = nums1[i];
            int idx = BinarySearch(nums2,low, high, target);

            if(idx != -1){
                list.add(target);
                low = idx+1;
            }

        }

        int [] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;


        
    }

    private int BinarySearch(int [] nums, int low, int high, int target){
            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid] == target){
                if(mid == low || nums[mid] != nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;

                }
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            }

            return -1;
            
        }
}

/**
 * Arr1 =[4,9,5,9,9] arr2=[9,4,9,8,4] → intersection = [4,9,9]
First approach is by taking a hashmap and storing all counts. Then iterating to the next array and reducing the count. Whenever the value becomes ‘0’ we put that number into a new list and remove that number from the hashmap.
TC : O(m +n) SC : O Min(m,n)

Second approach is to sort and use 2 pointers.
First sort both arrays and Compare both pointers and increase the pointer with a small number.
TC : nlogn [HashMap is better] 
If arrays are already sorted then it's O(m+N).

Next approach is to sort and apply binary search → whenever we find the first element we increase low to the next index.
Searching for the first occurrence. So that we can find multiple same numbers.
TC : O(max(m * log(m), n * log(n))).
Sc : O(min(m, n))
 * 
 * 
 * 
 * 
 * 
 * 
 */