package base.algo;

/**
 * Created by hchang on 6/15/16.
 */
public class RadixSort {
    public static void sort( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];

            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,5,123,321,34,231,431412,23};
        RadixSort.sort(array);
        for (int i : array)
            System.out.println(i);
    }
}
