package ua.kpi.guessnumber.views;

import java.util.List;
import java.util.StringJoiner;

public class View {

    public static final String WELCOME_MESSAGE = "Try to guess a number! Number is between 0 and 100";
    public static final String OUT_OF_LIMITS_MESSAGE = "Number is out of limits!";
    public static final String INPUT_NUMBER = "Please, enter a number : ";
    public static final String WRONG_INPUT = "Please, enter an integer number within the specified limits!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLimits(int bottom, int top) {
        printMessage(String.format("Current limits: [%d...%d]", bottom, top));
    }

    public void printGuessedNumber(int number) {
        printMessage(String.format("Congratulations! Correct answer was: %d", number));
    }

    public void printAllAnswers(List<Integer> answers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        answers.forEach(answer -> joiner.add(answer.toString()));
        printMessage(String.format("Sequence of your answers: %s", joiner.toString()));
    }
}
