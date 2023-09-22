package assn02;
import java.util.ArrayList;
import java.util.Scanner;

// Here is a starter code that you may optionally use for this assignment.
// TODD: You need to complete these sections

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

		// TODD: Fill in the above arrays with data entered from the console.
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

		// TODD: Print items with highest and lowest price per unit.
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

		// TODD: set the value of catIndex for each i to be such that categoryT[i] == categoriesList[i].
		// Your code starts here:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < categoriesList.length; j++) {
                if (categoryT[i].equals(categoriesList[j])) {
                    numOfCategoriesC[j]++;
                }
            }
        }
		// Your code ends here.

		// TODD: Calculate & Print Category-wise Statistics
		// Your code starts here:
        /* foreach Category,
              print category
              int Array A - indicies of position of selected category in categoryT array

              foreach item in categoryT, if they match, Array A, add the quantity to variable, print

              total assemblingfee/total quantity = sum(assemblyfee * quantity)/totalquantity, print

              profit = fee charged - (cost + time[in minutes] * worker's hourly rate)
              ((fee * quantity) - (cost of each + sum(time)/ * 16))/totalquantity
              (totAssemblyFee - sum(costs + time/60 * 16))/totQuantity
        */

        for (int i = 0; i < categoriesList.length; i++) {
            // total products assembled
            ArrayList<Integer> A = new ArrayList<>();
            System.out.println(categoriesList[i]);
            int totQuantity = 0;
            for (int j = 0; j < categoryT.length; j++) {
                if (categoriesList[i].equals(categoryT[j])) {
                    totQuantity += quantityT[j];
                    A.add(j);
                }
            }
            System.out.println(totQuantity);

            // average assembling fee per unit
            double totAssemblyFee = 0;
            for (int j = 0; j < A.size(); j++) {
                totAssemblyFee += Assembling_fee[A.get(j)] * quantityT[A.get(j)];
            }
            System.out.printf("%.2f%n", totAssemblyFee / totQuantity);

            // average net profit per unit
            double totCosts = 0;
            for (int j = 0; j < A.size(); j++) {
                totCosts += Energy_and_Device_Cost[A.get(j)] + Assembling_Time[A.get(j)] * 16;
            }
            System.out.printf("%.2f%n", (totAssemblyFee - totCosts) / totQuantity);
            // Your code ends here.
        }
    }

    // TODD: Find index of item with the highest price per unit.
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

    // TODD: Find index of item with the lowest price per unit.
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