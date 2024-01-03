#include <iostream>

void quick(int arr[], int left, int right) {
    if(left > right) {
        return;
    }

    int pivot = arr[left];
    int i = left+1;
    int j = right;

    while(i <= j) {
        while(pivot > arr[i]) {
            i++;
        }

        while(pivot < arr[j]) {
            j--;
        } 

        if(i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        } else {
            break;
        }
    }

    arr[left] = arr[j];
    arr[j] = pivot;

    quick(arr, left, j-1);
    quick(arr, j+1, right);
}

int main() {
    int N;
    std::cin >> N;
    int arr[N];

    for(int i=0; i<N; i++) {
        std::cin >> arr[i];
    }
    
    quick(arr, 0, N-1);

    for(int i=0; i<N; i++) {
        std::cout << arr[i] << "\n";
    }
}