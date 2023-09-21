package assn02;
import java.util.Scanner;

// Here is a starter code that you may optionally use for this assignment.
// TODO: You need to complete these sections

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        // MM/DD/YY, HH:MM, Name, Price, Quantity, Rating, Duration

        // create corresponding size arrays
        String dateT[] = new String[n];
        String timeT[] = new String[n];
        String categoryT[] = new String[n];
        double Assembling_fee[] = new double[n];
        int quantityT[] = new int[n];
        double Assembling_Time [] = new double[n];
        double Energy_and_Device_Cost [] = new double[n];

		// TODO: Fill in the above arrays with data entered from the console.
		// Your code starts here:

		// Your code ends here.

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(Assembling_fee);
        int lowestItemIndex = getMinPriceIndex(Assembling_fee);

		// TODO: Print items with highest and lowest price per unit.
		// Your code starts here:

		// Your code ends here.

        // Calculate the average price, rating and duration of sales by category.
        // Maintain following category-wise stats in Arrays
        int[] numOfCategoriesC = new int[categoriesList.length];// so numOfCategoriesC[0] = # of categories of type categoriesList[0]
        double[] totPriceC = new double[categoriesList.length]; // total price of each category = sum(price x qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totAssembling_TimeC = new double[categoriesList.length]; // total Rating of each category = sum(price x qty)
        double[] totEnergy_and_Device_CostC = new double[categoriesList.length]; // total Duration of each category = sum(price x qty)


		// TODO: set the value of catIndex for each i to be such that categoryT[i] == categoriesList[i].
		// Your code starts here:

		// Your code ends here.

		// TODO: Calculate & Print Category-wise Statistics
		// Your code starts here:

		// Your code ends here.
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:

        return(0); // modify this as well
		// Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
		// Your code starts here:

        return(0); // modify this as well
		// Your code ends here.
    }
}
