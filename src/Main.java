class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        DynamicArray arrDyn = new DynamicArray();
        System.out.println(arrDyn);
        arrDyn.value = new int[]{1, 2, 3, 4};
        arrDyn.addLast(55);
        arrDyn.addFirst(99);
        System.out.println(arrDyn);
        System.out.println(arrDyn.sum());

        int[] result = ArrayUtils.addToPosition(arr, 77, 2);
        System.out.println(ArrayUtils.arrToString(result));

        result = ArrayUtils.delFirst(result);
        result = ArrayUtils.delFromPosition(result, 1);
        System.out.println(ArrayUtils.arrToString(result));

    }
}