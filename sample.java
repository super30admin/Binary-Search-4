// Time Complexity : O(m+n) as we may need to traverse both arrays in worst case scenario + O(mlogm) = O(mlogm)
// Space Complexity : O(1) if not considering the arraylist used to create the integer array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0; // pointer on nums1
        int p2 = 0; // pointer on nums2
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1); // sort both arrays
        Arrays.sort(nums2);

        while (p1 < nums1.length && p2 < nums2.length) { // till one of the array finishes
            if (nums1[p1] == nums2[p2]) { // if we found a intersection
                result.add(nums1[p1]); // add to result
                p1++; // move both pointers
                p2++;
            } else if (nums1[p1] < nums2[p2]) // if value in nums1 is less then value at nums2
                p1++; // move pointer of nums1 to increase the value
            else
                p2++; // else move pointer of nums2
        }

        int arr[] = new int[result.size()]; // make an integer array and copy all elements to integer array
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}

// Time Complexity : O(m+n) as we may need to traverse both arrays in worst case
// scenario
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) { // iterate through nums1 and store each number and frequency
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) { // iterate through nums2
            if (map.containsKey(nums2[i])) { // if number is in map
                map.put(nums2[i], map.get(nums2[i]) - 1); // reduce count
                result.add(nums2[i]); // add it to result as present in both arrays
                map.remove(nums2[i], 0); // if frequency becomes zero, reomve it
            }

        }

        int arr[] = new int[result.size()]; // store result in integer array
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}

// Time Complexity : O(mlogn) excluding sorting the arrays
// Space Complexity : O(n) arraylist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // edge case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2)
            return intersect(nums2, nums1); // nums1 should be smaller one

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1); // sorting the two arrays
        Arrays.sort(nums2);
        int index = 0;
        for (int num : nums1) { // traversing nums1
            int bindex = binarySearch(nums2, num, index, nums2.length - 1); // finding the number from nums1 in nums2
                                                                            // and after it is found, decreasing the
                                                                            // range by increasing index
            if (bindex != -1) { // if num found
                result.add(num); // add to result
                index = bindex + 1; // decrease the range
            }

        }

        int arr[] = new int[result.size()];// store result in integer array
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        // finding first occurence of target
        while (low <= high) {
            int mid = low + (high - low) / 2; // find mid

            if (nums[mid] == target) { // if number found
                if (mid == low || nums[mid] > nums[mid - 1]) // check if it is the first occurence
                    return mid; // if it is return mid
                else
                    high = mid - 1; // decrease high to reach the index
            } else if (nums[mid] > target) // if the value in num is greater
                high = mid - 1; // decrease high
            else
                low = mid + 1; // else increase low

        }

        return -1; // number not found
    }
}

// h index
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) // edge case
            return 0;

        for (int i = 0; i < citations.length; i++) { // iterate over the array
            int diff = citations.length - i; // find h index

            if (diff <= citations[i]) // if h index becomes equal or crosses the citations
                return diff; // return the h index
        }

        return 0;
    }
}

// Time Complexity : O(logn) if sorted array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) // edge case
            return 0;
        Arrays.sort(citations); // sorted array

        int low = 0;
        int high = citations.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int diff = citations.length - mid; // finding h index

            if (citations[mid] == diff) // if the citations become equal to h index
                return diff; // diff can be returned
            else if (citations[mid] < diff) // if citation is less than diff we have to move right
                low = mid + 1;
            else
                high = mid - 1; // move left

        }

        return citations.length - low; // if they dont become equal and citations crosses it, the h index is found at
                                       // low index
    }
}

// Time Complexity : O(logn) as binary serach done only on smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) // to make nums1 as smaller one in length
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int partX = low + (high - low) / 2; // find mid partition in x

            int partY = (n1 + n2 + 1) / 2 - partX; // corresponding partition in y

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1]; // finding the element on left side of partx
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX]; // finding the element on right side of partY
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1]; // finding the element on left side of party
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];// finding the element on right side of partY

            if (l1 <= r2 && l2 <= r1) // if correct partition
            {
                if ((n1 + n2) % 2 == 0) // even case
                    return (Math.max(l1, l2) + Math.min(r1, r2)) * 0.5;
                else
                    return Math.max(l1, l2); // odd case

            } else if (l1 > r2) {
                high = partX - 1;// to make l1 small go left
            } else if (l2 > r1) {
                low = partX + 1; // to make l1 small move partY left so move partX right
            }
        }

        return -1;
    }
}