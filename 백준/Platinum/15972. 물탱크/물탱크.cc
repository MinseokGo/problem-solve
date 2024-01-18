#pragma warning(disable:4996)
#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#include <map>
#include <queue>
using namespace std;

const long long INF = 123456789;

/*
2
2 3 5
1 -1 -1
3 2 -1
4 -1 2
-1 -1 4 3
-1 -1 -1 -1
1 5 10
5 -1 -1 -1 6
-1 7 -1 6 -1
-1 2 8 4 2 3


*/


struct hole
{
    int up, down, right, left, height;
};


//height높이(우선순위)이고 x,y로 탐색함
struct PQitem
{
    int x, y, height;
};

struct compare
{
    bool operator()(PQitem a, PQitem b) {
        return a.height > b.height;
    }
};

hole arr[1005][1005];
int N, M, H;
int visited[1001][1001];

int findNextHeight(int x, int y) {
    if (y < 0) {
        return arr[y + 1][x].up;
    }
    if (y == N) {
        return arr[y][x].up;
    }
    if (x < 0) {
        return arr[y][x + 1].left;
    }
    if (x == M) {
        return arr[y][x].left;
    }

    //바깥부분이 아닌경우
    return arr[y][x].height;
}

int main() {

    //freopen("watertank.inp", "r", stdin);
    //freopen("watertank.out", "w", stdout);

    int T; 
    //cin >> T;
    T = 1;
    while (T--) {
        cin >> N >> M >> H;

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M+1; j++) {
                arr[i][j].height = -1;
                arr[i][j].up = -1;
                arr[i][j].down = -1;
                arr[i][j].left = -1;
                arr[i][j].right = -1;
            }
        }

        fill(&visited[0][0], &visited[1000][1001], 0);
     

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M; j++) {
                int temp; cin >> temp;
                arr[i][j].up = temp;
                if (i != 0) {
                    arr[i - 1][j].down = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M + 1; j++) {
                int temp; cin >> temp;
                arr[i][j].left = temp;
                if (j != 0) {
                    arr[i][j - 1].right = temp;
                }
            }
        }

        priority_queue<PQitem, vector<PQitem>, compare> pq;
        //가장위 구멍 PQ에 넣기
        for (int i = 0; i < M; i++) {
            if (arr[0][i].up != -1) {
                pq.push(PQitem{ i,0,arr[0][i].up });
                if(visited[0][i]==0 || visited[0][i] > arr[0][i].up)
                visited[0][i] = arr[0][i].up;
            }
            if (arr[N - 1][i].down != -1) {
                pq.push(PQitem{ i,N - 1,arr[N - 1][i].down });
                if (visited[N - 1][i] == 0 || visited[N - 1][i] > arr[N - 1][i].down)
                visited[N - 1][i] = arr[N-1][i].down;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i][0].left != -1) {
                pq.push(PQitem{ 0,i,arr[i][0].left });
                if (visited[i][0] == 0 || visited[i][0] > arr[i][0].left)
                visited[i][0] = arr[i][0].left;
            }
            if (arr[i][M - 1].right != -1) {
                pq.push(PQitem{ M - 1,i,arr[i][M - 1].right });
                if (visited[i][M-1] == 0 || visited[i][M-1] > arr[i][M-1].right)
                visited[i][M - 1] = arr[i][M-1].right;
            }
        }


        while (!pq.empty()) {
            PQitem curr = pq.top(); pq.pop();
            if (visited[curr.y][curr.x] < curr.height)continue;

            if (curr.y == 0 && curr.x == 1) {
                int degub = 5;
            }

            if (arr[curr.y][curr.x].up != -1) {
                int nextHeight = findNextHeight(curr.x, curr.y - 1);

                //탐색이 필요한 경우
                if (nextHeight == -1) {
                    if (visited[curr.y - 1][curr.x] == 0 || visited[curr.y-1][curr.x] > arr[curr.y][curr.x].up) {
                        visited[curr.y - 1][curr.x] = arr[curr.y][curr.x].up;
                        pq.push(PQitem{ curr.x,curr.y - 1,arr[curr.y][curr.x].up });
                    }
                }
                else {
                    if (nextHeight <= arr[curr.y][curr.x].up) {
                        if (arr[curr.y][curr.x].up < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = arr[curr.y][curr.x].up;
                        }
                    }
                    else {
                        if(nextHeight < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = nextHeight;
                        }
                    }
                }
            }

            if (arr[curr.y][curr.x].down != -1) {
                int nextHeight = findNextHeight(curr.x, curr.y + 1);

                //탐색이 필요한 경우
                if (nextHeight == -1) {
                    if (visited[curr.y + 1][curr.x] == 0 || visited[curr.y + 1][curr.x] > arr[curr.y][curr.x].down) {
                        visited[curr.y + 1][curr.x] = arr[curr.y][curr.x].down;
                        pq.push(PQitem{ curr.x,curr.y + 1,arr[curr.y][curr.x].down });
                    }
                }
                else {
                    if (nextHeight <= arr[curr.y][curr.x].down) {
                        if (arr[curr.y][curr.x].down < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = arr[curr.y][curr.x].down;
                        }
                    }
                    else {
                        if (nextHeight < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = nextHeight;
                        }
                    }
                }
            }


            if (arr[curr.y][curr.x].left != -1) {
                int nextHeight = findNextHeight(curr.x - 1, curr.y);

                //탐색이 필요한 경우
                if (nextHeight == -1) {
                    if (visited[curr.y][curr.x - 1] == 0 || visited[curr.y][curr.x - 1] > arr[curr.y][curr.x].left) {
                        visited[curr.y][curr.x - 1] = arr[curr.y][curr.x].left;
                        pq.push(PQitem{ curr.x - 1,curr.y,arr[curr.y][curr.x].left });
                    }
                }
                else {
                    if (nextHeight <= arr[curr.y][curr.x].left) {
                        if (arr[curr.y][curr.x].left < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = arr[curr.y][curr.x].left;
                        }
                    }
                    else {
                        if (nextHeight < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = nextHeight;
                        }
                    }
                }
            }

            if (arr[curr.y][curr.x].right != -1) {
                int nextHeight = findNextHeight(curr.x + 1, curr.y);

                //탐색이 필요한 경우
                if (nextHeight == -1) {
                    if (visited[curr.y][curr.x + 1] == 0 || visited[curr.y][curr.x + 1] > arr[curr.y][curr.x].right) {
                        visited[curr.y][curr.x + 1] = arr[curr.y][curr.x].right;
                        pq.push(PQitem{ curr.x + 1, curr.y, arr[curr.y][curr.x].right});
                    }
                }
                else {
                    if (nextHeight <= arr[curr.y][curr.x].right) {
                        if (arr[curr.y][curr.x].right < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = arr[curr.y][curr.x].right;
                        }
                    }
                    else {
                        if (nextHeight < arr[curr.y][curr.x].height || arr[curr.y][curr.x].height == -1) {
                            arr[curr.y][curr.x].height = nextHeight;
                        }
                    }
                }
            }
        }
        
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j].height == -1)sum += H;
                else sum += arr[i][j].height;
            }
        }
        cout << sum << "\n";

    }

}
