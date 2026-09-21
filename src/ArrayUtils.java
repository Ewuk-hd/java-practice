/**
 * Библиотека статических методов для работы с массивами целых чисел.
 * <p>
 * Методы не изменяют переданные массивы: при добавлении и удалении элементов
 * всегда создаётся и возвращается новый массив. Вместо исключений при
 * неверных аргументах методы выводят сообщение в консоль.
 */
public class ArrayUtils {

    /**
     * Считает сумму элементов массива.
     *
     * @param numbers элементы, которые нужно сложить (можно передать массив или перечислить через запятую)
     * @return сумма элементов; {@code Double.NaN}, если {@code numbers == null}
     */
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

    /**
     * Сортирует строки матрицы по возрастанию суммы их элементов
     * (пузырьковая сортировка). Исходная матрица не меняется:
     * сортируется её поверхностная копия, сами строки не копируются.
     *
     * @param matrix двумерный массив, строки которого нужно отсортировать
     * @return новая матрица с теми же строками, упорядоченными по возрастанию суммы
     * @see #arrSum(int...)
     */
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

    /**
     * Преобразует массив в строку вида {@code [1, 2, 3]}.
     *
     * @param arr массив для преобразования
     * @return строка с элементами через запятую в квадратных скобках;
     *         {@code "[]"} для пустого массива; {@code "null"}, если {@code arr == null}
     */
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

    /**
     * Добавляет элемент в конец массива.
     *
     * @param arr исходный массив (может быть {@code null})
     * @param x   добавляемое число
     * @return новый массив с элементом {@code x} в конце;
     *         если {@code arr == null}, массив из одного элемента {@code x}
     */
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

    /**
     * Добавляет элемент в начало массива. Остальные элементы сдвигаются вправо.
     *
     * @param arr исходный массив (может быть {@code null})
     * @param x   добавляемое число
     * @return новый массив с элементом {@code x} в начале;
     *         если {@code arr == null}, массив из одного элемента {@code x}
     */
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

    /**
     * Вставляет элемент в указанную позицию. Элементы, начиная с этой позиции,
     * сдвигаются вправо.
     * <p>
     * Допустимые позиции: от 0 до {@code arr.length} включительно
     * (для {@code null} допустима только позиция 0). При недопустимой позиции
     * в консоль выводится сообщение, исключение не выбрасывается.
     *
     * @param arr исходный массив (может быть {@code null})
     * @param x   вставляемое число
     * @param pos позиция вставки
     * @return новый массив со вставленным элементом; при неверной позиции
     *         исходный массив {@code arr} без изменений, а если {@code arr == null}
     *         и {@code pos != 0}, то {@code null}
     */
    public static int[] addToPosition(int[] arr, int x, int pos){
        if (arr == null) {
            if (pos == 0) {
                return new int[]{x};
            }
            System.out.println("Позиция " + pos + " недопустима для null-массива");
            return null;
        }

        if (pos < 0 || pos > arr.length) {
            System.out.println("Позиция " + pos + " вне диапазона [0, " + arr.length + "]");
            return arr;
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

    /**
     * Удаляет последний элемент массива.
     * Если массив {@code null} или пуст, в консоль выводится сообщение.
     *
     * @param arr исходный массив
     * @return новый массив без последнего элемента;
     *         {@code null}, если удалять нечего
     */
    public static int[] delLast(int []arr){
        if (arr == null || arr.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return null;
        }

        int[] arr1 = new int[arr.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    /**
     * Удаляет первый элемент массива. Остальные элементы сдвигаются влево.
     * Если массив {@code null} или пуст, в консоль выводится сообщение.
     *
     * @param arr исходный массив
     * @return новый массив без первого элемента;
     *         {@code null}, если удалять нечего
     */
    public static int[] delFirst(int []arr){
        if (arr == null || arr.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return null;
        }

        int[] arr1 = new int[arr.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i+1];
        }
        return arr1;
    }

    /**
     * Удаляет элемент в указанной позиции. Элементы правее сдвигаются влево.
     * <p>
     * Допустимые позиции: от 0 до {@code arr.length - 1}. Если массив
     * {@code null} или пуст, либо позиция неверна, в консоль выводится
     * сообщение, исключение не выбрасывается.
     *
     * @param arr исходный массив
     * @param pos позиция удаляемого элемента
     * @return новый массив без элемента в позиции {@code pos};
     *         {@code null}, если удаление невозможно
     */
    public static int[] delFromPosition(int[] arr, int pos){
        if (arr == null || arr.length == 0) {
            System.out.println("Массив пуст, удалять нечего");
            return null;
        }
        if (pos < 0 || pos >= arr.length) {
            System.out.println("Позиция " + pos + " вне диапазона [0, " + (arr.length - 1) + "]");
            return null;
        }

        int[] arr1 = new int[arr.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            if (i < pos) {
                arr1[i] = arr[i];
            } else {
                arr1[i] = arr[i + 1];
            }
        }
        return arr1;
    }


}