import java.util.Scanner;

public class GradeMCQ {
    public static void main(String[] args) {
         char[][] answers = {
            {'A', 'B', 'A', 'C', 'C', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A'},
            {'C', 'D', 'D', 'B', 'B', 'A'},
            {'A', 'B', 'C', 'C', 'B', 'A'}
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key to the MCQ: ");
        char[] key = new char[6];
        for (int i = 0; i < key.length; i++) {
            key[i] = sc.next().toUpperCase().charAt(0);
        }

        for (int i = 0; i < answers.length; i++) {
            int correct = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == key[j]) {
                    correct++;
                }
            }

            String result = (correct >= 3) ? "passed" : "failed";
            System.out.println("Student " + i + "'s correct count is " + correct +
                    ". Therefore, he/she " + result + " the test.");
        }
        sc.close();
    }
}