/**
 * Created by Zell on 12/3/15.
 */
public class MergeArrays {
    public static double[] merge(double[]... arrays)
    {
        // Count the number of arrays passed for merging and the total size of resulting array
        int arrCount = 0;
        int count = 0;
        for (double[] array: arrays)
        {
            arrCount++;
            count += array.length;
        }
        //System.out.println("Arrays passed for merging : "+arrCount);
        //System.out.println("Array size of resultig array : "+count);

        // Create new array and copy all array contents
        double[] mergedArray = new double[count];
        int start = 0;
        for (double[] array: arrays)
        {
            System.arraycopy(array, 0, mergedArray, start, array.length);
            start += array.length;
        }
        return mergedArray;
    }
}
