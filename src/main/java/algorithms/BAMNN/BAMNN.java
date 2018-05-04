package algorithms.BAMNN;

import algorithms.Train;
import commons.Matrix;
import commons.functions.impl.SignFunction;
import module.Connection;
import module.Layer;
import module.NeuralNetwork;
import module.Neuron;
import org.junit.Assert;

import java.util.Arrays;

/**
 * In BAM (bidirectional associative memory) neural network, it has 3 layers:
 * InputLayer (Xn), OutputLayer (Yn), FeedbackLayer (X(n+1)).
 * According to BAM algorithm.
 * W = YX'
 * Yn = sign(WXn)
 * X(n+1) = sign(W'Yn)
 *
 * Note: ' means Matrix transposition
 */
public class BAMNN {

    public static void main(String[] args) {
        Matrix inputX = new Matrix(new int[][] { {1, 1, 1, 1, 1, 1}, {1, 1, -1, -1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, 1, 1, -1, -1}});
        Matrix outputY = new Matrix(new int[][] { {1, 1, 1}, {1, -1, 1}, {-1, -1, -1}, {-1, 1, -1}});
        System.out.println("\nMemory points input of Neural network: ");
        inputX.transpose().output();
        System.out.println("\nMemory points output of Neural network: ");
        outputY.transpose().output();
        Matrix weight = new Matrix(3, 6);
        for (int i = 0; i < 4; i++) {
            Matrix inputTmp = new Matrix(1, 6);
            for (int j = 0; j < 6; j++) {
                inputTmp.setValue(0, j, inputX.getMatrix()[i][j]);
            }
            Matrix outputTmp = new Matrix(1, 3);
            for (int k = 0; k < 3; k++) {
                outputTmp.setValue(0, k, outputY.getMatrix()[i][k]);
            }
            Matrix tmp = outputTmp.transpose().multiply(inputTmp);
            weight = weight.add(tmp);
        }
        System.out.println("\nWeights of Neural network: ");
        weight.output();
        System.out.println("\nWeights transposition of Neural network: ");
        weight.transpose().output();

        int[][] w = weight.getMatrix();
        Neuron input0 = new Neuron();
        Neuron input1 = new Neuron();
        Neuron input2 = new Neuron();
        Neuron input3 = new Neuron();
        Neuron input4 = new Neuron();
        Neuron input5 = new Neuron();

        Neuron n0 = new Neuron();
        Neuron n1 = new Neuron();
        Neuron n2 = new Neuron();

        Neuron _input0 = new Neuron();
        Neuron _input1 = new Neuron();
        Neuron _input2 = new Neuron();
        Neuron _input3 = new Neuron();
        Neuron _input4 = new Neuron();
        Neuron _input5 = new Neuron();

        input0.setOutConnections(Arrays.asList(new Connection(w[0][0], n0), new
                Connection(w[1][0], n1), new
                Connection(w[2][0], n2)));
        input1.setOutConnections(Arrays.asList(new Connection(w[0][1], n0), new
                Connection(w[1][1], n1), new
                Connection(w[2][1], n2)));
        input2.setOutConnections(Arrays.asList(new Connection(w[0][2], n0), new
                Connection(w[1][2], n1), new
                Connection(w[2][2], n2)));
        input3.setOutConnections(Arrays.asList(new Connection(w[0][3], n0), new
                Connection(w[1][3], n1), new
                Connection(w[2][3], n2)));
        input4.setOutConnections(Arrays.asList(new Connection(w[0][4], n0), new
                Connection(w[1][4], n1), new
                Connection(w[2][4], n2)));
        input5.setOutConnections(Arrays.asList(new Connection(w[0][5], n0), new
                Connection(w[1][5], n1), new
                Connection(w[2][5], n2)));
        n0.setInConnections(Arrays.asList(new Connection(w[0][0], input0), new
                Connection(w[0][1], input1), new Connection(w[0][2], input2), new Connection(
                        w[0][3], input3), new Connection(
                        w[0][4], input4), new Connection(
                        w[0][5], input5)));
        n0.setOutConnections(Arrays.asList(new Connection(w[0][0], _input0), new
                Connection(w[0][1], _input1), new Connection(w[0][2], _input2), new Connection(
                        w[0][3], _input3), new Connection(
                        w[0][4], _input4), new Connection(
                        w[0][5], _input5)));
        n0.setFunction(new SignFunction());
        n1.setInConnections(Arrays.asList(new Connection(w[1][0], input0), new
                Connection(w[1][1], input1), new Connection(w[1][2], input2), new Connection(
                        w[1][3], input3), new Connection(
                        w[1][4], input4), new Connection(
                        w[1][5], input5)));
        n1.setOutConnections(Arrays.asList(new Connection(w[1][0], _input0), new
                Connection(w[1][1], _input1), new Connection(w[1][2], _input2), new Connection(
                        w[1][3], _input3), new Connection(
                        w[1][4], _input4), new Connection(
                        w[1][5], _input5)));
        n1.setFunction(new SignFunction());
        n2.setInConnections(Arrays.asList(new Connection(w[2][0], input0), new
                Connection(w[2][1], input1), new Connection(w[2][2], input2), new Connection(
                        w[2][3], input3), new Connection(
                        w[2][4], input4), new Connection(
                        w[2][5], input5)));
        n2.setOutConnections(Arrays.asList(new Connection(w[2][0], _input0), new
                Connection(w[2][1], _input1), new Connection(w[2][2], _input2), new Connection(
                        w[2][3], _input3), new Connection(
                        w[2][4], _input4), new Connection(
                        w[2][5], _input5)));
        n2.setFunction(new SignFunction());

        _input0.setInConnections(Arrays.asList(new Connection(w[0][0], n0), new
                Connection(w[1][0], n1), new
                Connection(w[2][0], n2)));
        _input0.setFunction(new SignFunction());
        _input1.setInConnections(Arrays.asList(new Connection(w[0][1], n0), new
                Connection(w[1][1], n1), new
                Connection(w[2][1], n2)));
        _input1.setFunction(new SignFunction());
        _input2.setInConnections(Arrays.asList(new Connection(w[0][2], n0), new
                Connection(w[1][2], n1), new
                Connection(w[2][2], n2)));
        _input2.setFunction(new SignFunction());
        _input3.setInConnections(Arrays.asList(new Connection(w[0][3], n0), new
                Connection(w[1][3], n1), new
                Connection(w[2][3], n2)));
        _input3.setFunction(new SignFunction());
        _input4.setInConnections(Arrays.asList(new Connection(w[0][4], n0), new
                Connection(w[1][4], n1), new
                Connection(w[2][4], n2)));
        _input4.setFunction(new SignFunction());
        _input5.setInConnections(Arrays.asList(new Connection(w[0][5], n0), new
                Connection(w[1][5], n1), new
                Connection(w[2][5], n2)));
        _input5.setFunction(new SignFunction());

        // Input layer
        Layer inputLayer = new Layer(Arrays.asList(input0, input1, input2, input3, input4, input5));
        // Output layer
        Layer outputLayer = new Layer(Arrays.asList(n0, n1, n2));
        // Feedback layer
        Layer feedbackLayer = new Layer(Arrays.asList(_input0, _input1, _input2, _input3, _input4, _input5));

        NeuralNetwork network = new NeuralNetwork(inputLayer, Arrays.asList(outputLayer), feedbackLayer, 0);
        verify(input0, input1, input2, input3, input4, input5, n0, n1, n2, _input0, _input1, _input2, _input3, _input4, _input5);

        // train other elements
        Train train = new BAMTraining();
        Matrix inputs =
                new Matrix(new int[][] { {1, 1, -1, -1, 1, 1, 1, 0, 0, -1}, {1, 1, -1, -1, 1, 1, -1, 0, 0, -1}, {1, -1, 1, -1, 1, 1, 1, 0, 1, -1},
                        {1, -1, 1, -1, 1, 1, -1, 0, 1, -1},
                        {1, 1, -1, -1, 1, -1, 1, 0, -1, 1},
                        {1, 1, -1, -1, -1, -1, -1, 0, 1, 1}});
        System.out.println("\nInput values:");
        inputs.output();
        Matrix output = train.train(network, inputs, null);
        System.out.println("\nOutput values:");
        output.output();
    }

    private static void verify(Neuron input0, Neuron input1, Neuron input2, Neuron input3, Neuron input4, Neuron input5, Neuron n0, Neuron n1, Neuron n2,
            Neuron _input0, Neuron _input1, Neuron _input2, Neuron _input3, Neuron _input4, Neuron _input5) {
        // Verify stable node [1,1,1,1,1,1]
        input0.setOutput(1);
        input1.setOutput(1);
        input2.setOutput(1);
        input3.setOutput(1);
        input4.setOutput(1);
        input5.setOutput(1);
        Assert.assertEquals(1.0f, n0.getOutput(), 0);
        Assert.assertEquals(1.0f, n1.getOutput(), 0);
        Assert.assertEquals(1.0f, n2.getOutput(), 0);
        Assert.assertEquals(1.0f, _input0.getOutput(), 0);
        Assert.assertEquals(1.0f, _input1.getOutput(), 0);
        Assert.assertEquals(1.0f, _input2.getOutput(), 0);
        Assert.assertEquals(1.0f, _input3.getOutput(), 0);
        Assert.assertEquals(1.0f, _input4.getOutput(), 0);
        Assert.assertEquals(1.0f, _input5.getOutput(), 0);

        // Verify stable node [-1,-1,-1,-1,-1,-1]
        input0.setOutput(-1);
        input1.setOutput(-1);
        input2.setOutput(-1);
        input3.setOutput(-1);
        input4.setOutput(-1);
        input5.setOutput(-1);
        Assert.assertEquals(-1.0f, n0.getOutput(), 0);
        Assert.assertEquals(-1.0f, n1.getOutput(), 0);
        Assert.assertEquals(-1.0f, n2.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input0.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input1.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input2.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input3.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input4.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input5.getOutput(), 0);

        // Verify stable node [1,1,-1,-1,1,1]
        input0.setOutput(1);
        input1.setOutput(1);
        input2.setOutput(-1);
        input3.setOutput(-1);
        input4.setOutput(1);
        input5.setOutput(1);
        Assert.assertEquals(1.0f, n0.getOutput(), 0);
        Assert.assertEquals(-1.0f, n1.getOutput(), 0);
        Assert.assertEquals(1.0f, n2.getOutput(), 0);
        Assert.assertEquals(1.0f, _input0.getOutput(), 0);
        Assert.assertEquals(1.0f, _input1.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input2.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input3.getOutput(), 0);
        Assert.assertEquals(1.0f, _input4.getOutput(), 0);
        Assert.assertEquals(1.0f, _input5.getOutput(), 0);

        // Verify stable node [-1,-1,1,1,-1,-1]
        input0.setOutput(-1);
        input1.setOutput(-1);
        input2.setOutput(1);
        input3.setOutput(1);
        input4.setOutput(-1);
        input5.setOutput(-1);
        Assert.assertEquals(-1.0f, n0.getOutput(), 0);
        Assert.assertEquals(1.0f, n1.getOutput(), 0);
        Assert.assertEquals(-1.0f, n2.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input0.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input1.getOutput(), 0);
        Assert.assertEquals(1.0f, _input2.getOutput(), 0);
        Assert.assertEquals(1.0f, _input3.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input4.getOutput(), 0);
        Assert.assertEquals(-1.0f, _input5.getOutput(), 0);
    }
}
