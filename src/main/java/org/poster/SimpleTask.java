package org.poster;

public class SimpleTask extends Task {  //простая задача

    private String title; // Название задачи


    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }
}
