package neurons;

import neurons.activate.Activator;
import neurons.aggregate.Aggregator;
import neurons.weight.WeightInitializer;

public class NetBuilder {

	private int[] shape; 
	private WeightInitializer initWeight;
	private Aggregator aggregator;
	private Activator activator;

	public NetBuilder weight(WeightInitializer initWeight) {
		this.initWeight = initWeight;
		return this;
	}

	public NetBuilder shape(int... shape) {
		this.shape = shape;
		return this;
	}

	public NetBuilder aggregator(Aggregator aggregator) {
		this.aggregator = aggregator;
		return this;
	}

	public NetBuilder activator(Activator activator) {
		this.activator = activator;
		return this;
	}

	public Net build() {
		return factory().make();
	}

	private NetFactory factory() {
		return new NetFactory(
			shape,
			initWeight,
			aggregator,
			activator
		);
	}
}
