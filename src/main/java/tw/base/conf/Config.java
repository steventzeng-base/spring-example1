package tw.base.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Welcome welcome() {
        return new Welcome();
    }

    @Bean
    public GoogleTranslator googleTranslator() {
        return new GoogleTranslator();
    }

    @Bean
    public TranslatingWelcome translatingWelcome() {
        return new TranslatingWelcome(googleTranslator());
    }

    @Bean
    public Greeter greeter() {
        return new Greeter(translatingWelcome());
    }
}
