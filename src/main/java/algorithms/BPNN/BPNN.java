package algorithms.BPNN;

import functions.SigmoidFunction;

import java.util.Arrays;

public class BPNN {
    // hidden layer weight
    private static double w13 = 0.5;
    private static double w23 = 0.4;
    private static double w14 = 0.9;
    private static double w24 = 1.0;
    // output layer weight
    private static double w35 = -1.2;
    private static double w45 = 1.1;
    private static double rateOfEvalution = 0.7;
    private static int count = 10000;
    final static double inputs[][] = { {1, 1}, {1, 0}, {0, 1}, {0, 0}};
    final static double expectedOutputs[] = {0, 1, 1, 0};

    public static void main(String[] args) {
        NeuralNetwork network = init(rateOfEvalution);
        while (count > 0) {
            Training.train(network, inputs, expectedOutputs);
            count--;
        }

        for (int j = 0; j < 2; j++) {
            network.getInput().getNeurons().get(j).setOutput(inputs[0][j]);
        }
        System.out.println(network.getOutput().getNeurons().get(0).getOutput());
        for (int j = 0; j < 2; j++) {
            network.getInput().getNeurons().get(j).setOutput(inputs[1][j]);
        }
        System.out.println(network.getOutput().getNeurons().get(0).getOutput());
        for (int j = 0; j < 2; j++) {
            network.getInput().getNeurons().get(j).setOutput(inputs[2][j]);
        }
        System.out.println(network.getOutput().getNeurons().get(0).getOutput());
        for (int j = 0; j < 2; j++) {
            network.getInput().getNeurons().get(j).setOutput(inputs[3][j]);
        }
        System.out.println(network.getOutput().getNeurons().get(0).getOutput());
    }

    public static NeuralNetwork init(double rate) {
        // input layer
        Neuron input1 = new Neuron(null, null, 0, null, 1);
        Neuron input2 = new Neuron(null, null, 0, null, 1);
        Neuron out = new Neuron();
        Neuron hidder1 =
                new Neuron(Arrays.asList(new Connection(w13, input1), new Connection(w23, input2)), Arrays.asList(new Connection(w35, out)), 0.8,
                        new SigmoidFunction(), 0);
        Neuron hidder2 =
                new Neuron(Arrays.asList(new Connection(w14, input1), new Connection(w24, input2)), Arrays.asList(new Connection(w45, out)), -0.1,
                        new SigmoidFunction(), 0);

        input1.setOutConnections(Arrays.asList(new Connection(w13, hidder1), new Connection(w23, hidder2)));
        input2.setOutConnections(Arrays.asList(new Connection(w14, hidder1), new Connection(w24, hidder2)));

        out.setInConnections(Arrays.asList(new Connection(w35, hidder1), new Connection(w45, hidder2)));
        out.setFunction(new SigmoidFunction());
        out.setBias(0.3);

        Layer layer = new Layer(Arrays.asList(input1, input2));
        // hidden layer
        Layer hiddenLayer = new Layer(Arrays.asList(hidder1, hidder2));
        // output layer
        Layer outputLayer = new Layer(Arrays.asList(out));

        NeuralNetwork network = new NeuralNetwork(layer, Arrays.asList(hiddenLayer), outputLayer, rate);
        return network;
    }
}
