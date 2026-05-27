class Solution {
public:
    int numberOfSpecialChars(string word) {
        int n = word.size();
        vector<int> arr1(26, -1);//it will represent last index of lowercase letter
        vector<int> arr2(26, -1);//it will represent first index of uppercase letter

        for(int i = 0; i < n; i++) {
            if(islower(word[i])) {
                int idx = word[i] - 'a';
                arr1[idx] = i;
            }
            else {
                int idx = word[i] - 'A';
                if(arr2[idx] == -1) {
                    arr2[idx] = i;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < 26; i++) {
            if(arr1[i] == -1 || arr2[i] == -1) {
                continue;
            }
            if(arr1[i] < arr2[i]) {
                ans++;
            }
        }

        return ans;
    }
};