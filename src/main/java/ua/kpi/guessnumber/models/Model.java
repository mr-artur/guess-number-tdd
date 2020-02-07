package ua.kpi.guessnumber.models;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final int correctAnswer;
    private final List<Integer> answers = new ArrayList<>();
    private int bottomLimit;
    private int topLimit;

    public Model(int correctAnswer, int bottomLimit, int topLimit) {
        this.correctAnswer = correctAnswer;
        this.bottomLimit = bottomLimit;
        this.topLimit = topLimit;
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
