package d10;

public class MyData {

    int num;
    String name;

    MyData(int n, String str) {
        num=n;
        name=str;
    }

    @Override
    public String toString() {
        return name+"("+num+") ";
    }

    public boolean equals(MyData that) {
        return (this.num == that.num);
    }

    @Override
    public boolean equals(Object that) {
        return (this.num == ((MyData) that).num);
    }
}
