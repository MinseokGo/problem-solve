#include <string>
#include <vector>
#include <set>
#include<iostream>
#include<algorithm>
using namespace std;

// vector<int> solution(vector<int> numbers) {
//     vector<int> answer;
//     set<int> s;
//     sort(numbers.begin(), numbers.end());
//     //for (int i = 0; i < numbers.size(); i++)
//         //cout << numbers[i] << " "; // 벡터내용 출력해보기
    
//     for(int i=0;i<numbers.size();i++){
//         for(int j=i+1;j<numbers.size();j++){
//             s.insert(numbers[i]+numbers[j]);
//         }
//     }
    
//     set<int>::iterator iter;
//     // for(iter = s.begin(); iter != s.end(); iter++){
//     //     //cout << *iter << " " ; // 집합내용을 벡터로 삽입하기
//     //     answer.push_back(*iter);
//     // }    
//     for(auto i = s.begin();i!=s.end();i++){
//         answer.push_back(*i);
//     }
//     return answer;
// }
vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    set<int> s;
    sort(numbers.begin(), numbers.end());
    
    for(int i=0;i<numbers.size();i++){
        for(int j=i+1;j<numbers.size();j++){
            s.insert(numbers[i]+numbers[j]);
        }
    }
    for(auto i=s.begin();i!=s.end();i++){
        answer.push_back(*i);
    }
    return answer;
}