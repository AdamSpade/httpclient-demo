package com.example.httpclientdemo.tasks;

import static com.example.httpclientdemo.service.SdrService.getSdrRate;

public class SdrTask implements Runnable {

    @Override
    public void run() {
        getSdrRate();
    }
}
