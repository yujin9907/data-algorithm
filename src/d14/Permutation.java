package d14;

public class Permutation {
    char[] data;

    public Permutation(char[] data) {
        this.data = data;
    }

    public void perm() {
        perm(0);
    }

    private void perm(int depth) {
        // base condition
        if (depth == data.length) {
            System.out.println(data);
            return;
        }

        for(int i=depth; i<data.length; i++) {
            swap(depth, i);
            perm(depth + 1);
            swap(i, depth); // keypoint! 원위치 : 'b'ac, 'c'abd, ... 이런 식으로 시작해야 되기 때문에
        }
    }

    private void swap(int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd', 'e'};
        Permutation p = new Permutation(data);
        p.perm();
    }
}
