import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("/home/martynuk/IdeaProjects/j3/matrix.txt");

            int[][] matrix = Matrix.createMatrix(file);

            System.out.println("Inputted matrix : ");
            Matrix.printMatrix(matrix);
            ArrayList<ArrayList<Integer>> min = Matrix.minPosition(matrix);
            ArrayList<ArrayList<Integer>> max = Matrix.maxPosition(matrix);
            System.out.println("Positions of local max elements : ");
            System.out.println(max);
            System.out.println("Positions of local min elements : ");
            System.out.println(min);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File wasn't found");
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Not int element");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public static int[][] createMatrix(File file) throws NoSuchElementException, FileNotFoundException,
            IllegalArgumentException, InputMismatchException {
        Scanner input = new Scanner(file);
        int n = input.nextInt();
        int m = input.nextInt();
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException();
        }
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!input.hasNext()) {
                    throw new IllegalArgumentException("Lack of elements");
                }
                if (!input.hasNextInt()) {
                    throw new InputMismatchException();
                }
                array[i][j] = input.nextInt();
            }
        }
        if (input.hasNextInt()) {
            throw new IllegalArgumentException("Too much elements");
        }
        return array;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

    public static ArrayList<ArrayList<Integer>> minPosition(int[][] inputMatrix) {
        ArrayList<ArrayList<Integer>> Result = new ArrayList<>();
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix.length; j++) {
                int count = 0;
                if (i != 0) {
                    if (inputMatrix[i][j] < inputMatrix[i - 1][j]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (j != 0) {
                    if (inputMatrix[i][j] < inputMatrix[i][j - 1]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (i != inputMatrix.length - 1) {
                    if (inputMatrix[i][j] < inputMatrix[i + 1][j]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (j != inputMatrix.length - 1) {
                    if (inputMatrix[i][j] < inputMatrix[i][j + 1]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (count == 4) {
                    ArrayList<Integer> lair = new ArrayList<>();
                    lair.add(i);
                    lair.add(j);
                    Result.add(lair);
                }
            }
        }
        return Result;
    }

    public static ArrayList<ArrayList<Integer>> maxPosition(int[][] inputMatrix) {
        ArrayList<ArrayList<Integer>> Result = new ArrayList<>();
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix.length; j++) {
                int count = 0;
                if (i != 0) {
                    if (inputMatrix[i][j] > inputMatrix[i - 1][j]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (j != 0) {
                    if (inputMatrix[i][j] > inputMatrix[i][j - 1]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (i != inputMatrix.length - 1) {
                    if (inputMatrix[i][j] > inputMatrix[i + 1][j]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (j != inputMatrix.length - 1) {
                    if (inputMatrix[i][j] > inputMatrix[i][j + 1]) {
                        count++;
                    }
                } else {
                    count++;
                }
                if (count == 4) {
                    ArrayList<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(j);
                    Result.add(element);
                }
            }
        }
        return Result;
    }
}