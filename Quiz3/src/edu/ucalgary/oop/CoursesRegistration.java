package edu.ucalgary.oop;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.regex.*;

public class CoursesRegistration {

    private final File INPUT_FILE;
    private String data;
    private HashMap<String, ArrayList<String>> courses;
    private final Pattern PATTERN;
    private final Pattern ID;

    public CoursesRegistration(File file) {
        INPUT_FILE = file;
        PATTERN = Pattern.compile("\\d{4}-[A-Z]{4}\\d{3}");
        ID = Pattern.compile("\\d{4}");
        courses = new HashMap<String, ArrayList<String>>();
    }

    public boolean readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            return false;
        }
        data = stringBuilder.toString();
        return true;
    }

    public void parseContents() throws IllegalArgumentException {
        Matcher matcher = PATTERN.matcher(data);
        while (matcher.find()) {
            String course = matcher.group();
            if (course.matches(PATTERN.pattern())) {
                String id = ID.matcher(course).group();
                if (courses.containsKey(id)) {
                    courses.get(id).add(course.substring(5));
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(course.substring(5));
                    courses.put(id, list);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public HashMap<String, ArrayList<String>> getCoursesHash() {
        return courses;
    }

    public String getData() {
        return data;
    }

    public void setData(String newData) {
        data = newData;
        courses.clear();
    }

    public String[] getCoursesByStudentID(String id) throws NoSuchElementException {
        if (courses.containsKey(id)) {
            ArrayList<String> list = courses.get(id);
            return list.toArray(new String[0]);
        } else {
            throw new NoSuchElementException();
        }
    }

    public String getStudentIDWithMostCourses() {
        int max = 0;
        String maxId = "";
        for (String id : courses.keySet()) {
            int size = courses.get(id).size();
            if (size > max) {
                max = size;
                maxId = id;
            }
        }
        return maxId;
    }

}
    
