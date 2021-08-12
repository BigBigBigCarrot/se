package pers.david.se.utils;

@Deprecated
/**
 *
 * @Description
 *    学习和演示用
 * 	需要使用时，用自带的或者Collections和Arrays的排序和查找即可
 * @author Bu Dawei
 * @date 2020年1月21日
 * @version
 */
public class Searcher {

    /**
     * @param a
     * @param key
     * @return 成功时返回关键字所在的下标，失败时返回-1
     */
    public static int search1(int a[], int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param a   ：a[0]要保留用于设置哨兵
     * @param key
     * @return 成功时返回关键字所在的下标，失败时返回0
     */
    public static int search2(int a[], int key) {
        int i = a.length - 1;
        a[0] = key;
        while (a[i] != key) {
            i--;
        }
        return i;
    }

    /**
     * 折半查找
     *
     * @param a ：a必须满足是递增的
     * @return 成功时返回关键字所在的下标，失败时返回-1
     */
    public static int binarySearch(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 3, 6, 10};
        System.out.println(search1(a, 6));

        int b[] = {0, 5, 3, 6, 10};
        System.out.println(search2(b, 6));

        int c[] = {2, 4, 6, 8, 10};
        System.out.println(binarySearch(c, 6));
    }

}
