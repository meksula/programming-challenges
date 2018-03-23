package polygons.domain.generator;

import javafx.event.ActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public class ShapeTypeExtracter {
    public static String extract(ActionEvent actionEvent) {
        String event = actionEvent.getSource().toString();
        return match(event);
    }

    protected static String match(String event) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\,");
        Matcher matcher = pattern.matcher(event);

        String result = "";
        if (matcher.find())
            result = matcher.group();

        String[] table = result.split(",");
        return table[0].toUpperCase();
    }
}