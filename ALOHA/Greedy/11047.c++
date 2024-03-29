#include <iostream>
using namespace std;

int main() {
    int N;
    long long K;
    cin >> N >> K;

    long long val[N];
    for (int i = 0; i < N; i++) {
        cin >> val[i];
    }

    int cnt = 0;
    for (int i = N-1; i >=0 ; i--) {
        if (K == 0) {
            break;
        }

        if (val[i] <= K) {
            cnt += (K/val[i]);
            K -= (val[i] * (K/val[i]));
        }
    }
    
    cout << cnt;
    return 0;
}