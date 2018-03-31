package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    @Qualifier("mealServiceImpl")
    private MealService service;

    @Test
    public void create() throws Exception {
        Meal newMeal = new Meal(null, LocalDateTime.now(), "Hello", 100);
        Meal created = service.create(newMeal, USER_ID);
        newMeal.setId(created.getId());
        assertMatch(service.getAll(USER_ID), newMeal, MEAL_3, MEAL_2, MEAL_1);
    }

    @Test
    public void get() {
        Meal meal = service.get(100004, 100000);
        assertMatch(meal, MEAL_3);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        Meal meal = service.get(100002, 100001);
        assertMatch(meal, MEAL_1);
    }

    @Test
    public void delete() {
        service.delete(100006, 100001);
        assertMatch(service.getAll(100001), MEAL_6, MEAL_4);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        service.delete(100006, 100000);
    }

    @Test
    public void update() {
        Meal updated = new Meal(MEAL_1);
        updated.setCalories(1);
        updated.setDescription("hello");
        assertMatch(service.get(100002, 100000), updated);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() {
        Meal updated = new Meal(MEAL_1);
        updated.setCalories(1);
        updated.setDescription("hello");
        assertMatch(service.get(100002, 100001), updated);
    }

    @Test
    public void getBetweenDateTimes() {
        List<Meal> meals = service.getBetweenDateTimes(LocalDateTime.of(2015, 5, 31, 11, 0),
                LocalDateTime.of(2015, 5, 31, 21, 0), 100001);
        assertMatch(meals, MEAL_6, MEAL_5);
    }

    @Test
    public void getAll() {
        List<Meal> meals = service.getAll(100001);
        assertMatch(meals, MEAL_6, MEAL_5, MEAL_4);
    }
}