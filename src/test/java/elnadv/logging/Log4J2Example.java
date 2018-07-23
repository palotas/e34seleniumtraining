/*
 * Copyright (c) 2014 - 2018.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package elnadv.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4J2Example {

    private static final Logger logger = LogManager.getLogger("Log4J2Example");


    @Test
    public void logExample() {
        logger.trace("this is a TRACE message");
        logger.info("this is a INFO message");
        logger.debug("this is a DEBUG message");
        logger.error("this is a ERROR message");
        logger.fatal("this is a FATAL message");




    }
}
