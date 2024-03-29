/* https://javaiyagi.tistory.com/599 블로그 참고 */

#include <iostream>
#include <string.h>
using namespace std;

int main() {
    long long N;
    cin >> N;

    long long H[N];
    for (long long i = 0 ; i < N ; i++) {
        cin >> H[i];
    }

    long long arrow = 0;
    long long arrowLoc[1000001];
    for (long long i = 0 ; i < 1000001 ; i++) {
        arrowLoc[i] = 0;
    }

    for (long long i = 0 ; i < N ; i++) {
        long long curH = H[i];
        if (arrowLoc[curH] == 0) {
            arrow++;
            arrowLoc[curH-1]++;
        } else {
            arrowLoc[curH]--;
            arrowLoc[curH-1]++;
        }
    }

    cout << arrow;

    return 0;
}