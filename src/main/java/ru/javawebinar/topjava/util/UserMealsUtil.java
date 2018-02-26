package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil
{
    public static void main(String[] args)
    {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );

        List<UserMealWithExceed> rez = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(15,0), 2000);

        for(UserMealWithExceed user : rez)
        {
            System.out.println(user.toString());
        }
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay)
    {
        List<UserMealWithExceed> newList = new LinkedList<UserMealWithExceed>();

        Map<LocalDate, Integer> sumByDate = new TreeMap<LocalDate, Integer>();
        for(UserMeal user : mealList)
        {
            sumByDate.put(user.getDateTime().toLocalDate(),
                    sumByDate.getOrDefault(user.getDateTime().toLocalDate(), 0) + user.getCalories());
        }

        for(int i = 0; i < mealList.size(); i++)
        {
            LocalTime currentTime = mealList.get(i).getDateTime().toLocalTime();
            if(currentTime.isAfter(startTime) && currentTime.isBefore(endTime))
            {
                newList.add(new UserMealWithExceed(mealList.get(i).getDateTime(),
                        mealList.get(i).getDescription(),
                        mealList.get(i).getCalories(),
                        sumByDate.get(mealList.get(i).getDateTime().toLocalDate()) > caloriesPerDay ? true : false));
            }

        }

        return newList;
    }
}