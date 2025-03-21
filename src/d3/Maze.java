package d3;

// 경로 최대값 찾기
public class Maze{

    int[][] maze;
    int count;
    public Maze(int[][] maze) {
        this.maze = maze;
    }

    // 반복
    public int findMaxIter(int m, int n) {
        int[][] temp=new int[m+1][n+1]; // 합을 저장할 배열
        temp[0][0] = maze[0][0];

        for (int i=1; i<m+1; i++) {
            count++; // 구현 후 성능
            temp[i][0] = temp[i-1][0] + maze[i][0];
        }

        for (int j=1; j<n+1; j++) {
            count++;; // 구현 후 성능
            temp[0][j] = temp[0][j-1] + maze[0][j];
        }

        for (int i=1;i<=m;i++) {
            for (int j=1; j<=n; j++) {
                count++; // 구현 후 성능
                temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]) + maze[i][j];
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
        if (m==0 && n==0) return maze[0][0];
        // 2. 가운데 배열 조건
        if (m==0) return maze[m][n] + findMaxRec(m, n-1); // m, n-1 에 대한 최대값을 더해야 함
        if (n==0) return maze[m][n] + findMaxRec(m-1, n);
        // 3. else
        return maze[m][n]+Math.max(findMaxRec(m, n-1), findMaxRec(m-1, n));
    }

    // 확인용 출력
    public void showMatrix(String name, int[][] m) {
        System.out.println(" Matrix : "+name+"\n");

        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m.length; j++) {
                System.out.printf(m[i][j]+" ");
//                System.out.printf("%5d", m[i][j]); // 포맷
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
        int [][] maze = {
                {1,2,1,5,8,4},
                {4,1,9,4,2,3},
                {8,5,4,3,8,2},
                {1,5,3,5,7,3},
                {4,7,7,9,2,8},
                {2,4,6,3,1,4}
        };

        Maze me = new Maze(maze);
        me.resetCount();
        System.out.println("MaxSum = "+me.findMaxIter(maze.length-1,maze.length-1));
        System.out.println("Count = " + me.getCount());
        me.resetCount();
        System.out.println("MaxSum = "+me.findMaxRec(maze.length-1,maze.length-1));
        System.out.println("Count = " +me.getCount());
    }
}