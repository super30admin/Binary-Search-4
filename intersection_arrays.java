//TC: O(n+k) n is max length of 2 arrays , K is range of data
//SC: O(n+k)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int freq1[] = new int[1001];
        int freq2[] = new int[1001];
        for(int i=0;i<nums1.length;i++){
            freq1[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            freq2[nums2[i]]++;
        }
        int freqres[] = new int[1001];
        int size=0;
        for(int i=0;i<1001;i++){
            freqres[i] = Math.min(freq1[i],freq2[i]);
            size+=freqres[i];
        }
        int res[] = new int[size];
        int pointer = 0;
        for(int i=0;i<1001;i++){
            while(freqres[i]!=0){
                res[pointer] = i;
                pointer++;
                freqres[i]--;
            }
        }
        return res;
    }
}