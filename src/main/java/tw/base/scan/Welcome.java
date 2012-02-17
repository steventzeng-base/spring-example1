package tw.base.scan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("default")
public class Welcome {

    public String buldPhrase(String city) {
        return String.format("Welcome to  %s !", city);
    }
}
