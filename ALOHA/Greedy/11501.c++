#include <iostream>
using namespace std;

int main() {
    int T;
    cin >> T;

    for (int i = 0 ; i < T ; i++) {
        long long N;
        cin >> N;

        int stck[N];
        for (long long j = 0 ; j < N ; j++) {
            cin >> stck[j];
        }

        int max = stck[N-1];
        long long ans = 0;
        for (long long j = N-1; j >=0; j--) {
            int curStck = stck[j];

            if (curStck < max) {
                ans += (max - curStck);
            }
            else {
                max = curStck;
            }
        }

        cout << ans << endl;
    }

    return 0;
}