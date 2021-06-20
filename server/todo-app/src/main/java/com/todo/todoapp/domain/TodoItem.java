package com.todo.todoapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String task;
    private Integer isDone;

    /**
     * @param task
     * @param isDone
     */

    public TodoItem(String task, Integer isDone) {

        this.task = task;
        this.isDone = isDone;
    }

    /**
     * 
     */
    public TodoItem() {
    }

    /**
     * @param isDone the isDone to set
     */
    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    /**
     * @return the isDone
     */
    public Integer getIsDone() {
        return isDone;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the task
     */
    public String getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(String task) {
        this.task = task;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "TodoItem [id=" + id + ", isDone=" + isDone + ", task=" + task + "]";
    }

    /**
     * @return the isDone
     */

}
