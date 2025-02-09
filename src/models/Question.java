package models;

import java.util.List;

public class Question {
    private String questionText;   // Stores the question
    private List<String> options;  // List of answer choices
    private int correctOptionIndex; // Correct answer index (0-based)

    // Constructor
    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }
    
    public boolean isCorrect(int userChoice) {
        return userChoice == correctOptionIndex;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    // Display question with options
    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i)); // Display as 1-based index
        }
    }
}

