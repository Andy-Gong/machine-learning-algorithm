package algorithms;

import functions.SigmoidFunction;
import org.junit.Test;

public class BPNN {
    // hidden layer weight
    private double w13;
    private double w23;
    private double w14;
    private double w24;
    // output layer weight
    private double w35;
    private double w45;
    // hidden layer threshold
    private double threshold3;
    private double threshold4;
    // output layer thresholdo
    private double threshold5;
    private double rateOfEvalution;
    private int count = 15000;

    final double inputs[][] = { {1, 1}, {1, 0}, {0, 1}, {0, 0}};
    final double expectedOutputs[] = {0, 1, 1, 0};

    @Test
    public void training() {
        this.init();
        while (count > 0) {
            for (int i = 0; i < inputs.length; i++) {
                trainingOneTIme(inputs[i][0], inputs[i][1], expectedOutputs[i]);
            }
            count--;
        }
        System.out.println("Trained module:");
        System.out.println("w13: " + w13 + "\n"
                + "w14: " + w14 + "\n"
                + "w23: " + w23 + "\n"
                + "w24: " + w24 + "\n"
                + "w35: " + w35 + "\n"
                + "w45: " + w45 + "\n");
        System.out.println("==========" + this.value(1, 1));
        System.out.println("==========" + this.value(0, 0));
        System.out.println("==========" + this.value(0, 1));
        System.out.println("==========" + this.value(1, 0));
    }

    private void trainingOneTIme(double x1, double x2, double expectResult) {
        double y3 = SigmoidFunction.value((x1 * this.w13 + x2 * this.w23) -
                threshold3);
        double y4 = SigmoidFunction.value((x1 * this.w14 + x2 * this.w24) -
                threshold4);

        double y5 = SigmoidFunction.value((y3 * this.w35 + y4 * this.w45) - threshold5);
        // calculate offset
        double offset = expectResult - y5;
        // calculate output layer delta weight
        double derivative5 = y5 * (1 - y5) * offset;
        double deltaW3 = rateOfEvalution * y3 * derivative5;
        double deltaW4 = rateOfEvalution * y4 * derivative5;
        double deltaT5 = rateOfEvalution * (-1) * derivative5;
        w35 = w35 + deltaW3;
        w45 = w45 + deltaW4;
        threshold5 = threshold5 + deltaT5;
        // calculate hidden layer delta weight
        double derivative3 = y3 * (1 - y3) * derivative5 * w35;
        double derivative4 = y4 * (1 - y4) * derivative5 * w45;
        double deltaW13 = rateOfEvalution * x1 * derivative3;
        double deltaW14 = rateOfEvalution * x1 * derivative4;
        double deltaW23 = rateOfEvalution * x2 * derivative3;
        double deltaW24 = rateOfEvalution * x2 * derivative4;
        double deltaT3 = rateOfEvalution * (-1) * derivative3;
        double deltaT4 = rateOfEvalution * (-1) * derivative4;

        w13 = w13 + deltaW13;
        w14 = w14 + deltaW14;
        w23 = w23 + deltaW23;
        w24 = w24 + deltaW24;
        threshold3 = threshold3 + deltaT3;
        threshold4 = threshold4 + deltaT4;
    }

    public double value(double v1, double v2) {
        double yTmp3 = SigmoidFunction.value((v1 * w13 + v2 * w23) - threshold3);
        double yTmp4 = SigmoidFunction.value((v1 * w14 + v2 * w24) - threshold4);
        return SigmoidFunction.value(yTmp3 * w35 + yTmp4 * w45 - threshold5);
    }

    private void init() {
        w13 = 1.8f;
        w23 = 2.4f;
        w14 = 0.6f;
        w24 = 1.1f;
        w35 = -1.6f;
        w45 = 1.8f;
        threshold3 = 0.8f;
        threshold4 = 0.1f;
        threshold5 = 0.3f;
        rateOfEvalution = 0.7f;
    }
}
