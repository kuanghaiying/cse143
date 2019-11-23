public class MyMatrix {
    public static final int ORIGINAL_COLUMN_SPACING = 5;
    public static final int ORIGINAL_ROW_SPACING = 2;
    private int columnSpacing;
    private int rowSpacing;
    private double[][] matrix;
    private int row;
    private int column;

    public MyMatrix(int row, int column) {
        matrix = new double[row][column];
        this.row = row;
        this.column = column;
        columnSpacing = ORIGINAL_COLUMN_SPACING;
        rowSpacing = ORIGINAL_ROW_SPACING;
    }

    public void addToEntry(int row, int column, double value) {
        matrix[row][column] = value;
    }

    public double getEntry(int row, int column) {
        return matrix[row][column];
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int space = columnSpacing - getDigitNum(matrix[i][j]);
                System.out.print(matrix[i][j]);
                for (int k = 0; k < space; k++) {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < rowSpacing; j++) {
                System.out.println();
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public double[] getColumnVector(int column) {
        return matrix[column];
    }

    public MyMatrix multiplyBy(MyMatrix other) {
        if (this.column != other.row) {
            throw new IllegalArgumentException();
        }
        MyMatrix result = new MyMatrix(this.row, other.column);
        for (int i = 0; i < result.column; i++) {
            for (int j = 0; j < result.row; j++) {
                double entryValue = 0;
                for (int k = 0; k < this.column; k++) {
                    entryValue += this.matrix[j][k] * other.matrix[k][i];
                }
                result.matrix[j][i] = entryValue;
            }
        }
        return result;
    }

    public MyMatrix mulptiplyBy(double scalar) {
        MyMatrix result = new MyMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.matrix[i][j] = scalar * matrix[i][j];
            }
        }
        return result;
    }

    public MyMatrix add(MyMatrix other) {
        MyMatrix result = new MyMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.matrix[i][j] = other.matrix[i][j] + matrix[i][j];
            }
        }
        return result;
    }

    public void setColumnSpacing(int value) {
        checkSpacing(value);
        columnSpacing = value;
    }

    public void setRowSpacing(int value) {
        checkSpacing(value);
        rowSpacing = value;
    }

    public boolean equals(MyMatrix other) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (this.matrix[i][j] != other.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getDigitNum(double num) {
        if (num == 0) {
            return 1;
        } else {
            int intNum = (int) num;
            int digitNum = 0;
            while (num > 0) {
                num /= 10;
                digitNum++;
            }
            if (isInteger(String.valueOf(num))) {
                return digitNum;
            } else {
                return digitNum + 1;
            }
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void checkSpacing(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("spacing: " + value);
        }
    }
}
