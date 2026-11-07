package trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    private String name;
    private boolean isFinished;
    private List<Task> subtasks;

    public Task(String name, List<Task> subtasks) {
        this.isFinished = false;
        this.name = name;
        this.subtasks = new ArrayList<>();
        for (Task st : subtasks){
            addSubTask(st);
        }
    }

    public Task(String name, Task... subtasks) {
        this(name, Arrays.asList(subtasks));
    }

    public Task(String name) {
        this(name, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getSubtasks() {
        return new ArrayList<>(subtasks);
    }

    public void setSubtasks(List<Task> subtasks) {
        List<Task> copy = new ArrayList<>(this.subtasks);
        try {
            this.subtasks = new ArrayList<>();
            for(Task st : subtasks){
                addSubTask(st);
            }
        } catch (RuntimeException e){
            this.subtasks = copy;
            throw e;
        }
    }

    public void removeSubTask(Task subTask){
        this.subtasks.remove(subTask);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished() {
        for (Task st : this.subtasks) {
            if (!st.isFinished) throw new UnfinishedSubtaskException();
        }
        this.isFinished = true;
    }

    public void setUnfinished(){
        this.isFinished = false;
    }

    public void addSubTask(Task subTask){
        if (subTask == null) throw new RuntimeException();
        if (!this.subtasks.contains(subTask)) {
            this.subtasks.add(subTask);
            if (!subTask.isFinished) this.isFinished = false;
        }
    }

    @Override
    public String toString() {
        String result =  "Задача: " + name;
        if(this.subtasks.size() > 0){
            result += ". Подзадачи: ";
            for (int i = 0; i < this.subtasks.size(); i++) {
                if(i < this.subtasks.size()-1){
                    result += " " + subtasks.get(i).name + ", ";
                } else {
                    result += " " + subtasks.get(i).name + ".";
                }
            }
        }
        return result;
    }
}
