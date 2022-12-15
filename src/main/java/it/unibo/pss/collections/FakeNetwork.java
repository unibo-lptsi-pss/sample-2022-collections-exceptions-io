package it.unibo.pss.collections;

import java.io.IOException;

class FakeNetwork {

    static String connect() throws IOException {
        if (Math.random() < 0.5) {
            throw new IOException();
        }
        return "CONNECTED!";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Attempt number " + (i + 1) + ": " + connect());
            } catch (IOException e) {
                System.out.println("Connection failed! Retry!");
                i--;
            }
        }
    }

}