import java.io.*;
import java.util.*; 

public class labSixNew{
    //MS2S is Milliseconds to Seconds
    static final double MS2S = 0.001;
    public static void main(String[] args){
        //setup Scanner
        Scanner s = new Scanner(System.in);
        
        //input data (three parameters)
        System.out.println("How much time does it take for you to type one character?");
        double speed = s.nextDouble();
    
        System.out.println("Was that milliseconds or seconds use 1 to indicate seconds and 0 to indicate milliseconds?");
        //SoM stands for seconds or milliseconds
        double SoM = s.nextDouble();

        while(SoM != 0 && SoM != 1){
            System.out.println("Please pick 0 for (milliseconds) or 1 for (seconds)...");
            SoM = s.nextDouble();
        }

        System.out.println("What is the target encryption level in bits?");
        double bits = s.nextDouble();
        //convert to seconds based on first two parameters
        double totSecs = speed;
        if(SoM == 0)
            totSecs = speed*MS2S;
    
        //calculate # of possibilities
        double numPos = Math.pow(2,bits);
    
        //calculate total time
        double totHack = totSecs * numPos;
        System.out.println("It will take you...");
        if(totHack > 31539456){// greater than a year
            double theYears = Math.floor(totHack/31539456);
            System.out.printf("%.0f years, \n", theYears);
            totHack = totHack - (theYears *31539456);
            //totHack== 3684352
        }
        if(totHack > 2628288){// greater than a month
            double theMonths = Math.floor(totHack/2628288);
            System.out.printf("%.0f months, ", theMonths  );
            totHack = totHack - (theMonths *2628288);
            //totHack== 3684352
        }
        if(totHack > 604800){// greater than a second
            double theWeeks = Math.floor(totHack/604800);
            System.out.printf("%.0f weeks, ", theWeeks );
            totHack = totHack - (theWeeks*604800);
            //totHack== 0
        }
        
        if(totHack > 86400){// greater than a second
            double theDays = Math.floor(totHack/86400);
            System.out.printf("%.0f days, ", theDays );
            totHack = totHack - (theDays*86400);
            //totHack== 0
        }
        
        if(totHack > 3600){// greater than a second
            double theHours = Math.floor(totHack/3600);
            System.out.printf("%.0f hours, ", theHours );
            totHack = totHack - (theHours*3600);
            //totHack== 0
        }
        
        if(totHack > 60){// greater than a second
            double theMinutes = Math.floor(totHack/60);
            System.out.printf("%.0f minutes, ", theMinutes);
            totHack = totHack - (theMinutes*60);
            //totHack== 0
        }
        
        if(totHack > 0){// greater than a second
            double theSecs = Math.ceil(totHack);
            System.out.printf("%.0f and seconds. \n\n ", theSecs);
            totHack = totHack - (theSecs*1);
            //totHack== 0
        }


        printResults(theYears, theMonths, theWeeks, theDays, theHours, theMinutes, theSecs);
    }

/**
    * printResult
    * 
    * This method prints the results for labe for and five in a single separated
    * function.
    * 
    * Parameters:
    *    years: The years it thaks to hack.
    *    weeks: The weeks it thaks to hack.
    *    days: The days it thaks to hack.
    *    hours: The hours it thaks to hack.
    *    ...
    * Return value:
    *   boolean. The function returns a boolean if the number of years is greater
    *   than 1.0.
    */
    
    public static boolean printResults(double years, double months, double weeks, double days, double hours, double minutes, double seconds){
        boolean YearsGreaterThan1 = false;
        System.out.print("It will take you ");
        System.out.printf("%.0f years", years);
        System.out.printf("%.0f months", months);
        System.out.printf("%.0f weeks", weeks);
        System.out.printf("%.0f days", days);
        System.out.printf("%.0f hours", hours);
        System.out.printf("%.0f minutes", minutes);
        System.out.printf("%.0f seconds", seconds);
        System.out.print(" to Hack");
        if (years > 1.0) 
            YearsGreaterThan1 = true;
        return YearsGreaterThan1;

        
    }
}





