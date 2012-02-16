package tw.base.conf;

public class Greeter {

    private Welcome welcome;

    public Greeter(Welcome welcome) {
        this.welcome = welcome;
    }

    public void welcomeVisitors() {
        System.out.println(welcome.buldPhrase("New York"));
    }
}
