package module;

import commons.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private List<Connection> inConnections = new ArrayList<Connection>();
    private List<Connection> outConnections = new ArrayList<Connection>();
    private double output;
    private double bias = -1;
    private Function function;
    private double derivative;

    public Neuron(List<Connection> inConnections, List<Connection> outConnections, double bias, Function function, double output) {
        this.outConnections = outConnections;
        this.inConnections = inConnections;
        this.bias = bias;
        this.function = function;
        this.output = output;
    }

    public Neuron() {

    }

    public void setOutput(double output) {
        this.output = output;
    }

    public List<Connection> getInConnections() {
        return inConnections;
    }

    public void setInConnections(List<Connection> inConnections) {
        this.inConnections = inConnections;
    }

    public double getOutput() {
        if (inConnections == null || inConnections.isEmpty()) {
            return output;
        } else {
            return function.value(inConnections.stream()
                    .mapToDouble(connection -> Double.valueOf(connection.getWeight() * connection.getConnected().getOutput())).sum()
                    - this.bias);
        }
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<Connection> getOutConnections() {
        return outConnections;
    }

    public void setOutConnections(List<Connection> outConnections) {
        this.outConnections = outConnections;
    }

    public double getDerivative() {
        return derivative;
    }

    public void setDerivative(double derivative) {
        this.derivative = derivative;
    }
}
