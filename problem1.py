#Intersection of Two Arrays II

# // Time Complexity :  O(max(n,m))
# // Space Complexity : O(min(n,m))
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def intersect(nums1, nums2) :
    if len(nums2)>len(nums1):
        intersect(nums2,nums1)
    hashmap={}
    for i in nums2:
        hashmap[i] = hashmap.get(i,0)+1                 #store the count of everything on the first array to a dict
    res=[]
    for i in nums1:
        if(i in hashmap and hashmap[i]>0):                 #check the elements of the other array occurs more than 0 times on the previous array
            res.append(i)
            hashmap[i]-=1
    return res