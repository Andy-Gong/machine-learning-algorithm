package algorithms.HopfieldNN;

import algorithms.Train;
import commons.Matrix;
import module.NeuralNetwork;

public class HopfieldTraining implements Train {

    @Override
    public Matrix train(NeuralNetwork network, Matrix inputs, Matrix expectedOutput) {
        Matrix output = new Matrix(inputs.getMatrix().length, inputs.getMatrix()[0].length);
        for (int i = 0; i < inputs.getMatrix().length; i++) {
            Matrix input = new Matrix(1, inputs.getMatrix()[0].length);
            for (int tmp = 0; tmp < inputs.getMatrix()[i].length; tmp++) {
                input.setValue(0, tmp, inputs.getMatrix()[i][tmp]);
            }
            Matrix out = new Matrix(1, input.getMatrix()[0].length);
            while (true) {
                // initial input
                for (int j = 0; j < input.getMatrix()[0].length; j++) {
                    network.getInput().getNeurons().get(j).setOutput(input.getMatrix()[0][j]);
                }
                // get output
                for (int k = 0; k < out.getMatrix()[0].length; k++) {
                    out.setValue(0, k, (int) network.getOutput().getNeurons().get(k).getOutput());
                }
                if (input.equals(out)) {
                    break;
                } else {
                    input = out;
                }
            }
            for (int l = 0; l < output.getMatrix()[0].length; l++) {
                output.setValue(i, l, out.getMatrix()[0][l]);
            }
        }
        return output;
    }
}
