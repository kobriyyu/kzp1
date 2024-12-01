import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab1KobriyYurii {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();


        System.out.println("Введіть символ заповнювач: ");
        String symbol = sc.next();

        // Перевірка на валідність символа заповнювача
        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row); // Створюється зубчастий масив для збереження матриці
        String fileName = "Lab1.txt";

        // Запуск бізнес логіки для генерації зубчастого масиву (виводу в консоль і запису в файл)
        try {
            printMatrix(arr, symbol, row, fileName);
        } catch (IOException e) {

            throw new RuntimeException("Сталася помилка під час запису в файл: " + e.getMessage());

        }
    }

    public static void printMatrix(String[][] arr, String symbol, int row, String file) throws IOException {

        System.out.println("Результат матриці: ");

        try (FileWriter writer = new FileWriter(file)) {

            for (int i = 0; i < row; i++) {
                int indexJ = 0;

                for (int j = 0; j < row; j++) {

                    if (i < row / 2 && j >= row / 2) {
                        arr[i][indexJ] = symbol;
                        writer.write(arr[i][indexJ] + " ");
                        System.out.print(arr[i][indexJ] + " ");
                        indexJ++;
                    } else if (i >= row / 2 && j < row / 2) {
                        arr[i][indexJ] = symbol;
                        writer.write(arr[i][indexJ] + " ");
                        System.out.print(arr[i][indexJ] + " ");
                        indexJ++;
                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush(); // Очищення буфера запису у файл
        }
    }

    public static String[][] createLengthOfEachSubArr (int row){
        // Метод для створення зубчастого масиву із різними розмірами підмасивів
        String[][] arr = new String[row][]; // Ініціалізація зубчастого масиву

        for (int i = 0; i < row; i++) {
            int length = 0;

            for (int j = 0; j < row; j++) {

                if (i < row / 2 && j >= row / 2) {
                    length++;
                } else if(i >= row / 2 && j < row / 2){
                    length++;
                }
            }
            arr[i] = new String[length];
        }
        return arr;
    }
}
