
package Sokoban_menu_particle;

import com.sun.javafx.css.StyleConverterImpl;
import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

import java.util.logging.Logger;


public class ButtonTypeConverter extends StyleConverterImpl<String, ButtonType> {

    private ButtonTypeConverter() {
    }

    public static StyleConverter<String, ButtonType> getInstance() {
        return ButtonTypeConverter.Holder.INSTANCE;
    }

    public ButtonType convert(ParsedValue<String, ButtonType> value, Font notUsedFont) {
        String string = (String) value.getValue();

        try {
            return ButtonType.valueOf(string.toUpperCase());
        } catch (NullPointerException | IllegalArgumentException var5) {
            Logger.getLogger(ButtonTypeConverter.class.getName()).info(String.format("Invalid button type value '%s'", string));
            return ButtonType.SWIPE;
        }
    }

    public String toString() {
        return "ButtonTypeConverter";
    }

    private static class Holder {

        static final ButtonTypeConverter INSTANCE = new ButtonTypeConverter();

        private Holder() {
            throw new IllegalAccessError("Holder class");
        }
    }
}
