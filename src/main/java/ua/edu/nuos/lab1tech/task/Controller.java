package ua.edu.nuos.lab1tech.task;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private double totalSum = 0;
    private int finished = 0;

    @FXML
    private TextField intervals;
    @FXML
    private TextField threads;
    @FXML
    private Label resultLabel;

    @FXML
    private void calculate() {
        double a = 1.0;
        double b = 4.0;

        Function f = new Function();
        int n = Integer.parseInt(intervals.getText());
        int numberOfThreads = Integer.parseInt(threads.getText());

        long start = System.currentTimeMillis();
        double delta = (b - a) / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            double ai = a + i * delta;
            double bi = ai + delta;
            int ni = n / numberOfThreads;

            Thread.startVirtualThread(new RunnableIntegralCalculator(ai, bi, ni, f, this));
        }

        try {
            synchronized (this) {
                while (finished < numberOfThreads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        resultLabel.setText("Total time: " + (end - start) + "ms\n" + " Result: " + totalSum);
    }

    public synchronized void sendResult(double v) {
        totalSum += v;
        finished++;
        notify();
    }
}