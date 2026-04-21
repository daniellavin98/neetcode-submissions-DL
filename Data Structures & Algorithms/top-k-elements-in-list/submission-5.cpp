class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        //create a min heap
        //add (frequency, value) pairs to min heap
        //once the heap grows past k, remoce the smallest

        vector<int> result; 

        unordered_map<int, int> freq; 

        for(int i = 0; i < nums.size(); i++){
            if(!freq.contains(nums[i])){
                freq[nums[i]] = 1;
            }
            else{
                freq[nums[i]]++;
            }
        }

        // Min-heap storing {frequency, value} pairs
    // In C++, priority_queue is a max-heap by default; 
    // std::greater makes it a min-heap.

        priority_queue<pair<int, int>, 
                      vector<pair<int, int>>, 
                      greater<pair<int,int>>> minHeap; 

        for(const auto& entry : freq){
            minHeap.push({entry.second, entry.first});

            if(minHeap.size() > k){
                minHeap.pop();
            }
        }

        for(int i = 0; i < k; i++){
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }

        return result;
    }
};
