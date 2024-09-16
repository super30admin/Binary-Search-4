//Time complexity : O(log n)
//space complexity :O(1)
/*Approach
-applying binary search to see where is the least difference between number of citations and number of
papers
-if number of citations is less than # of papers at mid then we will move low to mid+1
else we will move high to mid-1
-at the end low pointer will be at correct index,  we will return total # of papers - low
 */
public class Hindex{
    public int hIndex(int[] citations) {
        if(citations == null|| citations.length == 0) return 0;
        int n = citations.length;
        int low = 0; int high = n-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            int diff =  n - mid;
            if(citations[mid] < diff){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return n- low;
    }

    public static void main(String args[]){
        Hindex obj = new Hindex();
        System.out.println(obj.hIndex(new int[]{0,1,3,5,6}));
    }
}