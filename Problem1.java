
// Time - O(m + n)
//  Space -  O(Min(M,N))



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1); // sort first array
        Arrays.sort(nums2); // sort second array

        if(n1 > n2) return intersect(nums2,nums1);
        List<Integer> result =  new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while(p1 < n1 && p2 < n2) { // two pointers. solution

            if(nums1[p1]  ==  nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;

            } else if(nums1[p1] < nums2[p2])  p1++;
            else  p2++;


        }

        int[] resultArr = new int[result.size()];
        for(int i = 0;  i < result.size(); i++)  {

            resultArr[i] = result.get(i);


        }

        return resultArr;


    }
}
