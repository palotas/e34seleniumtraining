/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.listener.simple;


import elnadv.listener.browserlistener.StatusListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by e34 on 31.12.16.
 */

@Listeners({SimpleStatusListener.class})
public class SimpleListenerTest {

    @Test
    public void simpleListenerTest() throws Exception {

        System.out.println("this is a simple listener test");
        Assert.assertTrue(false);

    }

}
