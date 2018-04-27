package algorithms.BPNN;


public class Training {

    public static void train(NeuralNetwork network, double inputs[][], double expectedOutputs[]) {
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < network.getInput().getNeurons().size(); j++) {
                network.getInput().getNeurons().get(j).setOutput(inputs[i][j]);
            }
            double output = network.getOutput().getNeurons().get(0).getOutput();
            // calculate offset
            double offset = expectedOutputs[i] - output;
            // reset output layer weight
            network.getOutput().getNeurons().forEach(
                    neuron -> {
                        double derivative = output * (1 - output) * offset;
                        neuron.setDerivative(derivative);
                        neuron.getInConnections().forEach(connection -> {
                            connection.setWeight(connection.getWeight()
                                    + (network.getRateOfEvalution() * connection.getConnected().getOutput() * derivative));
                        });
                        neuron.setBias(neuron.getBias() + network.getRateOfEvalution() * (-1) * derivative);
                    });
            network.getHidden().forEach(
                    hiddenLayer -> {
                        hiddenLayer.getNeurons().forEach(
                                hiddenNeuron -> {
                                    hiddenNeuron.getInConnections().forEach(
                                            connection -> {
                                                hiddenNeuron.setDerivative(hiddenNeuron.getOutput()
                                                        * (1 - hiddenNeuron.getOutput())
                                                        * hiddenNeuron.getOutConnections().get(0).getConnected().getDerivative()
                                                        * hiddenNeuron.getOutConnections().stream().filter(
                                                                conn -> conn.getConnected().equals(hiddenNeuron.getOutConnections().get(0).getConnected()))
                                                                .findFirst().get().getWeight());
                                                connection.setWeight(connection.getWeight()
                                                        + (network.getRateOfEvalution() * connection.getConnected().getOutput() * hiddenNeuron
                                                                .getDerivative()));
                                            });
                                    hiddenNeuron.setBias(hiddenNeuron.getBias() + network.getRateOfEvalution() * (-1)
                                            * hiddenNeuron.getDerivative());
                                });
                    });
        }
    }
}
