class Solution(object):
    def singleNumber(self, nums):
        result = 0
        for num in nums:
            result ^= num
        return result
        """
        :type nums: List[int]
        :rtype: int
        """
        
