/*
 * Copyright (c) 2014 - 2020.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package digitalbankdemo;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformerImpl implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        String invocations = System.getenv("invocations");
        String browsers = System.getenv("browsers");

        if (invocations!=null)
        {
            annotation.setInvocationCount(Integer.valueOf(invocations));
        }
        else {
            annotation.setInvocationCount(1);
        }
        annotation.setThreadPoolSize(1000);

        if (browsers!=null)
            annotation.setDataProvider(browsers);
    }

}
