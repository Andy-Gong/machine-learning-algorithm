package module;


public class Connection {
    private double weight;
    private Neuron connected;

    public Connection(double weight, Neuron connected) {
        this.weight = weight;
        this.setConnected(connected);
    }

    public double getWeight() {
        return this.weight;
    }

    public Neuron getConnected() {
        return connected;
    }

    public void setConnected(Neuron connected) {
        this.connected = connected;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
