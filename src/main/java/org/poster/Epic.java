package org.poster;

public class Epic extends Task { //Задача, состоящая из подзадач.

    private String[] subtasks; //массив из подзадач

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) { // перебираем все задачи
            if (subtask.contains(query)) { // если задача подходит под запрос
                return true;
            }
        }
        return false;
    }
}
