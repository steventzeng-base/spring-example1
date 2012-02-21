package tw.base.conf;

public class TranslatingWelcome extends Welcome {

    private GoogleTranslator translator;

    public TranslatingWelcome(GoogleTranslator translator) {
        this.translator = translator;
    }

    @Override
    public String buldPhrase(String city) {
        return translator.translate(super.buldPhrase(city));
    }
}
