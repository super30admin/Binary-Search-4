//Time Complexity :O(N)to O(Log(N)).
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope
We can make it O(Log(N)) by binarysearch

//Your code here along with comments explaining your approach
class HIndex {
    public int hIndex1(int[] citations) {
        int index = 0, n = citations.length;
        for(int c : citations){
            if(c>=n-index){
                return n-index;
            }
            index++;
        }
    return 0;
    }
	public int hIndex2(int[] citations) {
        int start = 0, end = citations.length - 1, n = end + 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int diff = n - mid;
            if(citations[mid] == diff){
                return diff;
            }
            if(citations[mid] < diff){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    return n - start;
    }
}