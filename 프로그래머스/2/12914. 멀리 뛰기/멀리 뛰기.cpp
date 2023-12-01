#include <string>
#include <vector>

using namespace std;
//해당 코드는 결과론적으로 봤을때 피보나치와 완전 동일 ㅋㅋ 훼이크지렷
long long solution(int n) {
    long long arr[2000];
    arr[0] = 1;
    arr[1] = 1;
    for(int i = 2; i <= n; i++)
        arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
    
    return arr[n];
}