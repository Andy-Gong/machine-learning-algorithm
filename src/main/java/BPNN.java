package main.java;

public class BPNN {
    private int x1;
    private int x2;
    private double w13;
    private double w23;
    private double w14;
    private double w24;
    private double w35;
    private double w45;
    private double threshold3;
    private double threshold4;
    private double threshold5;
    private double variance;
    private double y3;
    private double y4;
    private double y5;

    public static void main(String[] str) {}

    public void training() {
        double sum1 = this.x1 * this.w13 + this.x2 * this.w23;
        y3 = (double) 1 / (1 + Math.exp(-(sum1 - threshold3)));
        System.out.println(y3);
    }

    private void init() {
        x1 = 1;
        x2 = 1;
        w13 = 0.4;
        w23 = 0.5;
        w14 = 0.7;
        w24 = 0.8;
        w35 = 0.9;
        w45 = 0.1;
        threshold3 = 0.9;
        threshold4 = 0.1;
        threshold5 = 0.8;
        variance = 0.001;
    }
}
