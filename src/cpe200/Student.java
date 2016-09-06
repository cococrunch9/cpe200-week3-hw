package cpe200;

public class Student {
    protected final static String DEFAULT_NAME = "John Doe";
    protected final static String DEFAULT_ID = "560610000";
    protected final static int DEFAULT_YOB = 1990;
    protected final static boolean DEFAULT_STATUS = false;

    public Student()
    {
        this.Name = DEFAULT_NAME;
        this.Student_id = DEFAULT_ID;
        this.YOB = DEFAULT_YOB;
        this.status = DEFAULT_STATUS;
    }
    public Student(String s, String s1, int i, boolean b) {
        this.Name = s;
        if(isValidStudent_id(s1))
        {
            this.Student_id = s1;
        }
        else
        {
            this.Student_id = DEFAULT_ID;
        }
        if(isValidYOB(i))
        {
            this.YOB = i;
        }
        else
        {
            this.YOB = DEFAULT_YOB;
        }
        this.status = b;
    }

    // implement all missing constructors here

    // implement all get and set methods here

    @Override
    public String toString() {
        String o = this.Name + " (" + this.Student_id + ") " +"was born in " + this.YOB + " is an";
        if(status)
        {
            o = o + " ACTIVE student.";
        }
        else
        {
            o = o + " INACTIVE student.";
        }


        return o;
    }

    private boolean isValidStudent_id(String id) {
        String x = "5[6-9]{1}061[0-2]{1}[0-9]{3}";
        if(id.matches(x))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isValidYOB(int yob) {
        if(yob < 1989)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String getName() {
        return this.Name;
    }

    public boolean isActive() {
        return this.status;
    }

    public int getYearOfBirth() {
        return this.YOB;
    }

    public String getStudent_id() {
        return this.Student_id;
    }

    public void setName(String name) {
        if(name != "")
        {
            this.Name = name;
        }

    }

    public void setStudent_id(String student_id) {
       if(isValidStudent_id(student_id))
       {
           this.Student_id = student_id;
       }
    }

    public void setYearOfBirth(int yearOfBirth) {
       if(isValidYOB(yearOfBirth))
       {
           this.YOB = yearOfBirth;
       }
    }

    private String Name;
    private String Student_id;
    private int YOB;
    private boolean status;

}
