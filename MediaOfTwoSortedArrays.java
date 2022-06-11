// Time: O(M+N) | Space: O(Min(M,N))

// HashMap solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n < m) return intersect(nums2, nums1);
        // maintaining a hashMap of frequencies of all the elements from the smaller size array
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int curr: nums1) {
            frequencies.put(curr, frequencies.getOrDefault(curr, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        // traversing on the larger array, reducing the count on the frequencies map against the element val
        // adding it to our result
        for(int i=0;i<nums2.length; i++) { // O(N)
            if(frequencies.containsKey(nums2[i])) {
                list.add(nums2[i]);
                frequencies.put(nums2[i], frequencies.get(nums2[i])-1);
                // once the frequency goes to 0, removing that entry from the map itself
                if(frequencies.get(nums2[i]) == 0) frequencies.remove(nums2[i]);
            }
        }
        // converting the List to int[]
        return list.stream().mapToInt(i -> i).toArray();
    }
}

//Time: O(Min(M, N))+O(MLogM)+O(NLogN) | Space: O(1)

// Two pointers soln
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length <  nums1.length) return intersect(nums2, nums1);
        // sorting the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int firstPointer = 0;
        int secondPointer = 0;
        List<Integer> res = new ArrayList<>();
        // traversing on the both the arrays simultaneously,
        // if the value of num1 at a curr pointer less than the value of num2 at its own pointer,
        // then move on with next value on num1
        // if the other way, increase the secondPointer
        // if they both are equal, add it to our result
        // move both the pointers to avoid duplicate frequencies in the result
        while(firstPointer < m && secondPointer < n) {
            if(nums1[firstPointer] == nums2[secondPointer]) {
                res.add(nums1[firstPointer]);
                firstPointer++;
                secondPointer++;
            } else if(nums1[firstPointer] < nums2[secondPointer]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}

// Time: O(Min(M,N)*log(Max(M,N)) | Space: O(1)

// binarySearch soln
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length <  nums1.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = nums2.length-1;
        for(int i=0;i<nums1.length;i++) {
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            // if an element is present in the second array
            // add it to result,
            // squeeze the range of binarySearch from next iteration onwords
            if(bsIndex != -1) {
                res.add(nums1[i]);
                low = bsIndex+1;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    private static int binarySearch(int[] nums, int low, int high, int target) {
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) {
                // to find the occurence of the target
                if(mid > low && nums[mid] == nums[mid-1]) {
                    high = mid-1;
                } else {
                    return mid;
                }
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}