package algorithms.BAMNN;

import algorithms.Train;
import commons.Matrix;
import module.NeuralNetwork;

public class BAMTraining implements Train {

    @Override
    public Matrix train(NeuralNetwork network, Matrix inputs, Matrix expectedOutput) {
        Matrix output = new Matrix(network.getHidden().get(0).getNeurons().size(), inputs.getMatrix()[0].length);
        for (int i = 0; i < inputs.getMatrix()[0].length; i++) {
            Matrix input = new Matrix(inputs.getMatrix().length, 1);
            for (int tmp = 0; tmp < inputs.getMatrix().length; tmp++) {
                input.setValue(tmp, 0, inputs.getMatrix()[tmp][i]);
            }
            Matrix out = new Matrix(network.getHidden().get(0).getNeurons().size(), 1);
            while (true) {
                // initial input
                for (int j = 0; j < input.getMatrix().length; j++) {
                    network.getInput().getNeurons().get(j).setOutput(input.getMatrix()[j][0]);
                }
                // get output
                for (int k = 0; k < out.getMatrix().length; k++) {
                    out.setValue(k, 0, (int) network.getHidden().get(0).getNeurons().get(k).getOutput());
                }

                // get feedback
                Matrix feedback = new Matrix(input.getMatrix().length, 1);
                for (int l = 0; l < input.getMatrix().length; l++) {
                    feedback.setValue(l, 0, (int) network.getOutput().getNeurons().get(l).getOutput());
                }
                if (input.equals(feedback)) {
                    break;
                } else {
                    input = feedback;
                }
            }
            for (int m = 0; m < output.getMatrix().length; m++) {
                output.setValue(m, i, out.getMatrix()[m][0]);
            }
        }
        return output;
    }
}
