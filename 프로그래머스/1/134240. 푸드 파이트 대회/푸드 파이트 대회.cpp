#include <string>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <sstream>

#include <iostream>
using namespace std;

string solution(vector<int> food) {
    
    string answer = "";
    
    for(int i=1;i<food.size();i++){
        
        // while(food[i]>1){
        //     answer+=to_string(i);
        //     food[i]-=2;
        // }
        while(food[i]>1){
            answer+=to_string(i);
            food[i]-=2;
        }
    }
    //string r_answer = answer;
    //reverse(r_answer.begin(),r_answer.end());
    string r_answer = answer;
    reverse(r_answer.begin(),r_answer.end());


    //answer = first;
    //answer+='0';
    //answer += reverse(first.begin(),first.end());
    return answer+'0'+r_answer;
}