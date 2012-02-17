package tw.base.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tranlate")
public class TranslatingWelcome extends Welcome {

    @Autowired
    private GoogleTranslator translator;

    @Override
    public String buldPhrase(String city) {
        return translator.translate(super.buldPhrase(city));
    }
}
