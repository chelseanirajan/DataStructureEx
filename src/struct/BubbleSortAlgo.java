package struct;

import java.util.Arrays;

public class BubbleSortAlgo {
    public static void main(String[] args) {
        int[] numb = new int[]{5,2,9,15, 20,1, 13};

        int[] sortedNumb = bubbleSort(numb);
        System.out.println(Arrays.toString(sortedNumb));
    }
    private static int[] bubbleSort(int[] numb){
        for(int j=0;j<numb.length; j++) {
            for (int i = 0; i < numb.length - 1; i++) {
                if (numb[i] > numb[i + 1]) {
                    int temp = numb[i];
                    numb[i] = numb[i + 1];
                    numb[i + 1] = temp;
                }
            }
        }
        return numb;
    }
}
