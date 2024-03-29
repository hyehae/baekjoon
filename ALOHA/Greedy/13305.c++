#include <iostream>
using namespace std;

int main() {
    long long N;
    cin >> N;

    long long dis[N-1];
    long long city[N];
    long long K = 0;

    for (long long i = 0 ; i < N-1; i++) {
        cin >> dis[i];
        K += dis[i];
    }
    for (long long i = 0 ; i < N; i++) {
        cin >> city[i];
    }

    long long curCost = city[0];
    long long cost = 0;
    for (long long i = 0; i < N-1; i++) {
        if (K == 0) {
            break;
        }

        if (curCost <= city[i]) {
            cost += curCost * dis[i];
            K -= dis[i];
        } else {
            curCost = city[i];
            cost += curCost * dis[i];
            K -= dis[i];
        }

    }

    cout << cost;
    return 0;

}