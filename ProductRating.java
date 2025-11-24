import java.text.DecimalFormat;

public class ProductRating {
    public static void main(String[] args) {
        double[][] ratings ={
            {4,5,4,4},
            {3,4,4,3},
            {4,5,3,4},
            {1,3,2,1},
        };
        int numCustomer = ratings.length;
        int numCategories = ratings[0].length;

        double[] categoryAvg = new double[numCategories];
        for (int j = 0; j < numCategories; j++) {
            double sum = 0;
            for (int i = 0; i < numCustomer; i++) {
                sum += ratings[i][j];
            }
            categoryAvg[j] = sum / numCustomer;
        }
        System.out.println("<output>");
        System.out.println("Rating       Product Package Delivery");
        System.out.printf("Average %.2f         %.2f  %.2f%n%n", categoryAvg[0], categoryAvg[1], categoryAvg[2]);

        for (int i = 0; i < numCustomer; i++) {
            double total = 0;
            for (int j = 0; j < numCategories; j++) {
                total += ratings[i][j];
            }
            double average = total / numCategories;
            System.out.printf("Customer %d provide the average rating %.2f%n", (i+1), average);
        }
        System.out.println("\n<output>");
    }
}
