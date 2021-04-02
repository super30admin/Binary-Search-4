
//Time Complexity : Max(n,m)logMAx(n,m)
//Space Complexity : O(1)
public class Main {
    public static void main(String[] args) {
        int [][] A = {{1,1000},{2,2000},{3,3000}};
        int [][] B = {{1,1000},{2,2000},{3,3000}};
        int target = 4000;
        List<int []> output = new ArrayList<>();
        
        Arrays.sort(B, (a,b) -> a[1] - b[1]); //mlogm
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i< A.length; i++){
            int curr = A[i][1];
            int index = binarySearch(B, target-curr);
            
            if(index != -1) {
                int sum = curr+B[index][1];
                if(sum>=max){
                if(sum > max){
                    output = new ArrayList<>();
                }
                    
                output.add(new int[]{A[i][0], B[index][0]});
                } 
            }
            for(int[] el : output){
                System.out.println(el[0] + "," + el[1]);
            }
        }
        
    }
    
    public static int binarySearch(int[][] B, int target){
        int low = 0;
        int high = B.length;
        while(low<=high){
          int mid = low + (high-low)/2;
            if(B[mid][1] == target)
                return mid;
            else if(B[mid][1] < target)
                low = mid+1;
            else
                high = mid-1;
            
        }
        
        return high;
    }
}