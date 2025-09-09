import org.example.Hello;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class HelloTest {
    @Test
    public void runTest() {
        Hello hello = new Hello();
        Response response = hello.handler();
        System.out.println(response);
    }
}
