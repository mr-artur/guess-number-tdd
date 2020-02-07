package ua.kpi.guessnumber.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelTest {

    private Model model = new Model(50, 0, 100);

    @Test
    void tryToGuess_shouldChangeStateOfNumberToGuessed_whenAnswerIsCorrect() {
        model.tryToGuess(50);

        assertTrue(model.isNumberGuessed());
    }

    @Test
    void tryToGuess_shouldNotChangeStateOfNumberToGuessed_whenAnswerIsNotCorrect() {
        model.tryToGuess(20);

        assertFalse(model.isNumberGuessed());
    }

    @Test
    void tryToGuess_shouldUpdateTopLimit_whenAnswerIsGreaterThanCorrectAnswer() {
        model.tryToGuess(55);

        assertEquals(55, model.getTopLimit());
    }

    @Test
    void tryToGuess_shouldUpdateBottomLimit_whenAnswerIsSmallerThanCorrectAnswer() {
        model.tryToGuess(45);

        assertEquals(45, model.getBottomLimit());
    }

    @Test
    void tryToGuess_shouldSaveHistoryOfAnswers() {
        int answer = 45;
        model.tryToGuess(answer);
        List<Integer> actual = model.getAnswers();

        assertTrue(actual.contains(answer));
    }
}