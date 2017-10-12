package elnadv.report;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(EmailReport.class)
public class EmailReportTest {


  @Test
  public  void test1(){
    Reporter.log("Hello");
  }
}
