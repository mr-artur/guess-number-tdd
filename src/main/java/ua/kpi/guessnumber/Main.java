package ua.kpi.guessnumber;

import ua.kpi.guessnumber.controllers.Controller;
import ua.kpi.guessnumber.models.Model;
import ua.kpi.guessnumber.views.View;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int BOTTOM_LIMIT = 0;
        final int TOP_LIMIT = 100;
        final int CORRECT_ANSWER = new Random().nextInt(TOP_LIMIT) + BOTTOM_LIMIT;

        Model model = new Model(CORRECT_ANSWER, BOTTOM_LIMIT, TOP_LIMIT);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}
