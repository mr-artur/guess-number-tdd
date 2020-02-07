package ua.kpi.guessnumber.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    public static final int CORRECT_ANSWER = 50;

    private static final Model model = new Model();

    @BeforeAll
    static void setUp() {
        model.setUp(Limits.BOTTOM_LIMIT, Limits.TOP_LIMIT);
        model.setCorrectAnswer(CORRECT_ANSWER);
    }

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
        int answer = CORRECT_ANSWER + 1;
        model.tryToGuess(answer);

        assertEquals(answer, model.getTopLimit());
    }

    @Test
    void tryToGuess_shouldUpdateBottomLimit_whenAnswerIsSmallerThanCorrectAnswer() {
        int answer = CORRECT_ANSWER - 1;
        model.tryToGuess(answer);

        assertEquals(answer, model.getBottomLimit());
    }

    @Test
    void tryToGuess_shouldSaveHistoryOfAnswers() {
        int answer = CORRECT_ANSWER;
        model.tryToGuess(answer);
        List<Integer> actual = model.getAnswers();

        assertTrue(actual.contains(answer));
    }
}
