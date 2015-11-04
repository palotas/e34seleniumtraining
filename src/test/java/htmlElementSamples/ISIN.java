package htmlElementSamples;

import org.testng.annotations.Test;

/**
 * Created by gridfusion on 23/09/15.
 */
public class ISIN {


    @Test
    public void calculate() {

        IsinCalc calc = new IsinCalc();
        System.out.println(calc.calculateCheckISIN("CHSKISKI001"));

    }


}
