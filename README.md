# machine-learning-algorithm
It includes a lot of examples of machine learning algorithms during my learning road.

#### BackPropagation NeuralNetwork
1. We use this algorithm to resolve Exclusive-OR problem.
2. In the example, NeuralNetwork includes three layers: input layer, hidden layer and output layer.
   ![Alt text](https://github.com/Andy-Gong/machine-learning-algorithm/blob/master/src/main/resource/BPNN/BPNN.jpg)
3. In the training process, x1 and x2 have 4 training samples, such as [1,1], [1,0], [0,1], [0,0]. Training count is 1000 and rate is 0.7.
   Initial weights as below. FYI you can generate initial weights randomly.
   
   | Weight     | value    |
   | --------|---------|
   | w13  | 0.5   |
   | w14 | 0.4 |
   | w23 | 0.9 |
   | w24 | 1.0 |
   | w35 | -1.2 |
   | w45 |	1.1 |
4. Training results
   
   . weights
   
   | Weight     | value    |
   | --------|---------|
   | w13  | 2.905025894507316   |
   | w14 | 4.441900698328678 |
   | w23 | 2.9032881949656053 |
   | w24 | 4.434919722243642 |
   | w35 | -13.762748483725506 |
   | w45 |	12.860965658654974 |
   
   . output
   
   | Input(x1, x2)| Expexted result | Actual result |
   | -------------|-----------------|---------------|
   | [1,1]  | 0   | 0.02074452285884211    |
   | [1,0] | 1 | 0.9808479500651514   |
   | [0,1] | 1 | 0.9808201576391186   |
   | [0,0] | 0 | 0.019956923563609858    |
   
#### Hopfield NeuralNetwork
#### Bidirectional Associative Memory NeuralNetwork
1. A bidirectional associative memory stores a set of pattern associations by summing bipolar correlation matrices (an n by m outer product matrix for each pattern to be stored).
2. The architecture of the net consists of two layers of neurons, connected by directional weighted connection paths.
3. The net iterates, sending signals back and forth between the two layers until all neurons reach equilibrium (i.e., until each neuron's activation remains constant for several steps). 
4. Because the weights are bidirectional and the algorithm alternates between updating the activations for each layer, we shall refer to the layers as the X-layer and the Y-layer (rather than the input and output layers).

![Alt text](https://github.com/Andy-Gong/machine-learning-algorithm/blob/master/src/main/resource/BAMNN/BAMNN.png)

In the example, W is 3X6, 4 memory points,
Memory points input of Neural network:

1	1	-1	-1
1	1	-1	-1
1	-1	-1	1
1	-1	-1	1
1	1	-1	-1
1	1	-1	-1

Memory points output of Neural network:

1	1	-1	-1
1	-1	-1	1
1	1	-1	-1

Weights of Neural network:

4	4	0	0	4	4
0	0	4	4	0	0
4	4	0	0	4	4

Weights transposition of Neural network:
4	0	4
4	0	4
0	4	0
0	4	0
4	0	4
4	0	4

