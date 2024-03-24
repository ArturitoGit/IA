package neurons;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Net {

	private final List<Layer> layers;

	public Net(List<Layer> layers) {
		this.layers = layers;
	}

	public double[] compute(double[] inputs) {
		fill(firstOf(layers), inputs);
		restOf(layers).forEach(this::compute);
		return valuesIn(lastOf(layers));
	}

	private void fill(Layer layer, double[] values) {
		if (values.length != layer.size()) {
			throw new IllegalArgumentException(
				"The number of inputs doesn't match the number of entries...");
		}
		for (int i = 0; i < values.length; i++) {
			layer.get(i).setValue(values[i]);
		}
	}

	private void compute(Layer layer) {
		layer.forEach(Neuron::compute);
	}

	private double[] valuesIn(Layer layer) {
		return layer.stream()
			.mapToDouble(Neuron::getValue)
			.toArray();
	}

	private <T> T lastOf(List<T> elements) {
		return elements.get(elements.size() - 1);
	}

	private <T> T firstOf(List<T> elements) {
		return elements.get(0);
	}

	private <T> Stream<T> restOf(List<T> elements) {
		return range(1, elements.size()).mapToObj(elements::get);
	}
}
