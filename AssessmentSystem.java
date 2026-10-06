import java.util.*;

class Question {
    String text;
    String[] options;
    int correctOption;

    Question(String text, String[] options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class AssessmentSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question(
            "Which language is primarily used for Android development with the JVM?",
            new String[]{"Java", "HTML", "SQL", "CSS"}, 1));
        questions.add(new Question(
            "Which SQL command is used to retrieve data?",
            new String[]{"INSERT", "UPDATE", "SELECT", "DELETE"}, 3));
        questions.add(new Question(
            "Which keyword creates a class in Java?",
            new String[]{"class", "new", "object", "create"}, 1));
        questions.add(new Question(
            "Which data structure follows FIFO?",
            new String[]{"Stack", "Queue", "Tree", "Graph"}, 2));
        questions.add(new Question(
            "Which method is the entry point of a Java application?",
            new String[]{"start()", "run()", "main()", "execute()"}, 3));
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("ONLINE ASSESSMENT & EVALUATION SYSTEM");
        System.out.println("================================================");

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();
        if (studentName.isEmpty()) {
            studentName = "Student";
        }

        int score = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.text);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            int answer = readOption();
            if (answer == q.correctOption) {
                score++;
            }
        }

        long elapsedSeconds = (System.currentTimeMillis() - start) / 1000;
        double percentage = (score * 100.0) / questions.size();
        String grade = calculateGrade(percentage);

        System.out.println("\n================ RESULT ================");
        System.out.println("Student   : " + studentName);
        System.out.println("Score     : " + score + "/" + questions.size());
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade     : " + grade);
        System.out.println("Time Taken: " + elapsedSeconds + " seconds");
        System.out.println("=========================================");
    }

    private static int readOption() {
        while (true) {
            System.out.print("Your answer (1-4): ");
            try {
                int answer = Integer.parseInt(scanner.nextLine().trim());
                if (answer >= 1 && answer <= 4) {
                    return answer;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a number from 1 to 4.");
        }
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }
}
