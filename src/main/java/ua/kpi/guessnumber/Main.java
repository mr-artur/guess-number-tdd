package ua.kpi.guessnumber;

import ua.kpi.guessnumber.controllers.Controller;
import ua.kpi.guessnumber.models.Model;
import ua.kpi.guessnumber.views.View;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}
