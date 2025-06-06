package d14;

public class CardSelection {

    int[] card;

    public CardSelection(int[] card) {
        this.card = card;
    }

    // 메인에서는 구현의 디테일이 드러나지 않도록 파라미터를 감춘다.
    public int selectNSum() {
        return selectNSum(0, card.length-1);
    }

    private int selectNSum(int i, int j) { // int index, int length
        // base condition check : 값이 두 개 남은 상태
        if (i+1==j) {
            return Math.max(card[i], card[j]);
        }

        // TODO ?
        return Math.max(card[i] + Math.min(selectNSum(i+2, j), selectNSum(i+1, j-1)),
                card[j] + Math.min(selectNSum(i+1, j-1), selectNSum(i, j-2))) ;
    }

    public static void main(String[] args) {
        int[] d = {11, 21, 3, 4, 5, 9, 8, 7, 6, 10}; // 반드시 짝수개
        CardSelection c = new CardSelection(d);
        System.out.println("MaxSum = "+c.selectNSum());
    }
}
