package algorithms;

import commons.Matrix;

import module.NeuralNetwork;



public interface Train {

    public abstract Matrix train(NeuralNetwork network, Matrix inputs, Matrix expectedOutput);

}
