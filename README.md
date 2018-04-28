# machine-learning-algorithm
It includes a lot of examples of machine learning algorithms during my learning road.

#### BackPropagation NeuralNetwork
1. We use this algorithm to resolve Exclusive-OR problem.
2. In the example, NeuralNetwork includes three layers: input layer, hidden layer and output layer.
   ![Alt text](https://github.com/Andy-Gong/machine-learning-algorithm/blob/master/src/main/resource/BPNN/BPNN.jpg)
3. In the training process, x1 and x2 have 4 training samples, such as [1,1], [1,0], [0,1], [0,0]. Training count is 1000.
4. Training result, 
   
   | Input(x1, x2)| Expexted result | Actual result |
   | -------------|-----------------|---------------|
   | [1,1]  | 0   | 0.02074452285884211    |
   | [1,0] | 1 | 0.9808479500651514   |
   | [0,1] | 1 | 0.9808201576391186   |
   | [0,0] | 0 | 0.019956923563609858    |

