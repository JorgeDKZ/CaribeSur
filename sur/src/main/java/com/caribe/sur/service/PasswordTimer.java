package com.caribe.sur.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordTimer extends Thread{
    // ATRIBUTES
    // Wait time in seconds
    private int waitTime = 0;
    private final int MAX_WAIT_TIME = 300; // Maximum wait time in seconds
    private final int SECONDS = 1000;
    private final int MINUTES = 60;

    // CONSTRUCTOR
    public PasswordTimer() {
        waitTime = MAX_WAIT_TIME;
        this.start(); // Start the timer thread
    }

    // METHODS
    // decrease the timer every second
    // until it reaches 0
    public void run(){
        
        while(waitTime > 0) {
            try {
                Thread.sleep(SECONDS); // Sleep for 1 second
                waitTime--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Get the wait time in minutes
    // to show the user how long they have to wait
    public String getWaitTime() {
        return waitTime / MINUTES + ":" + ((waitTime % MINUTES < 10) ? (waitTime % MINUTES) + "0" : (waitTime % MINUTES));
    }

    // Check if the wait time is up
    // If the wait time is 0 or less, the user can try again
    public boolean isTimeUp() {
        return waitTime <= 0;
    }
}
