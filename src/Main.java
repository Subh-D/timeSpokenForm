import com.smartBear.britishTime.BritishTimeConverter;
import com.smartBear.britishTime.InvalidTimeException;
import com.smartBear.britishTime.TimeInputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var Scanner = new Scanner(System.in);

        System.out.println("Enter time in HH:MM format:");
        String input = Scanner.nextLine();

        try{
            var validator = new TimeInputValidator();
            var Time = validator.parse(input);

            var Converter = new BritishTimeConverter();
            var result = Converter.convert(Time);

            System.out.println("British English representation: " + result);
        } catch(InvalidTimeException exception){
            System.out.println("Error : " + exception.getMessage());
        }
    }
}