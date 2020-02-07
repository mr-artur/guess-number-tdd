package ua.kpi.guessnumber.controllers;

import org.junit.jupiter.api.Test;
import ua.kpi.guessnumber.models.Model;
import ua.kpi.guessnumber.views.View;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerTest {

    public static final int CORRECT_ANSWER = 50;
    public static final int BOTTOM_LIMIT = 0;
    public static final int TOP_LIMIT = 100;

    private final View view = new View();
    private final Model model = new Model(CORRECT_ANSWER, BOTTOM_LIMIT, TOP_LIMIT);
    private final Controller controller = new Controller(model, view);

    @Test
    void tryToGuess_shouldCallTryToGuessMethodOfModel() {
        controller.tryToGuess(CORRECT_ANSWER);

        assertTrue(model.isNumberGuessed());
    }

    @Test
    void tryToGuess_shouldNotCallTryToGuessMethodOfModel_whenAnswerIsSmallerThanBottomLimit() {
        controller.tryToGuess(BOTTOM_LIMIT - 1);

        assertEquals(0, model.getAnswers().size());
    }

    @Test
    void tryToGuess_shouldNotCallTryToGuessMethodOfModel_whenAnswerIsGreaterThanTopLimit() {
        controller.tryToGuess(TOP_LIMIT + 1);

        assertEquals(0, model.getAnswers().size());
    }
}
