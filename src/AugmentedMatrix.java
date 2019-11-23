public class AugmentedMatrix {
    private MyMatrix lifeHandSide;
    private double[] rightHandSide;

    public AugmentedMatrix(MyMatrix lifeHandSide, double[] rightHandSide) {
        this.lifeHandSide = lifeHandSide;
        this.rightHandSide = rightHandSide;
    }

    public void gaussianElimination() {
        rearrangeRow();

    }

    public void rearrangeRow() {
        double[] firstColumn = lifeHandSide.getColumnVector(0);
        for (int i = 0; i < firstColumn.length; i++) {
            if (firstColumn[i] == 0) {
                for (int j = firstColumn.length - 1; j > i; j--) {
                    if (firstColumn[j] != 0) {
                        swapTwoRow(i, j);
                        break;
                    }
                }
            }
        }
    }

    public void swapTwoRow(int row1, int row2) {
        for (int i = 0; i < lifeHandSide.getColumn(); i++) {
            double temp = lifeHandSide.getEntry(row1, i);
            lifeHandSide.addToEntry(row1, i, lifeHandSide.getEntry(row2, i));
            lifeHandSide.addToEntry(row2, i, temp);
        }
    }

    public void printSystem() {
        lifeHandSide.printMatrix();
    }
}
