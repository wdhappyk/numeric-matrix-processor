package processor;

import java.util.Locale;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {

    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }

    public static void main(String[] args) {
        while (true) {
            printVariants();
            final String choice = getChoice();

            if (choice.equals("0")) {
                break;
            }

            doAction(choice);

            System.out.println();
        }
    }

    private static void printVariants() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
    }

    private static String getChoice() {
        System.out.print("Your choice: ");
        final String choice = scanner.next();
        System.out.println();
        return choice;
    }

    private static void doAction(String variant) {
        switch (variant) {
            case "1":
                addMatrices();
                break;
            case "2":
                multiplicationByNumber();
                break;
            case "3":
                multiplyMatrices();
                break;
            case "4":
                transpose();
                break;
            case "5":
                calcDeterminant();
                break;
            case "6":
                inverseMatrix();
                break;
        }
    }

    private static void addMatrices() {
        final Matrix[] matrix = getTwoMatrix();
        final Matrix sum = Matrix.sum(matrix[0], matrix[1]);

        if (sum != null) {
            System.out.println("The add result is:");
            System.out.print(sum.toString());
        } else {
            System.out.print("ERROR");
        }
    }

    private static void multiplicationByNumber() {
        System.out.print("Enter size of matrix: ");
        final MatrixSize size = getSizeOfMatrix();
        System.out.println("Enter matrix:");
        final Matrix matrix = getMatrix(size);

        System.out.println("Enter constant:");
        final int scalar = scanner.nextInt();

        System.out.println("The multiply matrix to constant result is:");
        final Matrix result = Matrix.scalarProduct(matrix, scalar);
        System.out.print(result.toString());
    }

    private static void multiplyMatrices() {
        final Matrix[] matrix = getTwoMatrix();
        final Matrix multiplicationResult = Matrix.multiplication(matrix[0], matrix[1]);

        if (multiplicationResult != null) {
            System.out.println("The multiplication result is:");
            System.out.print(multiplicationResult.toString());
        } else {
            System.out.print("ERROR");
        }
    }

    private static void transpose() {
        final String variant = chooseTransposeVariant();

        System.out.print("Enter matrix size: ");
        final MatrixSize size = getSizeOfMatrix();
        System.out.println("Enter matrix:");
        final Matrix matrix = getMatrix(size);

        Matrix result;

        switch (variant) {
            default:
            case "1":
                result = Matrix.transposeAlongMainDiagonal(matrix);
                break;
            case "2":
                result = Matrix.transposeAlongSideDiagonal(matrix);
                break;
            case "3":
                result = Matrix.transposeAlongVerticalLine(matrix);
                break;
            case "4":
                result = Matrix.transposeAlongHorizontalLine(matrix);
                break;
        }

        System.out.println("The result is:");
        if (result != null) {
            System.out.print(result.toString());
        } else {
            System.out.println("ERROR!");
        }
    }

    private static void calcDeterminant() {
        System.out.print("Enter matrix size: ");
        final MatrixSize size = getSizeOfMatrix();

        if (size.rows != size.cols) {
            System.out.print("ERROR! Matrix must be square!");
            return;
        }

        System.out.println("Enter matrix:");
        final Matrix matrix = getMatrix(size);

        double determinant = matrix.getDeterminant();

        System.out.println("The result is:");
        System.out.println(determinant);
    }

    private static void inverseMatrix() {
        System.out.print("Enter matrix size: ");
        final MatrixSize size = getSizeOfMatrix();

        if (size.rows != size.cols) {
            System.out.print("ERROR! Matrix must be square!");
            return;
        }

        System.out.println("Enter matrix:");
        final Matrix matrix = getMatrix(size);

        System.out.println("The result is:");
        System.out.println(matrix.inverse());
    }


    private static String chooseTransposeVariant() {
        printTransposeVariants();

        System.out.print("Your choice: ");
        return scanner.next();
    }

    private static void printTransposeVariants() {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
    }

    private static Matrix getMatrix(MatrixSize size) {
        final Matrix matrix = new Matrix(size);

        for (int row = 0; row < size.rows; ++row) {
            for (int col = 0; col < size.cols; ++col) {
                final double value = scanner.nextDouble();
                matrix.set(row, col, value);
            }
        }

        return matrix;
    }

    private static MatrixSize getSizeOfMatrix() {
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        return new MatrixSize(rows, cols);
    }

    private static Matrix[] getTwoMatrix() {
        System.out.print("Enter size of first matrix: ");
        final MatrixSize sizeOfMatrixA = getSizeOfMatrix();
        System.out.println("Enter first matrix:");
        final Matrix matrixA = getMatrix(sizeOfMatrixA);

        System.out.print("Enter size of second matrix: ");
        final MatrixSize sizeOfMatrixB = getSizeOfMatrix();
        System.out.println("Enter second matrix:");
        final Matrix matrixB = getMatrix(sizeOfMatrixB);

        return new Matrix[]{matrixA, matrixB};
    }
}

class MatrixSize {
    final int rows;
    final int cols;

    public MatrixSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
}

class Matrix {
    private final MatrixSize size;
    private final double[][] items;

    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            return null;
        }

        final int rows = a.getRows();
        final int cols = a.getCols();
        final MatrixSize size = new MatrixSize(rows, cols);
        final Matrix sum = new Matrix(size);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                sum.set(row, col, a.get(row, col) + b.get(row, col));
            }
        }

        return sum;
    }

    public static Matrix scalarProduct(Matrix matrix, double scalar) {
        final int rows = matrix.getRows();
        final int cols = matrix.getCols();
        final MatrixSize size = new MatrixSize(rows, cols);
        final Matrix res = new Matrix(size);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                res.set(row, col, matrix.get(row, col) * scalar);
            }
        }

        return res;
    }

    public static Matrix multiplication(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows() && (a.getRows() != b.getRows() || a.getCols() != b.getCols())) {
            return null;
        }
        final int rows = a.getRows();
        final int cols = b.getCols();
        final MatrixSize size = new MatrixSize(rows, cols);
        final Matrix res = new Matrix(size);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                double sum = 0;
                for (int j = 0; j < a.getCols(); ++j) {
                    sum += a.get(row, j) * b.get(j, col);
                }
                res.set(row, col, sum);
            }
        }

        return res;
    }

    public static Matrix transposeAlongMainDiagonal(Matrix matrix) {
        final int rows = matrix.getRows();
        final int cols = matrix.getCols();
        final MatrixSize size = new MatrixSize(cols, rows);
        final Matrix res = new Matrix(size);

        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < rows; ++j) {
                res.set(i, j, matrix.get(j, i));
            }
        }

        return res;
    }

    public static Matrix transposeAlongSideDiagonal(Matrix matrix) {
        final int rows = matrix.getRows();
        final int cols = matrix.getCols();
        final MatrixSize size = new MatrixSize(cols, rows);
        final Matrix res = new Matrix(size);

        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < rows; ++j) {
                res.set(i, j, matrix.get(rows - j - 1, cols - i - 1));
            }
        }

        return res;
    }

    public static Matrix transposeAlongVerticalLine(Matrix matrix) {
        final int rows = matrix.getRows();
        final int cols = matrix.getCols();
        final MatrixSize size = new MatrixSize(rows, cols);
        final Matrix res = new Matrix(size);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                res.set(i, j, matrix.get(i, cols - j - 1));
            }
        }

        return res;
    }

    public static Matrix transposeAlongHorizontalLine(Matrix matrix) {
        final int rows = matrix.getRows();
        final int cols = matrix.getCols();
        final MatrixSize size = new MatrixSize(rows, cols);
        final Matrix res = new Matrix(size);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                res.set(i, j, matrix.get(rows - i - 1, j));
            }
        }

        return res;
    }

    public Matrix(MatrixSize size) {
        this.size = size;
        this.items = new double[this.size.rows][this.size.cols];
    }

    public int getRows() {
        return this.size.rows;
    }

    public int getCols() {
        return this.size.cols;
    }

    public void set(int row, int col, double value) {
        this.items[row][col] = value;
    }

    public double get(int row, int col) {
        return this.items[row][col];
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (double[] row : this.items) {
            for (double value : row) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public boolean isSquare() {
        return this.getRows() == this.getCols();
    }

    public Matrix getMinor(int row, int col) {
        final int rows = this.getRows();
        final int cols = this.getCols();
        final MatrixSize minorSize = new MatrixSize(rows - 1, cols - 1);
        final Matrix minor = new Matrix(minorSize);

        for (int r = 0, i = 0; r < rows; ++r) {
            if (r == row)
                continue;

            for (int c = 0, j = 0; c < cols; ++c) {
                if (c == col)
                    continue;
                minor.set(i, j, this.get(r, c));
                j++;
            }
            i++;
        }

        return minor;
    }

    public double getCofactor(int row, int col) {
        final int k = (row + col) % 2 == 0 ? 1 : -1;
        final Matrix minor = this.getMinor(row, col);
        return k * minor.getDeterminant();
    }

    public Matrix getUnionMatrix() {
        final int rows = this.getRows();
        final int cols = this.getCols();
        final Matrix res = new Matrix(this.size);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                final double cofactor = this.getCofactor(row, col);
                res.set(row, col, cofactor);
            }
        }

        return res;
    }

    public Matrix inverse() {
        final double determinant = this.getDeterminant();
        final Matrix adjointMatrix = this.getAdjointMatrix();
        return Matrix.scalarProduct(adjointMatrix, 1d / determinant);
    }

    public Matrix getAdjointMatrix() {
        return Matrix.transposeAlongMainDiagonal(this).getUnionMatrix();
    }

    public double getDeterminant() {
        if (!this.isSquare()) {
            throw new Error("Matrix must be square");
        }

        final int size = this.getRows();

        if (size == 1) {
            return this.get(0, 0);
        }

        if (size == 2) {
            final double mainDiagonalProduction = this.get(0, 0) * this.get(1, 1);
            final double sideDiagonalProduction = this.get(0, 1) * this.get(1, 0);
            return mainDiagonalProduction - sideDiagonalProduction;
        }

        double sum = 0;

        for (int i = 0; i < size; ++i) {
            sum += this.get(0, i) * this.getCofactor(0, i);
        }

        return sum;
    }

}
