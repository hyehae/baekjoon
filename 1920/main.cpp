#include <iostream>
#include <algorithm>

bool binarysearch(int list[], int len, int num) {
    int left = 0;
    int right = len-1;
    while(left <= right) {
        int mid = (left+right)/2;
        if(list[mid] == num) {
            return true;
        } else if(list[mid] > num) {
            right = mid-1;
        } else {
            left = mid+1;
        }
    }
    return false;
}

int main() {
    int N, M;
    
    std::cin >> N;
    int A[N];
    for(int i=0; i<N; i++) {
        std::cin >> A[i];
    }
    std::sort(A, A+N);

    std::cin >> M;
    int B[M];
    for(int i=0; i<M; i++) {
        std::cin >> B[i];
    }

    for(int i=0; i<M; i++) {
        if(binarysearch(A, N, B[i])) {
            std::cout << 1 << "\n";
        } else {
            std::cout << 0 << "\n";
        }
    }

    return 0;
}