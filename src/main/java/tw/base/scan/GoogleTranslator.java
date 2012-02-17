package tw.base.scan;

import org.springframework.stereotype.Component;

@Component
public class GoogleTranslator {

    public String translate(String phrase) {
        return String.format("google translate..{%s}", phrase);
    }
}
