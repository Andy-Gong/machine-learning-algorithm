# machine-learning-algorithm
It includes a lot of examples of machine learning algorithms during my learning road.

#### BackPropagation NeuralNetwork
1. We use this algorithm to resolve Exclusive-OR problem.
2. In the example, NeuralNetwork includes three layers: input layer, hidden layer and output layer.
   ![Alt text](https://github.com/Andy-Gong/machine-learning-algorithm/blob/master/src/main/resource/BPNN/BPNN.jpg)
3. In the training process, x1 and x2 have 4 training samples, such as [1,1], [1,0], [0,1], [0,0]. Training count is 1000 and rate is 0.7.
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

