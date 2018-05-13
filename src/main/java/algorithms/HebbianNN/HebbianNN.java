package algorithms.HebbianNN;

import algorithms.Train;
import commons.Matrix;
import commons.functions.impl.LineFunction;
import module.Connection;
import module.Layer;
import module.NeuralNetwork;
import module.Neuron;

import java.util.Arrays;

/**
 * Hebbian theory is 'Cells that fire together wire together', which means that if two neurons are
 * triggered meanwhile the weight of them is stronger.
 * 
 * It is an unsupervised algorithm.
 * deltaWij = ay(j)*x(i) - qy(j)Wij
 * 
 *
 */
public class HebbianNN {

    public static void main(String[] args) {
        double a = 0.1; // rate of training
        double f = 0.02;// rate of forget
        double t = 0.001; // threshold
        Matrix inital = Matrix.getIdentityMetrix(5);
        System.out.println("Inital weights: ");
        inital.output();
        Matrix input = new Matrix(new double[][] {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1}}).transpose();
        System.out.println("Input values: ");
        input.output();
        NeuralNetwork network = initNN(inital, a, f, t);
        Train train = new HebbianTraining();
        train.train(network, input, null);
    }

    public static NeuralNetwork initNN(Matrix inital, double a, double f, double t) {
        double[][] w = inital.getMatrix();
        Neuron input0 = new Neuron();
        Neuron input1 = new Neuron();
        Neuron input2 = new Neuron();
        Neuron input3 = new Neuron();
        Neuron input4 = new Neuron();

        Neuron o0 = new Neuron();
        Neuron o1 = new Neuron();
        Neuron o2 = new Neuron();
        Neuron o3 = new Neuron();
        Neuron o4 = new Neuron();

        input0.setOutConnections(Arrays.asList(new Connection((double) w[0][0], o0), new
                Connection((double) w[1][0], o1), new
                Connection((double) w[2][0], o2), new
                Connection((double) w[3][0], o3), new
                Connection((double) w[4][0], o4)));
        input1.setOutConnections(Arrays.asList(new Connection((double) w[0][1], o0), new
                Connection((double) w[1][1], o1), new
                Connection((double) w[2][1], o2), new
                Connection((double) w[3][1], o3), new
                Connection((double) w[4][1], o4)));
        input2.setOutConnections(Arrays.asList(new Connection((double) w[0][2], o0), new
                Connection((double) w[1][2], o1), new
                Connection((double) w[2][2], o2), new
                Connection((double) w[3][2], o3), new
                Connection((double) w[4][2], o4)));
        input3.setOutConnections(Arrays.asList(new Connection((double) w[0][3], o0), new
                Connection((double) w[1][3], o1), new
                Connection((double) w[2][3], o2), new
                Connection((double) w[3][3], o3), new
                Connection((double) w[4][3], o4)));
        input4.setOutConnections(Arrays.asList(new Connection((double) w[0][4], o0), new
                Connection((double) w[1][4], o1), new
                Connection((double) w[2][4], o2), new
                Connection((double) w[3][4], o3), new
                Connection((double) w[4][4], o4)));
        o0.setInConnections(Arrays.asList(new Connection((double) w[0][0], input0), new
                Connection((double) w[0][1], input1), new Connection((double) w[0][2], input2), new Connection(
                        (double) w[0][3], input3), new Connection(
                        (double) w[0][4], input4)));
        o0.setFunction(new LineFunction());
        o1.setInConnections(Arrays.asList(new Connection((double) w[1][0], input0), new
                Connection((double) w[1][1], input1), new Connection((double) w[1][2], input2), new Connection(
                        (double) w[1][3], input3), new Connection(
                        (double) w[1][4], input4)));
        o1.setFunction(new LineFunction());
        o2.setInConnections(Arrays.asList(new Connection((double) w[2][0], input0), new
                Connection((double) w[2][1], input1), new Connection((double) w[2][2], input2), new Connection(
                        (double) w[2][3], input3), new Connection(
                        (double) w[2][4], input4)));
        o2.setFunction(new LineFunction());
        o3.setInConnections(Arrays.asList(new Connection((double) w[3][0], input0), new
                Connection((double) w[3][1], input1), new Connection((double) w[3][2], input2), new Connection(
                        (double) w[3][3], input3), new Connection(
                        (double) w[3][4], input4)));
        o3.setFunction(new LineFunction());
        o4.setInConnections(Arrays.asList(new Connection((double) w[4][0], input0), new
                Connection((double) w[4][1], input1), new Connection((double) w[4][2], input2), new Connection(
                        (double) w[4][3], input3), new Connection(
                        (double) w[4][4], input4)));
        o4.setFunction(new LineFunction());

        Layer inputLayer = new Layer(Arrays.asList(input0, input1, input2, input3, input4));
        Layer outputLayer = new Layer(Arrays.asList(o0, o1, o2, o3, o4));
        NeuralNetwork network = new NeuralNetwork(inputLayer, null, outputLayer, a, f, t);
        return network;
    }
}
