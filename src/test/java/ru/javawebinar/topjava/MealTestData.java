package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int MEAL_ID_1 = START_SEQ + 2;
    public static final int MEAL_ID_2 = START_SEQ + 3;
    public static final int MEAL_ID_3 = START_SEQ + 4;
    public static final int MEAL_ID_4 = START_SEQ + 5;
    public static final int MEAL_ID_5 = START_SEQ + 6;
    public static final int MEAL_ID_6 = START_SEQ + 7;

    public static final Meal MEAL_1 = new Meal(MEAL_ID_1, LocalDateTime.of(2015, 5, 30, 10, 0), "Завтрак", 500);
    public static final Meal MEAL_2 = new Meal(MEAL_ID_2, LocalDateTime.of(2015, 5, 30, 13, 0), "Обед", 1000);
    public static final Meal MEAL_3 = new Meal(MEAL_ID_3, LocalDateTime.of(2015, 5, 30, 20, 0), "Ужин", 500);
    public static final Meal MEAL_4 = new Meal(MEAL_ID_4, LocalDateTime.of(2015, 5, 31, 10, 0), "Завтрак", 1000);
    public static final Meal MEAL_5 = new Meal(MEAL_ID_5, LocalDateTime.of(2015, 5, 31, 13, 0), "Обед", 500);
    public static final Meal MEAL_6 = new Meal(MEAL_ID_6, LocalDateTime.of(2015, 5, 31, 20, 0), "Обед", 510);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
