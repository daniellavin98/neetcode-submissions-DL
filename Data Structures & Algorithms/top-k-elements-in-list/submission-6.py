class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        freq = {}

        min_heap = []
        result = []

        for i in range(len(nums)):
            if nums[i] not in freq:
                freq[nums[i]] = 1
            else:
                freq[nums[i]] += 1
        

        for num in freq.keys():
            heapq.heappush(min_heap, (freq[num], num))

            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        for i in range(k):
            result.append(heapq.heappop(min_heap)[1])
        
        return result



        