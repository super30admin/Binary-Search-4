
// TC - O(n+m)
// SC - (1)

class IntersectionArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if( nums1== null || nums1.length== 0 || nums2== null || nums2.length== 0)
        {
        return new int[] {};
        }
int n1 = nums1.length ;
int n2 = nums2.length ;
if (n1 > n2) {
return intersect(nums2, nums1);
}
HashMap<Integer, Integer> map = new HashMap<>();
for ( int num : nums1){
map.put( num, map.getOrDefault( num, 0) + 1) ;
}

List<Integer> result = new ArrayList<>();
for(int i =0 ; i < n2 ; i ++){
if(map.containsKey(nums2[i])){
result.add(nums2[i]);
map.put(nums2[i], map.get(nums2[i]) - 1);
map.remove(nums2[i], 0);
}
if(map.size() == 0){
break;
}
}

int[] array = new int[result.size()];
for(int i =0 ; i < result.size() ; i ++ ){
array[i] = result.get(i);
}
return array;
}
}

