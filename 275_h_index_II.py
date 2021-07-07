class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
            https://leetcode.com/problems/h-index-ii/
            Time Complexity - O(n)
            'n' is the number of search papers
            Space Complexity - O(1)
        """
        # edge case
        if not citations:
            return 0

        # total number of research papers
        n = len(citations)

        # for each research paper
        for i in range(len(citations)):

            # no of citations for current research paper
            val = citations[i]

            # remaining papers including the current paper
            diff = n - i

            # the no of citations for the current paper is more
            # than or equal to the research paper no itself.
            # The upcoming research papers will also have more citations
            # because the list is sorted by the no of citations for each
            # research paper.

            if val >= diff:
                return diff
        return 0

    def hIndex(self, citations: List[int]) -> int:
        """
            https://leetcode.com/problems/h-index-ii/
            Time Complexity - O(logn)
            'n' is the number of search papers
            Space Complexity - O(1)
        """
        # edge case
        if not citations:
            return 0

        # total number of research papers
        n = len(citations)

        low = 0
        high = n - 1
        while low <= high:
            mid = (low + high) // 2
            val = citations[mid]
            diff = n - mid
            if val == diff:
                return val
            elif val >= diff:
                high = mid - 1
            else:
                low = mid + 1

        # low is at the right position
        return n - low
