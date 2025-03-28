package d4;

public class MySort {


    public static void main(String[] args) {
        int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
                170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
                50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
                301,  62,  152,  219,  294};

        System.out.println("\n< Initial Data >");
        showData(data);

// deep copy data to another array, dataSorted, for argument...
// call each sort method
// showData(dataSorted)
//
//		MySort ms = new MySort();
//		int [] dataSorted = new int[data.length];
//
//		System.out.println("\n< ---- Sort >");
//		dataSorted=data.clone();
//		ms.----Sort(dataSorted);
//		showData(dataSorted);

    }

    private static void showData(int[] data) {
        int nData = data.length;
        int nPrinted=0;
        while(nPrinted<nData) {
            for (int i=0;(nPrinted<nData)&&(i<10); i++) {
                System.out.printf("%6d ",data[nPrinted++]);
            }
            System.out.println();
        }
    }

}
