package week3;

public class Day7_SortByParity {
    public int[] sortByParityEfficient(int[] arr) {

        return null;
    }

        public int[] sortByParity(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i=1; i < arr.length; i++) {
            if (arr[i] % 2 != 0) continue;
            int key = arr[i];
            int j = i-1;

            while (j >= 0 && (arr[j]%2 != 0)) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
