package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {
    protected final static String DEFAULT_ID = "000000";
    protected final static String DEFAULT_COURSE = "TBA";
    protected final static String DEFAULT_LEC = "TBA";
    protected final static int DEFAULT_MAX = 30;
    protected final static int DEFAULT_NUM = 0;

    public Course() {
        this.course_name = DEFAULT_COURSE;
        this.course_id = DEFAULT_ID;
        this.lecturer = DEFAULT_LEC;
        this.max_students = DEFAULT_MAX;
    }

    public Course(String n, String cid) {
        this.course_name = n;
        this.course_id = cid;
        this.lecturer = DEFAULT_LEC;
        this.max_students = DEFAULT_MAX;
    }

    public Course(String n, String cid, String l) {
        this.course_name = n;
        this.course_id = cid;
        this.lecturer = l;
        this.max_students = DEFAULT_MAX;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !cid.equalsIgnoreCase("")?cid:DEFAULT_ID;
        this.lecturer = !l.equalsIgnoreCase("")?l:DEFAULT_LEC;
        if(max < 10)
        {
            this.max_students = DEFAULT_MAX;
        }
        else this.max_students = max;

    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer =!lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMax_students() {
        // implement here
        return max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students >= 10)
        {
            this.max_students = max_students;
        }
    }

    public int getNo_students() {

        return no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students >= 0 && no_students <= max_students)
        {
            this.no_students = no_students;
        }
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";
                if(no_students == 0)
                {
                    o = o+"NO student, ";
                }
                else if(no_students == 1)
                {
                    o = o+"ONE student, ";
                }
                else
                {
                    o = o+no_students + " students, ";
                }
                o = o + "[maximum: " + max_students +"]";

        // implement the rest here

        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        if(m.find() && id.length() == 6)
        {
            return true;
        }

        else return false;
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
