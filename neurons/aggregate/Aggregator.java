package neurons.aggregate;

import java.util.stream.Stream;

public interface Aggregator {
	public double aggregate(Stream<Double> values);
}
