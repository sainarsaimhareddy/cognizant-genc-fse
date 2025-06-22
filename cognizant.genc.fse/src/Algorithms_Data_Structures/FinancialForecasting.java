package Algorithms_Data_Structures;
import java.util.Scanner;
//Financial Forecasting
public class FinancialForecasting {

    public static double predictFutureValue(int years, double currentValue, double growthRate) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(years - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter Future year");
        int futureYear=sc.nextInt();
        System.out.println("Enter current value");
        double todayValue=sc.nextDouble();
        System.out.println("Enter the growth rate");
        double growthRate=sc.nextDouble();

        double predicted = predictFutureValue(futureYear, todayValue, growthRate);
        System.out.println("Predicted value after " + futureYear + " years: ₹" + predicted);
    }
}
