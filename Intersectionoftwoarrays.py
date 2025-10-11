class Solution(object):
    def intersect(self, nums1, nums2):
        # trade of solution 
        # 1 : hashmap , save the smallest arr with the number and the frequency in the hashmap and in the longest arr we compare if the element is in the hahsmap if yes we will add hat number into a result and reduce the count by 1 from the hashmap, this way we can return the numbers with the frequency in both the arrays
        # sc : O(min(n,m)), tc : O(m+n) processing both the arrays one to create the hashmap other to get the common elements
        # 2 : sort both arrays and then use two pointers to find the common elements between the arrays,using two pointers we check the element is same or not if same save it, if not move the smaller value pointer to next to get a high number which can be common in the both lists 
        # sc : O(1), tc : O(mlogm + nlogn)[to sort] + O(m+n)[to get the result]
        # if its given a sorted array then using two pointers is best because in that case both have the same tc, sc is better with two pointers, if not if we want in lesser tiem then we go for hashmap , if we want lesser space then we go for two pointers
        # ran successfully on leetcode

        nums1.sort()
        nums2.sort()

        p1 = p2 = 0 # both starting with 0 
        result = []

        while p1 < len(nums1) and p2 < len(nums2): # if any of it hit th eboundry case our while loop stops
           if nums1[p1] == nums2[p2]:
            result.append(nums1[p1]) # save the number and move both the pointers 
            p1+=1
            p2+=1
           elif nums1[p1] > nums2[p2]: # move our p2 to reach a higher number which can be a common number
            p2 +=1
           else :
            p1+=1

        return result
