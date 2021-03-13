package de.tp.framework.tasks;

import java.util.ArrayList;

public class ProcessTask implements Runnable {
    
    private String taskName;
    
    private Runnable runnable;
    private ArrayList<Runnable> runnables = new ArrayList<>();
    
    private boolean allowUI = false;
    
    public ProcessTask(String taskName, Runnable runnable, boolean allowUI) {
        this.taskName = taskName;
        this.runnable = runnable;
        this.allowUI = allowUI;
    }
    
    public ProcessTask(String taskName, Runnable runnable) {
        this(taskName, runnable, false);
    }
    
    public void addProcessFinishEvent(Runnable runnable) {
        this.runnables.add(runnable);
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    public Runnable getRunnable() {
        return runnable;
    }
    
    public boolean isAllowUI() {
        return allowUI;
    }
    
    @Override
    public void run() {
        runnable.run();
        for (Runnable runnable : runnables) {
            runnable.run();
        }
    }
    
}
