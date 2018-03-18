package domain;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * @Author Karol Meksuła
 * 17-03-2018
 * */

public class Trial {
    private final String TEST = "434./=karol2,34";

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("[0-9.=/]+(karol)([0-9]{1}\\,[0-9]{2,})");
        Matcher matcher = pattern.matcher(TEST);
        assertTrue(matcher.matches());
    }

    @Test
    public void test2() {
        Pattern pattern = Pattern.compile("(karol)");
        Matcher matcher = pattern.matcher(TEST);

        assertTrue(matcher.find());
        String march = matcher.group();
        assertEquals("karol", march);
    }
}
