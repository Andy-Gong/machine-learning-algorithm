package algorithms.HebbianNN;

import algorithms.Train;
import commons.Matrix;
import module.NeuralNetwork;

public class HebbianTraining implements Train {

    @Override
    public Matrix train(NeuralNetwork network, Matrix inputs, Matrix expectedOutput) {
        Matrix weight = new Matrix(network.getInput().getNeurons().size(), network.getOutput().getNeurons().size());
        Matrix deltaWeight = new Matrix(network.getInput().getNeurons().size(), network.getOutput().getNeurons().size());
        int count = 0;
        while (true) {
            ++count;
            System.out.println(String.format("========= Train %d times =========", count));
            Matrix output = new Matrix(network.getOutput().getNeurons().size(), inputs.getMatrix().length);
            for (int i = 0; i < inputs.getMatrix()[0].length; i++) {
                Matrix input = new Matrix(inputs.getMatrix()[i]);
                setInputValue(network, input);
                for (int j = 0; j < network.getOutput().getNeurons().size(); j++) {
                    output.getMatrix()[j][i] = network.getOutput().getNeurons().get(j).getOutput();
                }
            }
            System.out.println("Output value:");
            output.output();
            // delta weight = a y*x -f y w
            for (int i = 0; i < network.getInput().getNeurons().size(); i++) {
                for (int j = 0; j < network.getOutput().getNeurons().size(); j++) {
                    double current = network.getOutput().getNeurons().get(j).getInConnections().get(i).getWeight();
                    double delta =
                            network.getRateOfEvalution() * network.getInput().getNeurons().get(i).getOutput() * output.getMatrix()[i][j]
                                    - network.getRateOfForget() * output.getMatrix()[i][j]
                                    * network.getOutput().getNeurons().get(j).getInConnections().get(i).getWeight();
                    network.getOutput().getNeurons().get(j).getInConnections().get(i).setWeight(current + delta);
                    network.getInput().getNeurons().get(i).getOutConnections().get(j).setWeight(current + delta);
                    weight.setValue(i, j, current + delta);
                    deltaWeight.setValue(i, j, delta);
                }
            }
            System.out.println("Delta Weight:");
            deltaWeight.output();
            System.out.println("Weight:");
            weight.output();
            // calculate sum of square
            double sumOfSquare = 0;
            for (int i = 0; i < deltaWeight.getMatrix().length; i++) {
                for (int j = 0; j < deltaWeight.getMatrix()[0].length; j++) {
                    sumOfSquare = sumOfSquare + Math.sqrt(deltaWeight.getMatrix()[i][j]);
                }
            }
            if (sumOfSquare < network.getThreshold()) {
                break;
            }
            deltaWeight.clear();
        }
        return null;
    }

    private void setInputValue(NeuralNetwork network, Matrix input) {
        for (int i = 0; i < network.getInput().getNeurons().size(); i++) {
            network.getInput().getNeurons().get(i).setOutput(input.getMatrix()[i][0]);
        }
    }
}
