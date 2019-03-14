package com.leadersapiens.study.march.TDD;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class SubDateTest extends TestCase {

    private static Logger logger = Logger.getLogger(SubDateTest.class.getName());

    public static void main(String[] args) {
        junit.textui.TestRunner.run(SubDateTest.class);
    }

    public void test1() {
        logger.info("TEST START");
    }

    public void testGetYearDay() {
        assertEquals(0, SubDate.getYearDay(1));
        assertEquals(365, SubDate.getYearDay(2));
    }

    public void testLeapYear() {
        assertTrue(SubDate.isLeapYear(0));
        assertFalse(SubDate.isLeapYear(1));
        assertTrue(SubDate.isLeapYear(4));
        assertTrue(SubDate.isLeapYear(1200));
        assertFalse(SubDate.isLeapYear(700));
    }

    public void testGetMonthDay() {
        assertEquals(31, SubDate.getMonthDay(2, SubDate.isLeapYear(2011)));
        assertEquals(60, SubDate.getMonthDay(3, SubDate.isLeapYear(2016)));
    }

    public void testGetTotalDay() {
        assertEquals(1, SubDate.getTotalDay("00010101"));
        assertEquals(366, SubDate.getTotalDay("00010201"));
    }

    public void testSubDate() {
        assertEquals(1, SubDate.sub("20061231", "20070101"));
        assertEquals(31 + 28 + 30 + 31 + 14, SubDate.sub("20070101", "20070515"));
        assertEquals(31 + 29 + 30 + 31 + 14, SubDate.sub("20080101", "20080515"));
    }

}
