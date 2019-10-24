package com.composite.other.algorithm;

public class Search {
    /**
     * 非递归
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param value
     * @return
     */
    public static int binarySearchByNoRecursion(int[] a, int fromIndex, int toIndex, int value) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < value) {
                low = mid + 1;
            } else if (midVal > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param value
     * @return
     */
    public static int binarySearchByRecursion(int[] a, int fromIndex, int toIndex, int value) {
        if (fromIndex > toIndex) {
            return -1;
        }
        int mid = (fromIndex + toIndex) >>> 1;
        if (a[mid] < value) {
            return binarySearchByRecursion(a, mid + 1, toIndex, value);
        } else if (a[mid] > value) {
            return binarySearchByRecursion(a, fromIndex, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * right = n -1 => while(left <= right) => right = middle -1;
     * right = n => while(left < right) => right = middle;
     *
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static int binary_search(int[] array, int n, int value) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            //防止
            int middle = left + ((right - left) >> 1);
            if (array[middle] > value) {
                right = middle - 1;
            } else if (array[middle] < value) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


}
