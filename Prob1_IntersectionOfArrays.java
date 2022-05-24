// Time Complexity : O(max(m,n)) == O(m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        if(num1.length < num2.length)   return intersect(num2, num1); // Keeping num1 as larger array everytime so
        
        if(num1 == null || num2 == null)    return new int[0];
        Arrays.sort(num1); Arrays.sort(num2);
        
        int l = 0;
        int h = 0;
        
        int m = num1.length;
        int n = num2.length;
        List<Integer> list =  new ArrayList<>();

        while(l < m && h < n){
            if(num1[l] == num2[h]){
                list.add(num2[h]);
                l++;
                h++;
            }else{
                if(num1[l] > num2[h])   h++;
                else    l++;
            }
        }
        
        int[] data = new int[list.size()]; // Converting list to int array[]
        
        for(int i = 0; i< data.length; i++){
            data[i] = list.get(i);
        }
        
        return data;
    }
}
/*
// Time Complexity : O(Max(m,n)) = O(m)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        
        if(num1 == null || num2 == null)    return new int[0];
        
        HashMap<Integer, Integer> map = new HashMap();
        
        
        for(int n : num2){
            map.put(n, map.getOrDefault(n, 0) + 1);
        } // Putted all elements of smaller array in HashMap
        
        int c = 0;
        while(c < num1.length){ // Iterating larger array 
            if(map.containsKey(num1[c])) { // If num2[c] is in map as key, 
                map.put(num1[c], map.get(num1[c]) - 1 ); // Decrease its count by 1
                list.add(num1[c]);
                map.remove(num1[c], 0);
            }
            c++;
        }
        
        int[] data = new int[list.size()]; // Converting list to int array[]
        
        for(int i = 0; i< data.length; i++){
            data[i] = list.get(i);
        }
        
        return data;
    }
}



*/