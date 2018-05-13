package module;

import java.util.List;

public class NeuralNetwork {

    private Layer input;
    private List<Layer> hidden;
    private Layer output;
    private double rateOfEvalution;
    private double rateOfForget;
    private double threshold;

    public NeuralNetwork(Layer input, List<Layer> hidden, Layer output, double rateOfEvalution) {
        this.input = input;
        this.hidden = hidden;
        this.output = output;
        this.setRateOfEvalution(rateOfEvalution);
    }

    public NeuralNetwork(Layer input, List<Layer> hidden, Layer output, double rateOfEvalution, double rateOfForget, double threshold) {
        this(input, hidden, output, rateOfEvalution);
        this.rateOfForget = rateOfForget;
        this.setThreshold(threshold);
    }

    public List<Layer> getHidden() {
        return hidden;
    }

    public void setHidden(List<Layer> hidden) {
        this.hidden = hidden;
    }

    public Layer getOutput() {
        return output;
    }

    public void setOutput(Layer output) {
        this.output = output;
    }

    public Layer getInput() {
        return input;
    }

    public void setInput(Layer input) {
        this.input = input;
    }

    public double getRateOfEvalution() {
        return rateOfEvalution;
    }

    public void setRateOfEvalution(double rateOfEvalution) {
        this.rateOfEvalution = rateOfEvalution;
    }

    public double getRateOfForget() {
        return rateOfForget;
    }

    public void setRateOfForget(double rateOfForget) {
        this.rateOfForget = rateOfForget;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
