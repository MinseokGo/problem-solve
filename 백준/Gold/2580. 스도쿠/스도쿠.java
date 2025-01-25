import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split("\\s");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0);
    }

    private static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j])
                            .append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossibleLocation(row, col, i)) {
                    map[row][col] = i;
                    dfs(row, col + 1);
                    map[row][col] = 0;
                }
            }
        } else {
            dfs(row, col + 1);
        }
    }

    private static boolean isPossibleLocation(int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][col] == number) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
