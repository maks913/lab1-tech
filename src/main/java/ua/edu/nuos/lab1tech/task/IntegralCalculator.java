package ua.edu.nuos.lab1tech.task;

public class IntegralCalculator {
    private double a;
    private double b;
    private int n;
    private Function f;

    public IntegralCalculator(double a, double b, int n, Function f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    public double calculate() {
        double h = (b - a) / n;
        double s = 0.5 * (f.calculate(a) + f.calculate(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            s += f.calculate(x);
        }

        return s * h;
    }
}
