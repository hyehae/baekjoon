/* https://0m1n.tistory.com/66 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
   int N;
   cin >> N;

   vector<int> alphabet(26);
   vector<string> words(N);
   for (int i = 0 ; i < N ; i++) {
      cin >> words[i];
   }

   for (int i = 0 ; i < N ; i++) {
      int weight = 1;
      for (int j = words[i].size()-1 ; j >= 0 ; j--) {
         int val = words[i][j] - 'A';
         alphabet[val] += weight;
         weight *= 10;
      }
   }

   sort(alphabet.begin(), alphabet.end(), greater<int>());
   
   int num = 9;
   int sum = 0;
   for (int i = 0 ; i < 26 ; i++) {
      if(alphabet[i] == 0) {
         break;
      }

      sum += alphabet[i]*num;
      num--;
   }
   
   cout << sum;

   return 0;
}
