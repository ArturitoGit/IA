package neurons;

import static java.util.Arrays.stream;
import java.util.stream.Stream;
import neurons.activate.Activator;
import neurons.aggregate.Aggregator;

public class Neuron {

	private final Link[] inputs;
	private final Aggregator aggregator;
	private final Activator activator;

	private Double value;

	public Neuron(Link[] inputs, Aggregator aggregator, Activator activator) {
		this.inputs = inputs;
		this.aggregator = aggregator;
		this.activator = activator;
	}

	public void compute() {
		Stream<Double> entryValues = stream(inputs).map(Link::getValue);
		double aggregated = aggregator.aggregate(entryValues);
		double activated = activator.activate(aggregated);
		setValue(activated);
	}
	
	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
