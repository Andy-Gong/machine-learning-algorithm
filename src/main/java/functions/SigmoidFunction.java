package functions;

public class SigmoidFunction {
    public static double value(double x) {
        return 1.0 / (1.0 + (Math.exp(-x)));
    }
}
