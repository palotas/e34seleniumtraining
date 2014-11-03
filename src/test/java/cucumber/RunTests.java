package cucumber;
 
import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;
 
//main class
@RunWith(Cucumber.class)
@Cucumber.Options(format={"pretty", "html:target/cucumber"})
public class RunTests {
}