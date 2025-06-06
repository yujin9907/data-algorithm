package d14;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public void genCases(int n) {
        String currentStr = "";
        List<String> cases = new ArrayList<>(); // 생겼다 없어졌다 할 게 아니라서 ArrayList 사용
        int open = 0;
        int close = 0;
        genCases(cases, currentStr, open, close, n); // 전체리스트, 현재만들고 있는 거, 시작괄호수, 끝괄호수, 주어진 수 n

        for (String str : cases) {
            System.out.println(str);
        }
    }

    private void genCases(List<String> cases, String currentString, int open, int close, int n) {
        if (currentString.length() == n*2) {
            cases.add(currentString);
            return;
        }

        if (open < n) {
            genCases(cases, currentString+"(", open+1, close, n);
        }
        if (close < open) {
            genCases(cases, currentString+")", open, close+1, n);
        }
    }



    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        for (int n=1; n<5; n++) {
            System.out.println("\n>>>N = "+n);
            p.genCases(n);
        }
    }
}
