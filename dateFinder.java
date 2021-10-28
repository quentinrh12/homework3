import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class dateFinder{  

    public dateFinder(String source) {

        List allDates = new ArrayList<>();

        Pattern pattern1 = Pattern.compile("(0[1-9]|1[12])/(0[1-9]|[12][0-9]|3[01])/[0-9][0-9][0-9][0-9]");
        Pattern pattern2 = Pattern.compile("(0[1-9]|1[12])/(0[1-9]|[12][0-9]|3[01])/[0-9][0-9]");
        Pattern pattern3 = Pattern.compile("[0-9][0-9][0-9][0-9]/(0[1-9]|1[12])/(0[1-9]|[12][0-9]|3[01])");
        Pattern pattern4 = Pattern.compile("(0[1-9]|1[12])(-0[1-9]|-[12][0-9]|-3[01])-[0-9][0-9][0-9][0-9]");

        try {

            Scanner sc = new Scanner(Path.of(source));
            Scanner sc2 = new Scanner(Path.of(source));
            Scanner sc3 = new Scanner(Path.of(source));
            Scanner sc4 = new Scanner(Path.of(source));
            
            List firstFormatDates = sc.findAll(pattern1)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());

            List secondFormatDates = sc2.findAll(pattern2)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());      
                                      
            List thirdFormatDates = sc3.findAll(pattern3)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());  
                                      
            List fourthFormatDates = sc4.findAll(pattern4)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());                           

            System.out.println(firstFormatDates);
            System.out.println(secondFormatDates);
            System.out.println(thirdFormatDates);
            System.out.println(fourthFormatDates);

            sc.close();
            sc2.close();
            sc3.close();
            sc4.close();

            allDates.addAll(firstFormatDates);
            allDates.addAll(secondFormatDates);
            allDates.addAll(thirdFormatDates);
            allDates.addAll(fourthFormatDates);   
            
            System.out.println(allDates);

        } catch (Exception e) {
            System.out.println("didnt work");
        }

        // Matcher test1 = pattern1.matcher("11/16/1508");
        // Matcher test2 = pattern2.matcher("02/01/08");
        // Matcher test3 = pattern3.matcher("1273/12/07");
        // Matcher test4 = pattern4.matcher("04-27-7139");
        // Matcher test5 = pattern2.matcher("04/27/21");
        // Matcher test6 = pattern2.matcher("04/27/21");

        // boolean b = test1.matches();
        // boolean b2 = test2.matches();
        // boolean b3 = test3.matches();
        // boolean b4 = test4.matches();

        // System.out.println("Test 1: true");
        // System.out.println("Test 1 is " + b + "\n");

        // System.out.println("Test 2: true");
        // System.out.println("Test 2 is " + b2 + "\n");

        // System.out.println("Test 3: true");
        // System.out.println("Test 3 is " + b3 + "\n");

        // System.out.println("Test 4: true");
        // System.out.println("Test 4 is " + b4 + "\n");
    }

    public static void main(String args[]){  

        String source = "input.txt";

        dateFinder finder = new dateFinder(source);

    }  
} 

