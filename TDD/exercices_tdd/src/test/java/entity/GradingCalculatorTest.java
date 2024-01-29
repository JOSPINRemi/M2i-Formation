package entity;

import org.example.entity.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {
    private GradingCalculator gradingCalculatorUnderTest;

    void initGradingCalculator(int score, int attendance) {
        gradingCalculatorUnderTest = new GradingCalculator();
        gradingCalculatorUnderTest.setScore(score);
        gradingCalculatorUnderTest.setAttendancePercentage(attendance);
    }

    @Test
    void givenScore95AndAttendance90WhenGetGradeThenGradeIsA() {
        initGradingCalculator(95, 90);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('A', grade);
    }

    @Test
    void givenScore85AndAttendance90WhenGetGradeThenGradeIsB() {
        initGradingCalculator(85, 90);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('B', grade);
    }

    @Test
    void givenScore65AndAttendance90WhenGetGradeThenGradeIsC() {
        initGradingCalculator(65, 90);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('C', grade);
    }

    @Test
    void givenScore95AndAttendance65WhenGetGradeThenGradeIsB() {
        initGradingCalculator(95, 65);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('B', grade);
    }

    @Test
    void givenScore95AndAttendance55WhenGetGradeThenGradeIsF() {
        initGradingCalculator(95, 55);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('F', grade);
    }

    @Test
    void givenScore65AndAttendance55WhenGetGradeThenGradeIsF() {
        initGradingCalculator(65, 55);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('F', grade);
    }

    @Test
    void givenScore60AndAttendance90WhenGetGradeThenGradeIsF() {
        initGradingCalculator(60, 90);

        char grade = gradingCalculatorUnderTest.getGrade();

        Assertions.assertEquals('F', grade);
    }
}
