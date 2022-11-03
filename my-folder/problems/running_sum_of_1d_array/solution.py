class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        n = len(nums)
        arr = [nums[0]]

        for i in range(1, n):
            # print(nums[i])
            nums[i] = nums[i]+nums[i-1]
            arr.append(nums[i])
        return arr
