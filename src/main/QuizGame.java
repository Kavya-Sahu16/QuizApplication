package main;
import models.Question;
import services.QuizService;
import java.util.List;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        // Load questions from file
        QuizService quizService = new QuizService("src/questions.txt");
        List<Question> questions = quizService.getQuestions();
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("--------------------------");

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            
            int userAnswer = scanner.nextInt() - 1;  // Convert to 0-based index
            
            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer was: " + q.getOptions().get(q.getCorrectOptionIndex()) + "\n");
            }
        }

        // Display final score
        System.out.println("Quiz Over! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

