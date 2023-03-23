import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String args[]){

        String s = "Robot 890AC - - [90/03/2022] \"START - NE (ultrasonic)\"";


        String REGEX = "\"([A-z]+) - ([A-z]{1,2})";
        Pattern PATTERN = Pattern.compile(REGEX);

        Matcher matcher = PATTERN.matcher("("+"ultrasonic" + ")");
        Matcher matcher2 = PATTERN.matcher(s);

        if(matcher.find()){
            System.out.println(matcher.group());
        }

        if(matcher2.find()){
            System.out.println(matcher2.group());
        }




    }
}
