package midExam;

public class Code2Review {

    static class ScoreCard {
        int idNum;
        int score1;
        int score2;

        public ScoreCard(int id, int s1, int s2) {
            idNum = id;
            score1 = s1;
            score2 = s2;
        }

        public boolean equals(Object that) {
            return (this.idNum == ((ScoreCard) that).idNum);
        }

        public String toString() {
            return "" + idNum + "[" + score1 + "," + score2 + "]";
        }
    } // 학년 미리 생성

    MyArrayList2<MyArrayList2<ScoreCard>> sList; // 저장할 자료구조 미리 생성

    public Code2Review() {
        sList = new MyArrayList2<>();
        sList.add(new MyArrayList2<ScoreCard>()); // 1학년
        sList.add(new MyArrayList2<ScoreCard>()); // 2학년
        sList.add(new MyArrayList2<ScoreCard>()); // 3학년
        sList.add(new MyArrayList2<ScoreCard>()); // 4학년
    } // 빈 리스트 미리 생성


    //	     Q4 : Complete add method
    // TODO : 감점, 범위 체크 잘못
    public void add(int grade, ScoreCard sc) {   //	add without duplication-filtering
        if (grade>= 1&& grade<= 4) {
            sList.get(grade-1).add(sc);
        }
    }

    public MyArrayList2<ScoreCard> get(int gradeIndex) {
        return sList.get(gradeIndex);
    }

    public ScoreCard get(int gradeIndex, int idNum) {
        return sList.get(gradeIndex).get(idNum);
    }

    //	     Q5 : Complete SortAll(Selection Sort) & swap
    public void sortAll() {  // 학년별로 학번 오름차순으로 정렬
//        for (int i = 0; i < sList.size; i++) {
//            MyArrayList2<ScoreCard> grade = sList.get(i);
//            int n = grade.size;
//
//            for (int j = 0; j < n - 1; j++) {
//                int minIndex = j;
//                for (int k = j + 1; k < n; k++) {
//                    if (grade.get(k).idNum < grade.get(minIndex).idNum) {
//                        minIndex = k;
//                    }
//                }
//                swap(grade, minIndex, j);
//            }
//        }

        for (int grade = 1; grade <=4; grade++) {
            // TODO 모범답안 못 적음
        }
    }

    private void swap(MyArrayList2<ScoreCard> aList, int i, int j) {
        ScoreCard temp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, temp);
    }

    //	     Q6 : Complete Insertion Sort with eliminating Duplication
    /*
    add를 할때 정렬된 위치에 삽입하고, 중복데이터가 있으면 추가를 하지 않는
   addInsertionSortNoDup methods를 완성하시오. => add + insertion sort + 중복제거
     */
    public void addInsertionSortNoDup(int grade, ScoreCard sc) {  // 학번 오름차순 정렬되도록 add, 동일인은 추가안함 (insertion sort)
        MyArrayList2<ScoreCard> data = sList.get(grade - 1);
        int n = data.size;

        int i = 0;
        boolean isDuplicated = false;
        for (; i < n; i++) {
            if (data.get(i).idNum == sc.idNum) {
                isDuplicated = true;
                break;
            }
            if (data.get(i).idNum > sc.idNum) {
                break;
            }
        }
        if (!isDuplicated) {
            data.add(i, sc);
        }
    }

    //	     Q7 : Complete Binary Search
    /*
    학년, 학번을 받아서 binary search로 검색하여 성적을 return하는 search methods를
    완성하시오. (재귀 구조의 binary search 부분만)
     */
    public ScoreCard search(int grade, int id) { // binary search  // 정렬된 상태에서 바이너리 서치
        if (grade >= 1 && grade <= 4) {
            return binarySearch(grade - 1, id, 0, sList.get(grade - 1).size() - 1);
        } else
            return null;
    }

    private ScoreCard binarySearch(int gradeIndex, int id, int p, int r) { // 학년, 학번, 시작, 끝
        MyArrayList2<ScoreCard> grade = sList.get(gradeIndex);

        if (p > r) return null;

        int mid = (p + r) / 2;

        if (id == grade.get(mid).idNum) {
            return grade.get(mid);
        } else if (id < grade.get(mid).idNum) {
            return binarySearch(gradeIndex, id, p, mid - 1);
        } else {
            return binarySearch(gradeIndex, id, mid + 1, r);
        }
    }

    public void clear() {
        for (int i = 0; i < sList.size(); i++)
            sList.get(i).clear();
    }

    public void showList(String s) {
        System.out.println("\n< Score List : " + s + ">");
        for (int i = 0; i < sList.size(); i++) {
            int grade = i + 1;
            System.out.println("Grade" + grade + " : " + sList.get(i).toString());
        }
    }

    public static void main(String[] args) {
        int[][] data = {{2, 2401, 95, 90}, {1, 2501, 75, 91}, {3, 2302, 92, 91}, {2, 2404, 99, 98},
                {4, 2202, 75, 98}, {1, 2503, 56, 77}, {3, 2303, 44, 67}, {1, 2504, 59, 49},
                {2, 2403, 74, 71}, {4, 2203, 86, 79}, {3, 2301, 66, 79}, {1, 2505, 77, 86},
                {2, 2403, 74, 71}, {4, 2203, 86, 79}, {3, 2301, 66, 79}, {1, 2505, 77, 86},
                {1, 2502, 99, 98}, {2, 2402, 97, 73}, {4, 2201, 67, 82}};

        Code2Review list = new Code2Review();

        for (int i = 0; i < data.length; i++) {
            list.add(data[i][0], new ScoreCard(data[i][1], data[i][2], data[i][3]));
        }
        System.out.print("\n<Q4> ");
        list.showList("Unsorted");

        list.sortAll();
        System.out.print("\n<Q5> ");
        list.showList("Sorted with Duplication Data");

        list.clear();

        for (int i = 0; i < data.length; i++) {
            list.addInsertionSortNoDup(data[i][0], new ScoreCard(data[i][1], data[i][2], data[i][3]));
        }
        System.out.print("\n<Q6> ");
        list.showList("Insertion Sort with Eliminating Duplication");

        // 학번 2303, 2504 학생의 성적 조회
        System.out.print("\n<Q7> ");
        System.out.println("\nBinary Search Results : 2303, 2504");
        System.out.println(list.search(3, 2303));
        System.out.println(list.search(1, 2504));

    }
}
