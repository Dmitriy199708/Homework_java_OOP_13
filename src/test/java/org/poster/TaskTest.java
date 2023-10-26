package org.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
    SimpleTask simpleTask1 = new SimpleTask(1, "Посмотреть на небо");
    SimpleTask simpleTask2 = new SimpleTask(2, "Подышать");

    String[] subtasks1 = {"Яйца", "Макароны", "Крупы"};
    Epic epic1 = new Epic(3, subtasks1);
    String[] subtasks2 = {"Яйца", "Мука", "Крупы"};
    Epic epic2 = new Epic(4, subtasks2);

    Meeting meeting1 = new Meeting(
            4,
            "Сделать дз",
            "Дз 11",
            "сегодня"
    );
    Meeting meeting2 = new Meeting(
            5,
            "Сделать дз",
            "Дз 13",
            "вчера"
    );
    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);
    }

    @Test
    public void shouldReturnMatchingTasksWhenSearchingByQuery() {

        Task[] expected = {epic1, epic2};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void noCorrespondingTask() {

        Task[] expected = {};
        Task[] actual = todos.search("Трость");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySimpleTask() {

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search("Посмотреть на небо");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByMeeting() {

        Task[] expected = {meeting1, meeting2};
        Task[] actual = todos.search("Сделать дз");
        Assertions.assertArrayEquals(expected, actual);
    }
}