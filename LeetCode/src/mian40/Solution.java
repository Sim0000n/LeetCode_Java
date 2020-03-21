package mian40;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if(length == 0)
            return null;
        int[] result = new int[k];
        quickSort(arr, k);
        for(int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
    }

    private void quickSort(int[] arr, int low, int high, int k) {
        if(low >= high)
            return;
        int j = partition(arr, low, high);
        if(j == k)
            return;
        quickSort(arr, low, j - 1, k);
        if(j < k) {
            quickSort(arr, j + 1, high, k);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int i = low, j = high + 1;
        int v = arr[low];
        while (true) {
            while(arr[++i] < v) {
                if(i == high)
                    break;
            }
            while(arr[--j] > v) {
                if(j == low)
                    break;
            }
            if(i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
