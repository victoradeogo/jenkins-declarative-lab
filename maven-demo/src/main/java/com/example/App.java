package com.example;

public class App {

    public String getGreeting() {
        return "Hello from Maven and Jenkins!";
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
    }
}
