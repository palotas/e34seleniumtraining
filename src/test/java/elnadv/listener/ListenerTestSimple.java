package elnadv.listener;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by e34 on 31.12.16.
 */

//@Listeners({StatusListener.class})
public class ListenerTestSimple {

    @Test
    public void simpleListenerTest() throws Exception {

        System.out.println("this is a simple listener test");
        Assert.assertTrue(false);

    }

}
