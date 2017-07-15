package com.element34.testng.listener;

import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;

import java.util.Iterator;

/**
 * Created by e34 on 31.12.16.
 */
public class ParallelListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {

        iSuite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
        iSuite.getXmlSuite().setName("Listener Tests");


        System.out.println("Thread count: " + iSuite.getXmlSuite().getThreadCount());
        System.out.println("Parallel mode: " + iSuite.getXmlSuite().getParallel());
        System.out.println("Excluded groups: " + iSuite.getXmlSuite().getExcludedGroups());
        System.out.println("Parameters: " + iSuite.getXmlSuite().getParameters());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Iterator<IInvokedMethod> iter = iSuite.getAllInvokedMethods().iterator();
        while (iter.hasNext()) {
            System.out.println("Method run: " + iter.next().getTestMethod().getMethodName());
        }
    }
}
