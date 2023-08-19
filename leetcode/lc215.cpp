class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // reversed priority queue (pops larger numbers first)
        priority_queue<int> pq;
        // push all the elements
        for (int i : nums) {
            pq.push(i);
        }
        // pop largest k-1 numbers
        for (int i=0; i< k-1; i++) {
            pq.pop();
        }
        // the kth largest
        return pq.top();

    }
    };
