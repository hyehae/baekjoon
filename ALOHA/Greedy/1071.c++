#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> arr(N);
    vector<int> cnt(1001, 0);
    
    for (int i = 0 ; i < N ; i++) {
        cin >> arr[i];
        cnt[arr[i]]++;
    }
    
    int max = *max_element(arr.begin(), arr.end());
    vector<int> continuous;

    while (true) {
        continuous.clear();

        for (int i = 0 ; i <= max ; i++) {
            if (cnt[i] != 0) {
                continuous.push_back(i);
                if (continuous.size() == 3) break;
            }
        }


        if (continuous.size() == 1) {
            int frst = continuous[0];
            int frstIter = cnt[frst];

            for (int i = 0 ; i < frstIter ; i++) {
                cout << frst << " ";
                cnt[frst]--;
            }

            break;
        }

        if (continuous.size() == 2) {
            int frst = continuous[0];
            int scnd = continuous[1];

            int frstIter = cnt[frst];
            int scndIter = cnt[scnd];

            if (scnd == frst+1) {
                for (int i = 0 ; i < scndIter ; i++) {
                    cout << scnd << " ";
                    cnt[scnd]--;
                }

                for (int i = 0 ; i < frstIter ; i++) {
                    cout << frst << " ";
                    cnt[frst]--;
                }

                break;
            }

            for (int i = 0 ; i < frstIter ; i++) {
                cout << frst << " ";
                cnt[frst]--;
            }
            
            for (int i = 0 ; i < scndIter ; i++) {
                cout << scnd << " ";
                cnt[scnd]--;
            }
            
            break;

        }

        int frst = continuous[0];
        int scnd = continuous[1];
        int thrd = continuous[2];

        int frstIter = cnt[frst];
        int scndIter = cnt[scnd];
        int thrdIter = cnt[thrd];

        if (scnd != frst+1) {
            for (int i = 0 ; i < frstIter ; i++) {
                cout << frst << " ";
                cnt[frst]--;
            }
        }

        else {
            for (int i = 0 ; i < frstIter ; i++) {
                cout << frst << " ";
                cnt[frst]--;
            }

            cout << thrd << " ";
            cnt[thrd]--;
        }
    }

    return 0;
}