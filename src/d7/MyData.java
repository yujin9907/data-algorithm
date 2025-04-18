package d7;

import java.util.Objects;

/*
MyArrayList2 사용 예시
 */
public class MyData {

    int num;
    String name;

    public MyData(int n, String s) {
        num = n;
        name = s;
    }

    public String toString() {
        return name+"("+num+")";
    }
    @Override
    public boolean equals(Object that) {
        if (that instanceof MyData d) {
            return (this.num==d.num);
        }
        throw new RuntimeException("왜 다른 걸 넣어?");
    }
}
