class Solution(object):
    def containsDuplicate(self, nums):
        if len(nums) != len(set(nums)):
            return True
        else:
            return False

# Take input as list of integers
nums = list(map(int, input("Enter the numbers: ").split()))

# Create object and call method
sol = Solution()
print(sol.containsDuplicate(nums))
