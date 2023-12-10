public class Grade {
    private String subject;
    private double score;

    public Grade(String s, double score) {
        subject = s;
        this.score = score;
    }

    static char GetLetterGrade (double s) {
        if (s < 0 || s > 100){
            return 'E';
        } else if (s < 40) {
            return 'F';
        } else if (s < 50) {
            return 'D';
        } else if (s < 60) {
            return 'C';
        } else if (s < 70) {
            return 'B';
        } else if (s >= 70) {
            return 'A';
        }
        return 'E';
    }

    // getter methods
    public String GetSubject() {
        return subject;
    }
    public double GetScore() {
        return score;
    }

    // setter methods
    public void SetSubject(String s) {
        subject = s;
    }
    public void SetScore(double s) {
        score = s;
    }
}
