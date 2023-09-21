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
        // MM/DD/YY, HH:MM, Name, Price, Quantity, assembling time?, Duration
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
        for (int i = 0; i < n; i++){
            String str = s.next();
            dateT[i] = str;
            str = s.next();
            timeT[i] = str;
            str = s.next();
            categoryT[i] = str;
            str = s.next();
            Assembling_fee[i] = Double.parseDouble(str);
            str = s.next();
            quantityT[i] = Integer.parseInt(str);
            str = s.next();
            Assembling_Time[i] = Double.parseDouble(str);
            str = s.next();
            Energy_and_Device_Cost[i] = Double.parseDouble(str);
        }
		// Your code ends here.

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(Assembling_fee);
        int lowestItemIndex = getMinPriceIndex(Assembling_fee);

		// TODO: Print items with highest and lowest price per unit.
        /*
        9/21/22
        14:34
        laptop
        49.36
         */
		// Your code starts here:
        System.out.println(dateT[highestItemIndex]);
        System.out.println(timeT[highestItemIndex]);
        System.out.println(categoryT[highestItemIndex]);
        System.out.println(Assembling_fee[highestItemIndex]);
		// Your code ends here.
        System.out.println(dateT[lowestItemIndex]);
        System.out.println(timeT[lowestItemIndex]);
        System.out.println(categoryT[lowestItemIndex]);
        System.out.println(Assembling_fee[lowestItemIndex]);
        // Calculate the average price, rating and duration of sales by category.
        // Maintain following category-wise stats in Arrays
        int[] numOfCategoriesC = new int[categoriesList.length];// so numOfCategoriesC[0] = # of items of type categoriesList[0]
        double[] totPriceC = new double[categoriesList.length]; // total price of each category = sum(price x qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totAssembling_TimeC = new double[categoriesList.length]; // total assembling time?? of each category = sum(price x qty)
        double[] totEnergy_and_Device_CostC = new double[categoriesList.length]; // total Duration of each category = sum(price x qty)

        /*
        phone //category
        9007 //total products assembled
        20.86 //average assembling fee per unit,
        13.68 //average net profit per unit

        N.B. The average assembling fee is a weighted average that needs to
        consider the quantity of items per batch. The average net profit per unit is the
        average profit per product. This is based on the total fee charged minus the costs
        including the cost of time spent (time multiplied by worker's hourly rate).
         */

		// TODO: set the value of catIndex for each i to be such that categoryT[i] == categoriesList[i].
		// Your code starts here:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < categoriesList.length; j++) {
                if (categoryT[i].equals(categoriesList[j])) {
                    numOfCategoriesC[j]++;
                }
            }
        }
		// Your code ends here.

		// TODO: Calculate & Print Category-wise Statistics
		// Your code starts here:

		// Your code ends here.
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:
        int index = 0;
        double maxPrice = 0;
        for (int i = 0; i < priceT.length; i++){
            if(priceT[i] > maxPrice){
                maxPrice = priceT[i];
                index = i;
            }
        }
        return(index); // modify this as well
		// Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
        // Your code starts here:
        int index = 0;
        double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < priceT.length; i++){
            if(priceT[i] < minPrice){
                minPrice = priceT[i];
                index = i;
            }
        }
        return(index); // modify this as well
        // Your code ends here.
    }
}
