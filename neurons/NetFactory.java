package neurons;

import java.util.ArrayList;
import java.util.List;
import neurons.activate.Activator;
import neurons.aggregate.Aggregator;
import neurons.weight.WeightInitializer;
import static java.util.stream.IntStream.range;
import static java.util.Arrays.stream;

public class NetFactory {

	private final int[] shape; 
	private final WeightInitializer initWeight;
	private final Aggregator aggregator;
	private final Activator activator;

	private List<Layer> layers;

	public NetFactory(int[] shape, WeightInitializer initWeight, Aggregator aggregator, Activator activator) {
		this.shape = shape;
		this.initWeight = initWeight;
		this.aggregator = aggregator;
		this.activator = activator;
	}

	public Net make() {
		layers = new ArrayList<>();
		stream(shape).forEach(this::addLayer);
		return new Net(layers);
	}

	private void addLayer(int size) {
		layers.add(new Layer(
			range(0, size)
				.mapToObj(this::linksWithLastLayer)
				.map(this::toNeuron)
				.toList()
		));
	}

	private Link[] linksWithLastLayer(int toIndex) {
		Layer lastLayer = lastLayer();
		return (lastLayer != null) ?
			linksWith(lastLayer, toIndex) :
			new Link[] {};
	}

	private Link[] linksWith(Layer layer, int toIndex) {
		return range(0, layer.size())
			.mapToObj(fromIndex -> new Link(
				layer.get(fromIndex),
				weight(fromIndex, toIndex)
			))
			.toArray(Link[]::new);
	}

	private double weight(int fromIndex, int toIndex) {
		return initWeight.getWeight(layerIndex(), fromIndex, toIndex);
	}

	private Neuron toNeuron(Link[] links) {
		return new Neuron(links, aggregator, activator);
	}

	private Layer lastLayer() {
		return layers != null && !layers.isEmpty() ?
			layers.get(layers.size() - 1) :
			null;
	}

	private int layerIndex() {
		return layers == null ? 0 : layers.size() - 1;
	}
}
