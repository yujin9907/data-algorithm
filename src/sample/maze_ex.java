package sample;
public class maze_ex {
//경로찾기
//	public void showPath(int[][] maxSumTable) {
//	    int m = maxSumTable.length - 1;
//	    int n = maxSumTable[0].length - 1;
//
//	    // 결과 경로를 저장할 리스트
//	    List<int[]> path = new ArrayList<>();
//
//	    // 마지막 위치부터 시작해서 경로를 역추적
//	    int i = m, j = n;
//	    path.add(new int[]{i, j});
//
//	    while (i > 0 || j > 0) {
//	        // 왼쪽에서 온 경우
//	        if (i == 0) {
//	            j--;
//	        }
//	        // 위에서 온 경우
//	        else if (j == 0) {
//	            i--;
//	        }
//	        // 왼쪽과 위 중에서 더 큰 값을 가진 쪽에서 왔을 것임
//	        else {
//	            if (maxSumTable[i-1][j] > maxSumTable[i][j-1]) {
//	                i--;
//	            } else {
//	                j--;
//	            }
//	        }
//	        path.add(new int[]{i, j});
//	    }
//
//	    // 경로를 시작점부터 끝점까지 순서대로 출력하기 위해 역순으로 변환
//	    Collections.reverse(path);
//
//	    // 경로 출력
//	    System.out.println("[경로 출력 결과 (예시)]");
//	    System.out.print("Start ");
//	    for (int[] point : path) {
//	        System.out.print("[" + point[0] + "," + point[1] + "] => ");
//	    }
//	    System.out.println("End");
//	}

	
//최소합 찾기
//	public int findMinIter(int m, int n) {
//	    int[][] temp = new int[m+1][n+1];
//
//	    // 시작점 초기화
//	    temp[0][0] = maze[0][0];
//
//	    // 첫 번째 행 초기화
//	    for (int i = 1; i <= m; i++) {
//	        count++;
//	        temp[i][0] = temp[i-1][0] + maze[i][0];
//	    }
//
//	    // 첫 번째 열 초기화
//	    for (int j = 1; j <= n; j++) {
//	        count++;
//	        temp[0][j] = temp[0][j-1] + maze[0][j];
//	    }
//
//	    // 나머지 셀 채우기 - 최소값 선택
//	    for (int i = 1; i <= m; i++) {
//	        for (int j = 1; j <= n; j++) {
//	            count++;
//	            temp[i][j] = Math.min(temp[i-1][j], temp[i][j-1]) + maze[i][j];
//	        }
//	    }
//
//	    // 결과 표시
//	    showMatrix("Minimum Sum Path", temp);
//	    return temp[m][n];
//	}
//
//	// 최소 합 경로를 추적하는 메소드
//	public void showMinPath(int[][] minSumTable) {
//	    int m = minSumTable.length - 1;
//	    int n = minSumTable[0].length - 1;
//
//	    // 결과 경로를 저장할 리스트
//	    List<int[]> path = new ArrayList<>();
//
//	    // 마지막 위치부터 시작해서 경로를 역추적
//	    int i = m, j = n;
//	    path.add(new int[]{i, j});
//
//	    while (i > 0 || j > 0) {
//	        // 왼쪽에서 온 경우
//	        if (i == 0) {
//	            j--;
//	        }
//	        // 위에서 온 경우
//	        else if (j == 0) {
//	            i--;
//	        }
//	        // 왼쪽과 위 중에서 더 작은 값을 가진 쪽에서 왔을 것임
//	        else {
//	            if (minSumTable[i-1][j] < minSumTable[i][j-1]) {
//	                i--;
//	            } else {
//	                j--;
//	            }
//	        }
//	        path.add(new int[]{i, j});
//	    }
//
//	    // 경로를 시작점부터 끝점까지 순서대로 출력하기 위해 역순으로 변환
//	    Collections.reverse(path);
//
//	    // 경로 출력
//	    System.out.println("[최소 합 경로 출력 결과]");
//	    System.out.print("Start ");
//	    for (int[] point : path) {
//	        System.out.print("[" + point[0] + "," + point[1] + "] => ");
//	    }
//	    System.out.println("End");
//	}
//
//	// 재귀를 사용한 최소 합 경로 찾기
//	public int findMinRec(int m, int n) {
//	    count++;
//	    if (m == 0 && n == 0) {
//	        return maze[0][0];
//	    }
//	    if (m == 0) {
//	        return maze[m][n] + findMinRec(m, n-1);
//	    }
//	    if (n == 0) {
//	        return maze[m][n] + findMinRec(m-1, n);
//	    }
//	    else {
//	        return maze[m][n] + Math.min(findMinRec(m, n-1), findMinRec(m-1, n));
//	    }
//	}
//
//	// 메모이제이션을 사용한 재귀 최소 합 경로 찾기
//	public int findMinRecMemo(int m, int n) {
//	    count++;
//
//	    if (m == 0 && n == 0) {
//	        memo[m][n] = maze[0][0];
//	        return memo[0][0];
//	    }
//	    if (m == 0) {
//	        if (memo[m][n] == -1) {
//	            memo[m][n] = maze[m][n] + findMinRecMemo(m, n-1);
//	        }
//	        return memo[m][n];
//	    }
//	    if (n == 0) {
//	        if (memo[m][n] == -1) {
//	            memo[m][n] = maze[m][n] + findMinRecMemo(m-1, n);
//	        }
//	        return memo[m][n];
//	    }
//	    else {
//	        if (memo[m][n] == -1) {
//	            memo[m][n] = maze[m][n] + Math.min(findMinRecMemo(m-1, n), findMinRecMemo(m, n-1));
//	        }
//	        return memo[m][n];
//	    }
//	}
	//최소합 찾기 메인
//	public static void main(String[] args) {
//	    int [][] maze = {
//	        {1, 2, 1, 5, 8, 4},
//	        {4, 1, 9, 4, 2, 3},
//	        {8, 5, 4, 3, 8, 2},
//	        {1, 5, 3, 5, 7, 3},
//	        {4, 7, 7, 9, 2, 8},
//	        {2, 4, 6, 3, 1, 4}
//	    };
//
//	    Maze me = new Maze(maze);
//	    me.resetCount();
//
//	    // 최소 합 경로 - 반복문
//	    int minSum = me.findMinIter(maze.length-1, maze.length-1);
//	    System.out.println("MinSum = " + minSum + " count result = " + me.getCount());
//	    me.showMinPath(me.memo); // 최소 합 경로 출력
//
//	    // 메모 배열 초기화
//	    me.resetMemo();
//	    me.resetCount();
//
//	    // 최소 합 경로 - 순수 재귀
//	    System.out.println("MinSum = " + me.findMinRec(maze.length-1, maze.length-1)
//	            + " count result = " + me.getCount());
//
//	    // 메모 배열 초기화
//	    me.resetMemo();
//	    me.resetCount();
//
//	    // 최소 합 경로 - 메모이제이션 재귀
//	    System.out.println("MinSum = " + me.findMinRecMemo(maze.length-1, maze.length-1)
//	            + " count result = " + me.getCount());
//	}
//
//	// memo 배열 초기화 메소드
//	public void resetMemo() {
//	    for (int i = 0; i < memo.length; i++) {
//	        for (int j = 0; j < memo[0].length; j++) {
//	            memo[i][j] = -1;
//	        }
//	    }
//	}
	
	//대각선 이동 허용
//	public int findMaxWithDiagonalIter(int m, int n) {
//	    int[][] temp = new int[m+1][n+1];
//
//	    // 시작점 초기화
//	    temp[0][0] = maze[0][0];
//
//	    // 첫 번째 행 초기화
//	    for (int i = 1; i <= m; i++) {
//	        count++;
//	        temp[i][0] = temp[i-1][0] + maze[i][0];
//	    }
//
//	    // 첫 번째 열 초기화
//	    for (int j = 1; j <= n; j++) {
//	        count++;
//	        temp[0][j] = temp[0][j-1] + maze[0][j];
//	    }
//
//	    // 나머지 셀 채우기 - 위, 왼쪽, 대각선 중 최대값 선택
//	    for (int i = 1; i <= m; i++) {
//	        for (int j = 1; j <= n; j++) {
//	            count++;
//	            // 위, 왼쪽, 대각선 방향에서의 값 중 최대값 선택
//	            int fromTop = temp[i-1][j];
//	            int fromLeft = temp[i][j-1];
//	            int fromDiagonal = temp[i-1][j-1];
//
//	            temp[i][j] = Math.max(Math.max(fromTop, fromLeft), fromDiagonal) + maze[i][j];
//	        }
//	    }
//
//	    // 결과 표시
//	    showMatrix("Maximum Sum Path with Diagonal", temp);
//	    return temp[m][n];
//	}
//
//	// 대각선 이동을 포함한 경로 추적
//	public void showPathWithDiagonal(int[][] maxSumTable) {
//	    int m = maxSumTable.length - 1;
//	    int n = maxSumTable[0].length - 1;
//
//	    // 결과 경로를 저장할 리스트
//	    List<int[]> path = new ArrayList<>();
//
//	    // 마지막 위치부터 시작해서 경로를 역추적
//	    int i = m, j = n;
//	    path.add(new int[]{i, j});
//
//	    while (i > 0 || j > 0) {
//	        // 모서리 케이스 처리
//	        if (i == 0) {
//	            j--;
//	        }
//	        else if (j == 0) {
//	            i--;
//	        }
//	        // 일반 케이스: 위, 왼쪽, 대각선 중 최대값 방향 선택
//	        else {
//	            int fromTop = maxSumTable[i-1][j];
//	            int fromLeft = maxSumTable[i][j-1];
//	            int fromDiagonal = maxSumTable[i-1][j-1];
//
//	            // 최대값 방향으로 이동
//	            if (fromDiagonal >= fromTop && fromDiagonal >= fromLeft) {
//	                i--;
//	                j--;
//	            } else if (fromTop >= fromLeft) {
//	                i--;
//	            } else {
//	                j--;
//	            }
//	        }
//	        path.add(new int[]{i, j});
//	    }
//
//	    // 경로를 시작점부터 끝점까지 순서대로 출력하기 위해 역순으로 변환
//	    Collections.reverse(path);
//
//	    // 경로 출력
//	    System.out.println("[대각선 이동 포함 경로 출력 결과]");
//	    System.out.print("Start ");
//	    for (int[] point : path) {
//	        System.out.print("[" + point[0] + "," + point[1] + "] => ");
//	    }
//	    System.out.println("End");
//	}
//
//	// 재귀를 사용한 대각선 이동 포함 최대 합 경로 찾기
//	public int findMaxWithDiagonalRec(int m, int n) {
//	    count++;
//	    if (m == 0 && n == 0) {
//	        return maze[0][0];
//	    }
//	    if (m == 0) {
//	        return maze[m][n] + findMaxWithDiagonalRec(m, n-1);
//	    }
//	    if (n == 0) {
//	        return maze[m][n] + findMaxWithDiagonalRec(m-1, n);
//	    }
//	    else {
//	        int fromTop = findMaxWithDiagonalRec(m-1, n);
//	        int fromLeft = findMaxWithDiagonalRec(m, n-1);
//	        int fromDiagonal = findMaxWithDiagonalRec(m-1, n-1);
//
//	        return maze[m][n] + Math.max(Math.max(fromTop, fromLeft), fromDiagonal);
//	    }
//	}
//
//	// 메모이제이션을 사용한 재귀 대각선 이동 포함 최대 합 경로 찾기
//	public int findMaxWithDiagonalRecMemo(int m, int n) {
//	    count++;
//
//	    if (m == 0 && n == 0) {
//	        memo[m][n] = maze[0][0];
//	        return memo[0][0];
//	    }
//	    if (m == 0) {
//	        if (memo[m][n] == -1) {
//	            memo[m][n] = maze[m][n] + findMaxWithDiagonalRecMemo(m, n-1);
//	        }
//	        return memo[m][n];
//	    }
//	    if (n == 0) {
//	        if (memo[m][n] == -1) {
//	            memo[m][n] = maze[m][n] + findMaxWithDiagonalRecMemo(m-1, n);
//	        }
//	        return memo[m][n];
//	    }
//	    else {
//	        if (memo[m][n] == -1) {
//	            int fromTop = findMaxWithDiagonalRecMemo(m-1, n);
//	            int fromLeft = findMaxWithDiagonalRecMemo(m, n-1);
//	            int fromDiagonal = findMaxWithDiagonalRecMemo(m-1, n-1);
//
//	            memo[m][n] = maze[m][n] + Math.max(Math.max(fromTop, fromLeft), fromDiagonal);
//	        }
//	        return memo[m][n];
//	    }
//	}
	//대각선 이동 메인
	
//	public static void main(String[] args) {
//	    int [][] maze = {
//	        {1, 2, 1, 5, 8, 4},
//	        {4, 1, 9, 4, 2, 3},
//	        {8, 5, 4, 3, 8, 2},
//	        {1, 5, 3, 5, 7, 3},
//	        {4, 7, 7, 9, 2, 8},
//	        {2, 4, 6, 3, 1, 4}
//	    };
//
//	    Maze me = new Maze(maze);
//	    me.resetCount();
//
//	    // 대각선 이동 포함 최대 합 경로 - 반복문
//	    int maxSumWithDiagonal = me.findMaxWithDiagonalIter(maze.length-1, maze.length-1);
//	    System.out.println("MaxSum with Diagonal = " + maxSumWithDiagonal + " count result = " + me.getCount());
//	    me.showPathWithDiagonal(me.memo); // 대각선 이동 포함 경로 출력
//
//	    // 메모 배열 초기화
//	    me.resetMemo();
//	    me.resetCount();
//
//	    // 대각선 이동 포함 최대 합 경로 - 순수 재귀
//	    System.out.println("MaxSum with Diagonal = " + me.findMaxWithDiagonalRec(maze.length-1, maze.length-1)
//	            + " count result = " + me.getCount());
//
//	    // 메모 배열 초기화
//	    me.resetMemo();
//	    me.resetCount();
//
//	    // 대각선 이동 포함 최대 합 경로 - 메모이제이션 재귀
//	    System.out.println("MaxSum with Diagonal = " + me.findMaxWithDiagonalRecMemo(maze.length-1, maze.length-1)
//	            + " count result = " + me.getCount());
//	}
	
	//장애물이있는 경우
//	public class MazeWithObstacles {
//	    int[][] maze;
//	    int[][] memo;
//	    int count;
//	    final int OBSTACLE = -999; // 장애물을 나타내는 특수 값
//
//	    public MazeWithObstacles(int[][] input, boolean[][] obstacles) {
//	        this.maze = new int[input.length][input[0].length];
//
//	        // 입력 행렬 복사 및 장애물 표시
//	        for (int i = 0; i < input.length; i++) {
//	            for (int j = 0; j < input[0].length; j++) {
//	                if (obstacles[i][j]) {
//	                    this.maze[i][j] = OBSTACLE; // 장애물 위치 표시
//	                } else {
//	                    this.maze[i][j] = input[i][j];
//	                }
//	            }
//	        }
//
//	        memo = new int[maze.length][maze[0].length];
//	        resetMemo();
//	    }
//
//	    public void resetMemo() {
//	        for (int i = 0; i < memo.length; i++) {
//	            for (int j = 0; j < memo[0].length; j++) {
//	                memo[i][j] = -1;
//	            }
//	        }
//	    }
//
//	    public void resetCount() {
//	        count = 0;
//	    }
//
//	    public int getCount() {
//	        return count;
//	    }
//
//	    // 장애물이 있는 행렬에서 최대 합 경로 찾기 (반복적 방법)
//	    public int findMaxWithObstaclesIter(int m, int n) {
//	        int[][] temp = new int[m+1][n+1];
//
//	        // 특수 초기화: 모든 셀을 '도달 불가능' 값으로 설정
//	        for (int i = 0; i <= m; i++) {
//	            for (int j = 0; j <= n; j++) {
//	                temp[i][j] = Integer.MIN_VALUE;
//	            }
//	        }
//
//	        // 시작점이 장애물인 경우 처리
//	        if (maze[0][0] == OBSTACLE) {
//	            return Integer.MIN_VALUE; // 시작점이 장애물이면 경로 없음
//	        }
//
//	        temp[0][0] = maze[0][0];
//
//	        // 첫 번째 행 초기화 (장애물 고려)
//	        for (int i = 1; i <= m; i++) {
//	            count++;
//	            if (maze[i][0] != OBSTACLE && temp[i-1][0] != Integer.MIN_VALUE) {
//	                temp[i][0] = temp[i-1][0] + maze[i][0];
//	            }
//	        }
//
//	        // 첫 번째 열 초기화 (장애물 고려)
//	        for (int j = 1; j <= n; j++) {
//	            count++;
//	            if (maze[0][j] != OBSTACLE && temp[0][j-1] != Integer.MIN_VALUE) {
//	                temp[0][j] = temp[0][j-1] + maze[0][j];
//	            }
//	        }
//
//	        // 나머지 셀 채우기
//	        for (int i = 1; i <= m; i++) {
//	            for (int j = 1; j <= n; j++) {
//	                count++;
//	                if (maze[i][j] != OBSTACLE) {
//	                    int fromTop = temp[i-1][j];
//	                    int fromLeft = temp[i][j-1];
//
//	                    // 양쪽 모두 도달 불가능인 경우
//	                    if (fromTop == Integer.MIN_VALUE && fromLeft == Integer.MIN_VALUE) {
//	                        temp[i][j] = Integer.MIN_VALUE;
//	                    }
//	                    // 최대값 계산
//	                    else {
//	                        if (fromTop == Integer.MIN_VALUE) {
//	                            temp[i][j] = fromLeft + maze[i][j];
//	                        } else if (fromLeft == Integer.MIN_VALUE) {
//	                            temp[i][j] = fromTop + maze[i][j];
//	                        } else {
//	                            temp[i][j] = Math.max(fromTop, fromLeft) + maze[i][j];
//	                        }
//	                    }
//	                }
//	            }
//	        }
//
//	        // 결과 표시
//	        showMatrix("Maximum Sum Path with Obstacles", temp);
//
//	        // 목적지에 도달할 수 없으면 특수 값 반환
//	        if (temp[m][n] == Integer.MIN_VALUE) {
//	            System.out.println("장애물로 인해 목적지에 도달할 수 없습니다.");
//	            return Integer.MIN_VALUE;
//	        }
//
//	        return temp[m][n];
//	    }
//
//	    // 장애물이 있는 경로 추적
//	    public void showPathWithObstacles(int[][] maxSumTable) {
//	        int m = maxSumTable.length - 1;
//	        int n = maxSumTable[0].length - 1;
//
//	        // 목적지에 도달할 수 없는 경우
//	        if (maxSumTable[m][n] == Integer.MIN_VALUE) {
//	            System.out.println("장애물로 인해 경로가 존재하지 않습니다.");
//	            return;
//	        }
//
//	        // 결과 경로를 저장할 리스트
//	        List<int[]> path = new ArrayList<>();
//
//	        // 마지막 위치부터 시작해서 경로를 역추적
//	        int i = m, j = n;
//	        path.add(new int[]{i, j});
//
//	        while (i > 0 || j > 0) {
//	            // 왼쪽에서만 올 수 있는 경우
//	            if (i == 0) {
//	                j--;
//	            }
//	            // 위에서만 올 수 있는 경우
//	            else if (j == 0) {
//	                i--;
//	            }
//	            // 둘 다 가능한 경우
//	            else {
//	                int fromTop = maxSumTable[i-1][j];
//	                int fromLeft = maxSumTable[i][j-1];
//
//	                // 둘 중 도달 가능하고 더 큰 값을 선택
//	                if (fromTop == Integer.MIN_VALUE || (fromLeft != Integer.MIN_VALUE && fromLeft > fromTop)) {
//	                    j--;
//	                } else {
//	                    i--;
//	                }
//	            }
//
//	            path.add(new int[]{i, j});
//	        }
//
//	        // 경로를 시작점부터 끝점까지 순서대로 출력하기 위해 역순으로 변환
//	        Collections.reverse(path);
//
//	        // 경로 출력
//	        System.out.println("[장애물이 있는 경로 출력 결과]");
//	        System.out.print("Start ");
//	        for (int[] point : path) {
//	            System.out.print("[" + point[0] + "," + point[1] + "] => ");
//	        }
//	        System.out.println("End");
//	    }
//
//	    // 재귀를 사용한 장애물이 있는 최대 합 경로 찾기
//	    public int findMaxWithObstaclesRec(int m, int n) {
//	        count++;
//
//	        // 범위를 벗어나거나 장애물인 경우
//	        if (m < 0 || n < 0 || maze[m][n] == OBSTACLE) {
//	            return Integer.MIN_VALUE;
//	        }
//
//	        // 시작점에 도달한 경우
//	        if (m == 0 && n == 0) {
//	            return maze[0][0];
//	        }
//
//	        // 위쪽과 왼쪽에서 오는 경로 계산
//	        int fromTop = findMaxWithObstaclesRec(m-1, n);
//	        int fromLeft = findMaxWithObstaclesRec(m, n-1);
//
//	        // 둘 다 도달 불가능한 경우
//	        if (fromTop == Integer.MIN_VALUE && fromLeft == Integer.MIN_VALUE) {
//	            return Integer.MIN_VALUE;
//	        }
//
//	        // 최대값 계산
//	        if (fromTop == Integer.MIN_VALUE) {
//	            return fromLeft + maze[m][n];
//	        } else if (fromLeft == Integer.MIN_VALUE) {
//	            return fromTop + maze[m][n];
//	        } else {
//	            return Math.max(fromTop, fromLeft) + maze[m][n];
//	        }
//	    }
//
//	    // 메모이제이션을 사용한 재귀 장애물이 있는 최대 합 경로 찾기
//	    public int findMaxWithObstaclesRecMemo(int m, int n) {
//	        count++;
//
//	        // 범위를 벗어나거나 장애물인 경우
//	        if (m < 0 || n < 0 || maze[m][n] == OBSTACLE) {
//	            return Integer.MIN_VALUE;
//	        }
//
//	        // 이미 계산된 값이 있는 경우
//	        if (memo[m][n] != -1) {
//	            return memo[m][n];
//	        }
//
//	        // 시작점에 도달한 경우
//	        if (m == 0 && n == 0) {
//	            memo[m][n] = maze[0][0];
//	            return memo[m][n];
//	        }
//
//	        // 위쪽과 왼쪽에서 오는 경로 계산
//	        int fromTop = findMaxWithObstaclesRecMemo(m-1, n);
//	        int fromLeft = findMaxWithObstaclesRecMemo(m, n-1);
//
//	        // 둘 다 도달 불가능한 경우
//	        if (fromTop == Integer.MIN_VALUE && fromLeft == Integer.MIN_VALUE) {
//	            memo[m][n] = Integer.MIN_VALUE;
//	            return memo[m][n];
//	        }
//
//	        // 최대값 계산
//	        if (fromTop == Integer.MIN_VALUE) {
//	            memo[m][n] = fromLeft + maze[m][n];
//	        } else if (fromLeft == Integer.MIN_VALUE) {
//	            memo[m][n] = fromTop + maze[m][n];
//	        } else {
//	            memo[m][n] = Math.max(fromTop, fromLeft) + maze[m][n];
//	        }
//
//	        return memo[m][n];
//	    }
//
//	    public void showMatrix(String name, int[][] m) {
//	        System.out.println("< Matrix: " + name + " >");
//
//	        for (int i = 0; i < m.length; i++) {
//	            for (int j = 0; j < m[0].length; j++) {
//	                if (m[i][j] == Integer.MIN_VALUE) {
//	                    System.out.printf("%5s", "X"); // 도달 불가능한 위치
//	                } else {
//	                    System.out.printf("%5d", m[i][j]);
//	                }
//	            }
//	            System.out.println();
//	        }
//	    }
//
//	    public static void main(String[] args) {
//	        int[][] maze = {
//	            {1, 2, 1, 5, 8, 4},
//	            {4, 1, 9, 4, 2, 3},
//	            {8, 5, 4, 3, 8, 2},
//	            {1, 5, 3, 5, 7, 3},
//	            {4, 7, 7, 9, 2, 8},
//	            {2, 4, 6, 3, 1, 4}
//	        };
//
//	        // 장애물 위치 설정 (true는 장애물이 있는 위치)
//	        boolean[][] obstacles = new boolean[maze.length][maze[0].length];
//	        obstacles[1][2] = true; // 예: (1,2) 위치에 장애물
//	        obstacles[2][3] = true; // 예: (2,3) 위치에 장애물
//	        obstacles[3][1] = true; // 예: (3,1) 위치에 장애물
//
//	        MazeWithObstacles me = new MazeWithObstacles(maze, obstacles);
//	        me.resetCount();
//
//	        // 장애물이 있는 최대 합 경로 - 반복문
//	        int maxSumWithObstacles = me.findMaxWithObstaclesIter(maze.length-1, maze[0].length-1);
//	        if (maxSumWithObstacles != Integer.MIN_VALUE) {
//	            System.out.println("MaxSum with Obstacles = " + maxSumWithObstacles + " count result = " + me.getCount());
//	            me.showPathWithObstacles(me.memo); // 장애물이 있는 경로 출력
//	        }
//
//	        // 메모 배열 초기화
//	        me.resetMemo();
//	        me.resetCount();
//
//	        // 장애물이 있는 최대 합 경로 - 순수 재귀
//	        int recResult = me.findMaxWithObstaclesRec(maze.length-1, maze[0].length-1);
//	        if (recResult != Integer.MIN_VALUE) {
//	            System.out.println("MaxSum with Obstacles (Rec) = " + recResult + " count result = " + me.getCount());
//	        } else {
//	            System.out.println("장애물로 인해 목적지에 도달할 수 없습니다 (재귀).");
//	        }
//
//	        // 메모 배열 초기화
//	        me.resetMemo();
//	        me.resetCount();
//
//	        // 장애물이 있는 최대 합 경로 - 메모이제이션 재귀
//	        int memoResult = me.findMaxWithObstaclesRecMemo(maze.length-1, maze[0].length-1);
//	        if (memoResult != Integer.MIN_VALUE) {
//	            System.out.println("MaxSum with Obstacles (RecMemo) = " + memoResult + " count result = " + me.getCount());
//	        } else {
//	            System.out.println("장애물로 인해 목적지에 도달할 수 없습니다 (메모이제이션).");
//	        }
//	    }
//	}
}
