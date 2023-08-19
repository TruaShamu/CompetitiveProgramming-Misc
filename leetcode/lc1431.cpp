class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> x;
        int maxC = 0;
        for (int i =0; i< candies.size(); i++) {
            maxC = max(maxC, candies[i]);
        }
        for (int i=0; i< candies.size(); i++) {
            x.push_back(candies[i] + extraCandies >= maxC);
        }
        return x;
    }
};
