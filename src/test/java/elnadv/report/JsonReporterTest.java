package elnadv.report;

import elnadv.report.JsonReporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * using the reporter that produces json.
 */
@Listeners(JsonReporter.class)
public class JsonReporterTest {

  @Test
  public void test(){}
}
