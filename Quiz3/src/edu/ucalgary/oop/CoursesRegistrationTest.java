package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class CoursesRegistrationTest {
    private final String fileName = "exampleTest.txt";
    private File myFile = new File(fileName);

    private CoursesRegistration coursesExample = new CoursesRegistration(myFile);
    private final String EXAMPLE_DATA = "6527-ENSF182\n3562-ENLS872\n7842-ENEN180\n3562-ENLE981\n3562-ENPS072\n6527-ENPS072\n";

    @Test
    public void testExistingFile() {
        /*
         * Testing with a valid txt file
         */
        boolean returnValue = true;
        CoursesRegistration coursesExample2 = new CoursesRegistration(this.myFile);

        returnValue = coursesExample2.readFile();
        assertTrue("readFile() returned false while an existing file is used!", returnValue);
    }

    @Test
    public void testNonExistingFile() {
        /*
         * Testing with invalid txt file (doesn't exist)
         */
        File myInvalidFile = new File("invalid.txt");
        boolean returnValue = true;

        CoursesRegistration coursesExample2 = new CoursesRegistration(myInvalidFile);

        returnValue = coursesExample2.readFile();

        assertFalse("readFile() returned true while a non-existing file is used!", returnValue);
    }

    @Test
    public void testSetData() {
        /*
         * Tests whether setData sets the "data" value correctly or not.
         */
        String newData = "8172-BIOL101\n4158-BIOL101";
        this.coursesExample.setData(newData);
        assertEquals("setData() didn't same passed data correctly", newData, this.coursesExample.getData());
    }
//
    @Test
    public void testSetDataEmptyCourses() {
        /*
         * Tests whether setData clears the "courses" or not.
         */

        String newData = "8172-BIOL101\n4158-BIOL101";
        this.coursesExample.setData(newData);
        assertTrue("setData() didn't clear the courses hashMap correctly",
                this.coursesExample.getCoursesHash().isEmpty());
    }
//
    @Test
    public void testReadFile() {
        /*
         * Tests if read file works
         */
        boolean returnValue = this.coursesExample.readFile();
        assertTrue("ReadFile() didn't return true after reading the file", returnValue);
    }
//
    private HashMap<String, ArrayList<String>> createTestData() {
        this.coursesExample.setData(EXAMPLE_DATA);
        this.coursesExample.parseContents();
        HashMap<String, ArrayList<String>> trueCourses = new HashMap<String, ArrayList<String>>();

        ArrayList<String> student_6527 = new ArrayList<String>();
        student_6527.add("ENSF182");
        student_6527.add("ENPS072");
        ArrayList<String> student_3562 = new ArrayList<String>();
        student_3562.add("ENLS872");
        student_3562.add("ENLE981");
        student_3562.add("ENPS072");
        ArrayList<String> student_7842 = new ArrayList<String>();
        student_7842.add("ENEN180");

        trueCourses.put("6527", student_6527);
        trueCourses.put("3562", student_3562);
        trueCourses.put("7842", student_7842);
        return trueCourses;
    }

    @Test
    public void testParseContentsIDs() {
        /*
         * Tests if parsesContents() converts the data into the correct hash map.
         */
        HashMap<String, ArrayList<String>> trueCourses = createTestData();

        assertArrayEquals("parseContent() doesn't create the correct student IDs.",
                trueCourses.keySet().toArray(), this.coursesExample.getCoursesHash().keySet().toArray());

    }

    @Test
    public void testParseContentsCourses() {
        /*
         * Tests if parsesContents() converts the data into the correct hash map.
         */
        HashMap<String, ArrayList<String>> correctData = createTestData();
        correctData.keySet()
                .forEach(key2 -> assertArrayEquals(
                        "parseContent() doesn't create the correct student " + key2 + " courses.",
                        correctData.get(key2).toArray(), this.coursesExample.getCoursesHash().get(key2).toArray()));
    }

//    @Test
    public void testGetCoursesByStudentID() {
        /*
         * Tests the return of getCoursesByStudentID().
         */

        HashMap<String, ArrayList<String>> correctData = createTestData();

        ArrayList<String> cs = this.coursesExample.getCoursesByStudentID("3562");
        assertArrayEquals("getCoursesByID() method returns different array than the expected one",
                correctData.get("3562").toArray(), cs.toArray());
    }

    @Test
    public void testGetCoursesByStudentIDException() {
        /*
         * Tests whether getCoursesByStudentID() evokes the required exception or not.
         */
        this.coursesExample.setData(EXAMPLE_DATA);
        this.coursesExample.parseContents();
        boolean correctValue = false;
        try {
            this.coursesExample.getCoursesByStudentID("0000");
        } catch (NoSuchElementException e) {
            correctValue = true;
        }
        assertTrue("getCoursesByStudentID() must evoke an exception once a non existing ID is passed", correctValue);
    }

    @Test
    public void testGetStudentIDWithMostCourses() {
        /*
         * Tests getStudentIDWithMostCourses() return value.
         */
        this.coursesExample.setData(EXAMPLE_DATA);
        this.coursesExample.parseContents();

        assertEquals("getStudentIDWithMostCourses() returned incorrect ID", "3562",
                this.coursesExample.getStudentIDWithMostCourses());
    }

}
