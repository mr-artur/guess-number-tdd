package ua.kpi.guessnumber.controllers;

import ua.kpi.guessnumber.models.Model;
import ua.kpi.guessnumber.views.View;

import java.util.Scanner;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.printMessage(View.WELCOME_MESSAGE);
        int guessedNumber = guessNumber();
        view.printGuessedNumber(guessedNumber);
        view.printAllAnswers(model.getAnswers());
    }

    private int guessNumber() {
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            answer = inputIntValue(scanner);
            tryToGuess(answer);
        } while (!model.isNumberGuessed());
        return answer;
    }

    private int inputIntValue(Scanner scanner) {
        view.printLimits(model.getBottomLimit(), model.getTopLimit());
        view.printMessage(View.INPUT_NUMBER);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT);
            view.printMessage(View.INPUT_NUMBER);
            scanner.next();
        }
        return scanner.nextInt();
    }

    void tryToGuess(int answer) {
        if (isOutOfLimits(answer)) {
            view.printMessage(View.OUT_OF_LIMITS_MESSAGE);
        } else {
            model.tryToGuess(answer);
        }
    }

    private boolean isOutOfLimits(int answer) {
        return answer > model.getTopLimit() || answer < model.getBottomLimit();
    }
}
