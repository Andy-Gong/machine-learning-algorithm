package algorithms.BPNN;

import commons.Matrix;

import algorithms.Train;
import module.NeuralNetwork;


public class BPNNTraining implements Train {

    /*
     * (non-Javadoc)
     * 
     * @see algorithms.BPNN.Train#train(module.NeuralNetwork, double[][], double[])
     */
    @Override
    public Matrix train(NeuralNetwork network, Matrix inputs, Matrix output) {
        for (int i = 0; i < inputs.getMatrix().length; i++) {
            for (int j = 0; j < network.getInput().getNeurons().size(); j++) {
                network.getInput().getNeurons().get(j).setOutput(inputs.getMatrix()[i][j]);
            }
            double outputValue = network.getOutput().getNeurons().get(0).getOutput();
            // calculate offset
            double offset = output.getMatrix()[i][0] - outputValue;
            // reset output layer weight
            network.getOutput().getNeurons().forEach(
                    neuron -> {
                        double derivative = outputValue * (1 - outputValue) * offset;
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
        return null;
    }
}
