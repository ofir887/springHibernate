package com.example.springhibernate.springhibernate.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineRunner{

    public static void runDockerComposeUp(String command, CommandLineListener commandLineListener) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        new Thread(() -> {
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            try {
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                    if (line.contains("port: 3306  MySQL Community Server - GPL")) {
                        commandLineListener.onCommandFinished();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
