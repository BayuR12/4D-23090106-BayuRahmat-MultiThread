package com.example.stopwatch;

public class Stopwatch {
    private long startTime = 0;
    private long elapsedTime = 0;
    private boolean running = false;
    private final Runnable updateCallback;

    public Stopwatch(Runnable updateCallback) {
        this.updateCallback = updateCallback;
    }

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            running = true;
            new Thread(() -> {
                while (running) {
                    updateCallback.run();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void stop() {
        if (running) {
            elapsedTime = System.currentTimeMillis() - startTime;
            running = false;
        }
    }

    public void reset() {
        startTime = 0;
        elapsedTime = 0;
        running = false;
        updateCallback.run();
    }

    public long getElapsedTime() {
        return running ? System.currentTimeMillis() - startTime : elapsedTime;
    }
}
