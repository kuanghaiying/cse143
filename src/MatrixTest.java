public class MatrixTest {
    public static void main(String[] args) {
        MyMatrix matrix = new MyMatrix(3, 3);
        matrix.printMatrix();

        int value = 0;
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {
                matrix.addToEntry(i, j, value);
                value++;
            }
        }
        System.out.println();
//        matrix.printMatrix();
//
//        matrix = matrix.multiplyBy(matrix);
//        System.out.println();
//        matrix.printMatrix();

        MyMatrix matrix2 = matrix.mulptiplyBy(2);
        matrix2.printMatrix();

        System.out.println();
        matrix.printMatrix();

        MyMatrix addition = matrix.add(matrix2);
        System.out.println();
        addition.printMatrix();
    }
}
