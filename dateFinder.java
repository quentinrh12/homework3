import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class dateFinder{  

    public dateFinder(String source) {

        List allDates = new ArrayList<>();

        Pattern pattern1 = Pattern.compile("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/[0-9][0-9][0-9][0-9]");
        Pattern pattern2 = Pattern.compile("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/[0-9][0-9]");
        Pattern pattern3 = Pattern.compile("[0-9][0-9][0-9][0-9]/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])");
        Pattern pattern4 = Pattern.compile("(0[1-9]|1[0-2])(-0[1-9]|-[12][0-9]|-3[01])-[0-9][0-9][0-9][0-9]");
        Pattern pattern5 = Pattern.compile("(January|February|March|April|May|June|July|August|September|October|November|December) (0[1-9]|[12][0-9]|3[01]), [0-9][0-9][0-9][0-9]");
        Pattern pattern6 = Pattern.compile("(0[1-9]|[12][0-9]|3[01]) (January|February|March|April|May|June|July|August|September|October|November|December), [0-9][0-9][0-9][0-9]");

        try {

            Scanner sc = new Scanner(Path.of(source));
            Scanner sc2 = new Scanner(Path.of(source));
            Scanner sc3 = new Scanner(Path.of(source));
            Scanner sc4 = new Scanner(Path.of(source));
            Scanner sc5 = new Scanner(Path.of(source));
            Scanner sc6 = new Scanner(Path.of(source));
            
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
                                      
            List fifthFormatDates = sc5.findAll(pattern5)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());  
                                      
            List sixthFormatDates = sc6.findAll(pattern6)
                                      .map(MatchResult::group)
                                      .collect(Collectors.toList());   

            System.out.println(firstFormatDates);
            System.out.println(secondFormatDates);
            System.out.println(thirdFormatDates);
            System.out.println(fourthFormatDates);
            System.out.println(fifthFormatDates);
            System.out.println(sixthFormatDates);

            sc.close();
            sc2.close();
            sc3.close();
            sc4.close();
            sc5.close();
            sc6.close();

            allDates.addAll(firstFormatDates);
            allDates.addAll(secondFormatDates);
            allDates.addAll(thirdFormatDates);
            allDates.addAll(fourthFormatDates);  
            allDates.addAll(fifthFormatDates);
            allDates.addAll(sixthFormatDates); 
            
            System.out.println(allDates);

        } catch (Exception e) {
            System.out.println("didnt work");
        }
    }

    public static void main(String args[]){  

        String source = "input.txt";

        dateFinder finder = new dateFinder(source);

    }  
} 

