package algorithms.HopfieldNN;

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
 * In this example, the network has 4 nodes.
 *
 */
public class HopfieldNN {

    // wij, the weights of i and j node.
    public static void main(String[] args) {
        // training weights of network, stable elements are two, [1,1,1,1] and [-1,-1,-1,-1]
        Matrix y1 = new Matrix(new int[] {1, 1, 1, 1});
        Matrix y2 = new Matrix(new int[] {-1, -1, -1, -1});
        // calculate weights of network
        Matrix identity = Matrix.getIdentityMetrix(4);
        Matrix weight = ((y1.multiply(y1.transpose())).add(y2.multiply(y2.transpose()))).sub(identity.multiply(2));
        int[][] w = weight.getMatrix();
        Neuron input0 = new Neuron();
        Neuron input1 = new Neuron();
        Neuron input2 = new Neuron();
        Neuron input3 = new Neuron();
        Neuron n0 = new Neuron();
        Neuron n1 = new Neuron();
        Neuron n2 = new Neuron();
        Neuron n3 = new Neuron();
        input0.setOutConnections(Arrays.asList(new Connection(w[0][0], n0), new Connection(w[1][0], n1), new Connection(w[2][0], n2), new Connection(w[3][0],
                n3)));
        input1.setOutConnections(Arrays.asList(new Connection(w[0][1], n0), new Connection(w[1][1], n1), new Connection(w[2][1], n2), new Connection(w[3][1],
                n3)));
        input2.setOutConnections(Arrays.asList(new Connection(w[0][2], n0), new Connection(w[1][2], n1), new Connection(w[2][2], n2), new Connection(w[3][2],
                n3)));
        input3.setOutConnections(Arrays.asList(new Connection(w[0][3], n0), new Connection(w[1][3], n1), new Connection(w[2][3], n2), new Connection(w[3][3],
                n3)));
        n0.setInConnections(Arrays.asList(new Connection(w[0][0], input0), new Connection(w[1][0], input1), new Connection(w[2][0], input2), new Connection(
                w[3][0], input3)));
        n0.setFunction(new SignFunction());
        n1.setInConnections(Arrays.asList(new Connection(w[0][1], input0), new Connection(w[1][1], input1), new Connection(w[2][1], input2), new Connection(
                w[3][1], input3)));
        n1.setFunction(new SignFunction());
        n2.setInConnections(Arrays.asList(new Connection(w[0][2], input0), new Connection(w[1][2], input1), new Connection(w[2][2], input2), new Connection(
                w[3][2], input3)));
        n2.setFunction(new SignFunction());
        n3.setInConnections(Arrays.asList(new Connection(w[0][3], input0), new Connection(w[1][3], input1), new Connection(w[2][3], input2), new Connection(
                w[3][3], input3)));
        n3.setFunction(new SignFunction());
        Layer inputLayer = new Layer(Arrays.asList(input0, input1, input2, input3));
        Layer outputLayer = new Layer(Arrays.asList(n0, n1, n2, n3));
        NeuralNetwork network = new NeuralNetwork(inputLayer, null, outputLayer, 0);
        // Verify stable node [1,1,1,1]
        input0.setOutput(1);
        input1.setOutput(1);
        input2.setOutput(1);
        input3.setOutput(1);
        input0.setBias(0);
        input1.setBias(0);
        input2.setBias(0);
        input3.setBias(0);
        Assert.assertEquals(1.0f, n0.getOutput(), 0);
        Assert.assertEquals(1.0f, n1.getOutput(), 0);
        Assert.assertEquals(1.0f, n2.getOutput(), 0);
        Assert.assertEquals(1.0f, n3.getOutput(), 0);
        // Verify stable node [-1,-1,-1,-1]
        input0.setOutput(-1);
        input1.setOutput(-1);
        input2.setOutput(-1);
        input3.setOutput(-1);
        input0.setBias(0);
        input1.setBias(0);
        input2.setBias(0);
        input3.setBias(0);
        Assert.assertEquals(-1.0f, n0.getOutput(), 0);
        Assert.assertEquals(-1.0f, n1.getOutput(), 0);
        Assert.assertEquals(-1.0f, n2.getOutput(), 0);
        Assert.assertEquals(-1.0f, n3.getOutput(), 0);

        // train other elements
        Train train = new HopfieldTraining();
        Matrix inputs = new Matrix(new int[][] { {-1, -1, -1, -0}, {1, 1, 1, -0}, {1, 1, -1, 1}, {-1, -0, -1, -1}, {-1, -1, 1, 1}});
        Matrix output = train.train(network, inputs, null);
        output.output();
    }
}
