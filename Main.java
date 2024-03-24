import static java.util.Arrays.stream;

import neurons.Net;
import neurons.NetBuilder;
import neurons.activate.Threshold;
import neurons.aggregate.Sum;
import neurons.weight.UniformWeight;

public class Main {

	public static void main(String[] args) {
		
		Net net = new NetBuilder()
			.shape(2, 2)
			.aggregator(new Sum())
			.activator(new Threshold(0.5d))
			.weight(new UniformWeight(0.2d))
			.build();

		double[] input = new double[] {
			0.5d,
			0.25d
		};

		describe(net.compute(input));
	}

	private static void describe(double[] result) {
		stream(result).forEach(r -> {
			System.out.print(": ");
			System.out.println(r);
		});
	}
}
