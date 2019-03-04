package com.leadersapiens.study.march;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogFourJTest {

    static Logger logger = Logger.getLogger(LogFourJTest.class.getName());

    public static void main(String[] args) {

        //PropertyConfigurator.configure("log4J.properties");

        logger.info("Entering application");
        logger.debug("Entering application");
        logger.error("Entering application");
    }
}