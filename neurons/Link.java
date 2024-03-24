package neurons;

public class Link {
	public final Neuron from;
	public final double weight;

	public Link(Neuron from, double weight) {
		this.from = from;
		this.weight = weight;
	}

	public double getValue() {
		System.out.println(from.getValue());
		return weight * from.getValue();
	}
}
