package neurons.weight;

public class UniformWeight implements WeightInitializer {

	private final double value;

	public UniformWeight(double value) {
		this.value = value;
	}

	@Override
	public double getWeight(int fromLayer, int fromIndex, int toIndex) {
		return value;
	}
}
