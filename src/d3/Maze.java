package d3;

// 경로 최대값 찾기
public class Maze {

    int[][] maze;
    int count;
    int[][] memo; // 재귀 성능 향상

    public Maze(int[][] maze) {
        this.maze = maze;
        // 메모 초기화
        this.memo = new int[maze.length][maze.length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                memo[i][j] = -1; // 변동 구분을 위한 초기화
            }
        }
    }

    // 반복
    public int findMaxIter(int m, int n) {
        int[][] temp = new int[m + 1][n + 1]; // 합을 저장할 배열
        temp[0][0] = maze[0][0];

        for (int i = 1; i < m + 1; i++) {
            count++; // 구현 후 성능
            temp[i][0] = temp[i - 1][0] + maze[i][0];
        }

        for (int j = 1; j < n + 1; j++) {
            count++; // 구현 후 성능
            temp[0][j] = temp[0][j - 1] + maze[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                count++; // 구현 후 성능
                temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]) + maze[i][j];
            }
        }

        showMatrix("반복", temp);

        return temp[m][n];
    }

    // 재귀 : 위와 비교했을 때, 코드 및 의미 전달이 빠름
    public int findMaxRec(int m, int n) {
        // 구현 후 성능
        count++;
        // 1. base condition 찾기
        if (m == 0 && n == 0) return maze[0][0];
        // 2. 가운데 배열 조건
        if (m == 0) return maze[m][n] + findMaxRec(m, n - 1); // m, n-1 에 대한 최대값을 더해야 함
        if (n == 0) return maze[m][n] + findMaxRec(m - 1, n);
        // 3. else
        return maze[m][n] + Math.max(findMaxRec(m, n - 1), findMaxRec(m - 1, n));
    }

    // 재귀 성능 향상 (메모에 계산이 안 된 경우만 재귀 호출)
    // count = 61
    public int findMaxRecMemo(int m, int n) {
        count++;

        if (m == 0 && n == 0) {
            memo[m][n] = maze[0][0];
            return memo[0][0];
        }

        if (m == 0) {
            if (memo[m][n] == -1) {
                memo[m][n] = maze[m][n] + findMaxRecMemo(m, n - 1);
            }
            return memo[m][n];
        }

        if (n == 0) {
            if (memo[m][n] == -1) {
                memo[m][n] = maze[m][n] + findMaxRecMemo(m - 1, n);
            }
            return memo[m][n];
        }

        if (memo[m][n] == -1) {
            memo[m][n] =  maze[m][n] + Math.max(findMaxRecMemo(m, n - 1), findMaxRecMemo(m - 1, n));
            return memo[m][n];
        }

        return memo[m][n];
    }

    // 확인용 출력
    public void showMatrix(String name, int[][] m) {
        System.out.println(" Matrix : " + name + "\n");

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.printf("%5d", m[i][j]); // 포맷
            }
            System.out.println("\n");
        }
    }

    // (구현완료 후 성능 검증) 카운트 초기화
    public void resetCount() {
        count = 0;
    }

    // (구현완료 후 성능 검증) 카운트 게터
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 2, 1, 5, 8, 4},
                {4, 1, 9, 4, 2, 3},
                {8, 5, 4, 3, 8, 2},
                {1, 5, 3, 5, 7, 3},
                {4, 7, 7, 9, 2, 8},
                {2, 4, 6, 3, 1, 4}
        };

        Maze me = new Maze(maze);
        // 반복
        me.resetCount();
        System.out.println("MaxSum = " + me.findMaxIter(maze.length - 1, maze.length - 1));
        System.out.println("Count = " + me.getCount());
        // 재귀
        me.resetCount();
        System.out.println("MaxSum = " + me.findMaxRec(maze.length - 1, maze.length - 1));
        System.out.println("Count = " + me.getCount());
        // 재귀+메모 : 성능을 고려하여 다이나믹
        me.resetCount();
        System.out.println("MaxSum = " + me.findMaxRecMemo(maze.length - 1, maze.length - 1));
        System.out.println("Count = " + me.getCount());

    }
}