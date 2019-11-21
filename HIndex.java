//Time Complexity :O(N).
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope
We can make it O(Log(N)) by binarysearch

//Your code here along with comments explaining your approach
class HIndex {
    public int hIndex(int[] citations) {
        int index = 0, n = citations.length;
        for(int c : citations){
            if(c>=n-index){
                return n-index;
            }
            index++;
        }
    return 0;
    }
}