# machine-learning-algorithm
It includes a lot of examples of machine learning algorithms during my learning road.

#### BackPropagation NeuralNetwork

   
#### Hopfield NeuralNetwork
#### Bidirectional Associative Memory NeuralNetwork
##### Summary
1. A bidirectional associative memory stores a set of pattern associations by summing bipolar correlation matrices (an n by m outer product matrix for each pattern to be stored).
2. The architecture of the net consists of two layers of neurons, connected by directional weighted connection paths.
3. The net iterates, sending signals back and forth between the two layers until all neurons reach equilibrium (i.e., until each neuron's activation remains constant for several steps). 
4. Because the weights are bidirectional and the algorithm alternates between updating the activations for each layer, we shall refer to the layers as the X-layer and the Y-layer (rather than the input and output layers).

![Alt text](https://github.com/Andy-Gong/machine-learning-algorithm/blob/master/src/main/resource/BAMNN/BAMNN.png)

##### Training steps
1. Initialize weights to store a set of memory points;
```
       W = Y*X†, X† is transposition of X
```
2. For each testing input, do step 3-5;
3. Present input value: Xi to X layer, then caculate Y,
```
      Yi = sign(WXi)
```
4. Present input value: Yi to Y layer, then caculate X(i+1),
```
      X(i+1) = sign(W†Yi),W† is transposition of W
```
5. When X(i+1) = Xi, output of current input is stable.

##### Example
In the example, W is 3 X 6, initialize 4 memory points,
* Memory points input of Neural network:
```
1	1	-1	-1	
1	1	-1	-1	
1	-1	-1	1	
1	-1	-1	1	
1	1	-1	-1	
1	1	-1	-1

```
* Memory points output of Neural network:
```
1	1	-1	-1
1	-1	-1	1
1	1	-1	-1

```
* Weights of Neural network:
```
4	4	0	0	4	4
0	0	4	4	0	0
4	4	0	0	4	4
```
* Weights transposition of Neural network:
```
4	0	4
4	0	4
0	4	0
0	4	0
4	0	4
4	0	4
```
* Testing input of Neural network:
```
1	1	-1	-1	1	1	1	0	0	-1	
1	1	-1	-1	1	1	-1	0	0	-1	
1	-1	1	-1	1	1	1	0	1	-1	
1	-1	1	-1	1	1	-1	0	1	-1	
1	1	-1	-1	1	-1	1	0	-1	1	
1	1	-1	-1	-1	-1	-1	0	1	1	
```
* Testing output of Neural network:
```
1	1	-1	-1	1	0	0	0	0	0	
1	-1	1	-1	1	1	0	0	1	-1	
1	1	-1	-1	1	0	0	0	0	0
```
