package com.leadersapiens.study.march.TDD;

import org.apache.log4j.Logger;
import org.junit.*;


import static org.junit.Assert.assertEquals;

public class JunitTestTest {
    public static JunitTest junitTest;
    public static Logger logger = Logger.getLogger(JunitTestTest.class.getName());

    @BeforeClass
    public static void makeInstance() throws Exception {
        junitTest = new JunitTest("홍길동", 20, 180.0f);
    }
    @Before
    public void printBefore() throws Exception {
        logger.info("before");
    }
    @Test
    public void getAge() throws Exception {
        assertEquals(20, junitTest.getName());
    }
    @Test
    public void getTall() throws Exception {
        assertEquals(180.0f, junitTest.getTall());
    }
    @Test
    public void setAge() throws Exception {
        junitTest.setAge(24);
    }
    @Test
    public void getAge2() throws Exception {
        assertEquals(20, junitTest.getAge());
    }
    @Test
    public void setTall() throws Exception {
        junitTest.setTall(175.0f);
    }
    @Test
    public void getTall2() throws Exception {
        assertEquals(175.0f, junitTest.getTall());
    }
    @Test
    public void setName() throws Exception {
        junitTest.setName("임꺽정");
    }
    @Test
    public void getName2() throws Exception {
        assertEquals("홍길동", junitTest.getName());
    }
    @After
    public void printAfter() throws Exception {
        logger.debug("After!!");
    }
    @AfterClass
    public static void printAfterClass() throws Exception {
        logger.debug("After Class");
    }
}
