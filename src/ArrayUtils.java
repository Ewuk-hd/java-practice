public class ArrayUtils {

    public static double arrSum(int... numbers) {
        if(numbers == null){
            return Double.NaN;
        }

        double sum = 0;
        for (int arg : numbers) {
            sum += arg;
        }
        return sum;
    }

    public static int[][] sortRowsBySum(int[][] matrix) {
        int[][] result = matrix.clone();

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (arrSum(result[j]) > arrSum(result[j + 1])) {
                    int[] temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }

    public static String arrToString(int... arr){
        if (arr == null) {
            return "null";
        }

        if (arr.length == 0) {
            return "[]";
        }
        String returnString;
        returnString = "[" + arr[0];
        for(int i = 1; i < arr.length; i++){
            returnString += ", " + arr[i];
        }
        returnString += "]";
        return returnString;

    }

    public static int[] addLast(int []arr, int x){
        if(arr == null){
            return new int[]{x};
        }

        int [] arr1 = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++){
            arr1[i] = arr[i];
        }
        arr1[arr.length] = x;
        return arr1;
    }

    public static int[] addFirst (int []arr, int x){
        if (arr == null){
            return new int[]{x};
        }

        int [] arr1 = new int[arr.length + 1];
        arr1[0] = x;
        for(int i = 1; i<arr.length+1; i++){
            arr1[i] = arr[i-1];
        }
        return arr1;
    }

    public static int[] addToPosition(int[] arr, int x, int pos){
        if (arr == null) {
            if (pos == 0) {
                return new int[]{x};
            }
            throw new IndexOutOfBoundsException("Позиция " + pos + " недопустима для пустого массива (arr == null)");
        }

        if (pos < 0 || pos > arr.length) {
            throw new IndexOutOfBoundsException("Позиция " + pos + " вне диапазона [0, " + arr.length + "]");
        }

        int[] arr1 = new int[arr.length + 1];
        arr1[pos] = x;

        for (int i = 0; i < arr.length + 1; i++) {
            if (i == pos) continue;
            if (i < pos) {
                arr1[i] = arr[i];
            } else if (i > pos) {
                arr1[i] = arr[i - 1];
            }
        }
        return arr1;
    }
}