class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    temp.add(nums2[j]);
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}


// Time Complexity : O(n1 + n2)
// Space Complexity : O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return intersect(nums2, nums1);

        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for(int i = 0; i < n2; i++) {
            if(map.containsKey(nums2[i])) {
                temp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                map.remove(nums2[i], 0);
            }
        }

        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}


