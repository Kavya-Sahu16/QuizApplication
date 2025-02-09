package services; 

import models.Question;
import java.io.*;
import java.util.*;

public class QuizService {
    private List<Question> questions = new ArrayList<>();

    public QuizService(String filePath) {
        loadQuestions(filePath);
    }

    // Read questions from file and store them in list
    private void loadQuestions(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 6) continue; // Ensure valid format

                String questionText = parts[0];
                List<String> options = Arrays.asList(parts[1], parts[2], parts[3], parts[4]);
                int correctIndex = Integer.parseInt(parts[5]) - 1; // Convert to 0-based index

                questions.add(new Question(questionText, options, correctIndex));
            }
        } catch (IOException e) {
            System.err.println("Error loading questions: " + e.getMessage());
        }
    }

    // Return the list of loaded questions
    public List<Question> getQuestions() {
        return questions;
    }
}
