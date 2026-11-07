package trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpisokDel {
    private String owner;
    private List<Task> tasks;

    public SpisokDel(String owner, List<Task> tasks) {
        this.owner = owner;
        this.tasks = new ArrayList<>();
        for (Task t : tasks){
            addTask(t);
        }
    }

    public SpisokDel(String owner, Task... tasks) {
        this(owner, Arrays.asList(tasks));
    }

    public SpisokDel(String owner) {
        this(owner, new ArrayList<>());
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<Task> tasks) {
        List<Task> copy = new ArrayList<>(this.tasks);
        try{
            this.tasks = new ArrayList<>();
            for(Task t : tasks){
                this.addTask(t);
            }
        } catch (RuntimeException e) {
            this.tasks = copy;
            throw e;
        }
    }

    public void addTask(Task task){
        if(task == null) throw new RuntimeException();
        if(!this.tasks.contains(task)){
                this.tasks.add(task);
            }
        }

    public void removeTask(Task task){
        this.tasks.remove(task);
    }

    @Override
    public String toString() {
        String result = "Владелец: " + owner;
        if (this.tasks.size() > 0){
            result += ". Задачи: ";
            for (int i = 0; i < this.tasks.size(); i++) {
                if(i < this.tasks.size()-1){
                    result += this.tasks.get(i).getName() + ", ";
                }
                else {
                    result += this.tasks.get(i).getName() + ".";
                }
            }
        }
        return result;
    }
}
