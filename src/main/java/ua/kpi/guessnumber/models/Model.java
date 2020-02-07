package ua.kpi.guessnumber.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    private int correctAnswer;
    private final List<Integer> answers = new ArrayList<>();
    private int bottomLimit;
    private int topLimit;

    public void setUp(int bottomLimit, int topLimit) {
        setBottomLimit(bottomLimit);
        setTopLimit(topLimit);
        generateCorrectAnswer();
    }

    public void generateCorrectAnswer() {
        correctAnswer = new Random().nextInt(topLimit - 1) + bottomLimit + 1;
    }

    void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setTopLimit(int limit) {
        topLimit = limit;
    }

    public void setBottomLimit(int limit) {
        bottomLimit = limit;
    }

    public void addAnswer(int answer) {
        answers.add(answer);
    }

    public int getTopLimit() {
        return topLimit;
    }

    public int getBottomLimit() {
        return bottomLimit;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void tryToGuess(int answer) {
        addAnswer(answer);
        if (answer != correctAnswer) {
            updateLimits(answer);
        }
    }

    private void updateLimits(int answer) {
        if (answer > correctAnswer) {
            setTopLimit(answer);
        } else {
            setBottomLimit(answer);
        }
    }

    public boolean isNumberGuessed() {
        return answers.contains(correctAnswer);
    }
}
