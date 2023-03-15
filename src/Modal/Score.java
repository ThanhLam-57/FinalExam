package Modal;

public class Score {
    private int stdcode;
    private String stdName;
    private int stdAge;
    private String stdClass;
    private double stdGPA;
    private String stdGender;

    public Score(int stdcode, String stdName, int stdAge, String stdClass, double stdGPA, String stdGender) {
        this.stdcode = stdcode;
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.stdClass = stdClass;
        this.stdGPA = stdGPA;
        this.stdGender = stdGender;
    }

    public Score(String stdName, int stdAge, String stdClass, double stdGPA, String stdGender) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.stdClass = stdClass;
        this.stdGPA = stdGPA;
        this.stdGender = stdGender;
    }

    public int getStdcode() {
        return stdcode;
    }

    public void setStdcode(int stdcode) {
        this.stdcode = stdcode;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public double getStdGPA() {
        return stdGPA;
    }

    public void setStdGPA(double stdGPA) {
        this.stdGPA = stdGPA;
    }

    public String getStdGender() {
        return stdGender;
    }

    public void setStdGender(String stdGender) {
        this.stdGender = stdGender;
    }

    @Override
    public String toString() {
        return "Score{" +
                "stdcode=" + stdcode +
                ", stdName='" + stdName + '\'' +
                ", stdAge=" + stdAge +
                ", stdClass='" + stdClass + '\'' +
                ", stdGPA=" + stdGPA +
                ", stdGender='" + stdGender + '\'' +
                '}';
    }
}
