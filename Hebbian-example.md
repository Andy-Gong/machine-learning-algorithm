
Hebbian learning NeuralNetwork

#### Hebbian theory

Hebbian theory is a theory in neuroscience that proposes an explanation for the adaptation of neurons in the brain during the learning process. It describes a basic mechanism for synaptic plasticity, where an increase in synaptic efficacy arises from the presynaptic cell's repeated and persistent stimulation of the postsynaptic cell. [Wiki definition](https://en.wikipedia.org/wiki/Hebbian_theory)

#### Algorithm

##### learning algorithm

          ∆w_ij(p)=αx_i(p)y_j(p) - ϕw_ij(p)y_j, 
                    and α is rate of learning, ϕ is rate of forget
          
          w_ij(p+1)=w_ij(p)+∆w_ij(p)

##### learning steps

1. Choose inputs, and initial weights and α and ϕ, 
2. Calculate output,
```
          y_j (p)=∑_(i=1)^n▒(w_ij*x_i)
```
3. Learning or adjust weights.
       
          ∆w_ij(p)=αx_i(p)y_j(p) - ϕw_ij(p)y_j, 
                    and α is rate of learning, ϕ is rate of forget
          
          w_ij(p+1)=w_ij(p)+∆w_ij(p)
         
4. Iterator, repeat step2 to step4 until weight is stable.

#### Example

Initial inputs, weights, α and ϕ.
1. Input matrix.

```
0.0	0.0	0.0	0.0	0.0	
0.0	1.0	0.0	0.0	1.0	
0.0	0.0	0.0	1.0	0.0	
0.0	0.0	1.0	0.0	0.0	
0.0	1.0	0.0	0.0	1.0
```
2. Initial weights matrix.

```
1.0	0.0	0.0	0.0	0.0	
0.0	1.0	0.0	0.0	0.0	
0.0	0.0	1.0	0.0	0.0	
0.0	0.0	0.0	1.0	0.0	
0.0	0.0	0.0	0.0	1.0
```
3. α is 0.1 and ϕ is 0.02

4. After training 88 times, the neural network is stable and weights matrix as below.

```
1.0	0.0	                 0.0	0.0	0.0	
0.0	4.99999979730149	       0.0	0.0	4.9999997466268615	
0.0	0.0	                 1.0	0.0	0.0	
0.0	0.0	                 0.0	1.0	0.0	
0.0	4.9999997466268615	       0.0	0.0	4.99999979730149
```
5. We can see w(2,5), w(2,2), w(5,2), w(5,5) are stronger. 




