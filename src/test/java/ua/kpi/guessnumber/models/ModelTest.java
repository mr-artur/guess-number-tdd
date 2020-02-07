package ua.kpi.guessnumber.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    public static final int CORRECT_ANSWER = 50;
    public static final int BOTTOM_LIMIT = 0;
    public static final int TOP_LIMIT = 100;

    private final Model model = new Model(CORRECT_ANSWER, BOTTOM_LIMIT, TOP_LIMIT);

    @Test
    void tryToGuess_shouldChangeStateOfNumberToGuessed_whenAnswerIsCorrect() {
        model.tryToGuess(CORRECT_ANSWER);

        assertTrue(model.isNumberGuessed());
    }

    @Test
    void tryToGuess_shouldNotChangeStateOfNumberToGuessed_whenAnswerIsNotCorrect() {
        model.tryToGuess(20);

        assertFalse(model.isNumberGuessed());
    }

    @Test
    void tryToGuess_shouldUpdateTopLimit_whenAnswerIsGreaterThanCorrectAnswer() {
        int answer = 55;
        model.tryToGuess(answer);

        assertEquals(answer - 1, model.getTopLimit());
    }

    @Test
    void tryToGuess_shouldUpdateBottomLimit_whenAnswerIsSmallerThanCorrectAnswer() {
        int answer = 45;
        model.tryToGuess(answer);

        assertEquals(answer + 1, model.getBottomLimit());
    }

    @Test
    void tryToGuess_shouldSaveHistoryOfAnswers() {
        int answer = 45;
        model.tryToGuess(answer);
        List<Integer> actual = model.getAnswers();

        assertTrue(actual.contains(answer));
    }
}
