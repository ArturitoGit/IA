package neurons.aggregate;

import java.util.stream.Stream;

public class Sum implements Aggregator {

	@Override
	public double aggregate(Stream<Double> values) {
		return values.reduce(0d, (a, b) -> a + b);
	}
}
