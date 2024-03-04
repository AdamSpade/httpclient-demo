package com.example.httpclientdemo;

import com.example.httpclientdemo.tasks.SdrTask;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpClientDemoApplication {

    public static void main(String[] args)  {
        SdrTask sdrTask = new SdrTask();
        Thread sdrThread = new Thread(sdrTask);
        sdrThread.start();
    }
}
