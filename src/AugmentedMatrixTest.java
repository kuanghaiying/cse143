public class AugmentedMatrixTest {
    public static void main(String[] args) {
        MyMatrix matrix = new MyMatrix(3, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.addToEntry(i, j, 2);
            }
        }
        matrix.addToEntry(1, 0, 0);
        double[] b = {0, 0, 0};
        AugmentedMatrix system = new AugmentedMatrix(matrix, b);
        system.rearrangeRow();
        system.printSystem();
    }
}
