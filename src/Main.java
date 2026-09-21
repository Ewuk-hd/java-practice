class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4};
        int[] empty = new int[0];
        int[] nothing = null;

        // ArrayUtils
        System.out.println(ArrayUtils.arrSum(arr));
        System.out.println(ArrayUtils.arrSum(nothing));

        System.out.println(ArrayUtils.arrToString(arr));
        System.out.println(ArrayUtils.arrToString(empty));
        System.out.println("\n");

        int[][] matrix1 = {{5, 5}, {1}, {2, 3}};
        int[][] matrix2 = {{9}, {-1, -2}, {0}};
        for (int[] row : ArrayUtils.sortRowsBySum(matrix1)) {
            System.out.println(ArrayUtils.arrToString(row));
        }

        System.out.println("\n");

        for (int[] row : ArrayUtils.sortRowsBySum(matrix2)) {
            System.out.println(ArrayUtils.arrToString(row));
        }

        System.out.println("\n");

        System.out.println(ArrayUtils.arrToString(ArrayUtils.addLast(arr, 9)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.addLast(nothing, 9)));

        System.out.println(ArrayUtils.arrToString(ArrayUtils.addFirst(arr, 0)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.addFirst(nothing, 0)));

        System.out.println(ArrayUtils.arrToString(ArrayUtils.addToPosition(arr, 7, 1)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.addToPosition(arr, 7, 10)));

        System.out.println(ArrayUtils.arrToString(ArrayUtils.delLast(arr)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.delLast(empty)));

        System.out.println(ArrayUtils.arrToString(ArrayUtils.delFirst(arr)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.delFirst(empty)));

        System.out.println(ArrayUtils.arrToString(ArrayUtils.delFromPosition(arr, 1)));
        System.out.println(ArrayUtils.arrToString(ArrayUtils.delFromPosition(arr, 5)));

        System.out.println("\n");

        // DynamicArray
        DynamicArray d = new DynamicArray();
        System.out.println(d);
        System.out.println(d.sum());
        d.value = new int[]{1, 2, 3};
        System.out.println(d);
        System.out.println(d.sum());

        d.addLast(4);
        d.addLast(5);
        System.out.println(d);

        d.addFirst(0);
        d.addFirst(-1);
        System.out.println(d);

        d.addToPosition(100, 2);
        d.addToPosition(100, 50);
        System.out.println(d);

        d.delLast();
        d.delLast();
        System.out.println(d);

        d.delFirst();
        d.delFirst();
        System.out.println(d);

        d.delFromPosition(1);
        d.delFromPosition(50);
        System.out.println(d);

        System.out.println("\n\n");
    }
}