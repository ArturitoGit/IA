package neurons.activate;

public class Threshold implements Activator {

	private final double threshold;

	public Threshold(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public double activate(double value) {
		return value >= threshold ? value : 0l;
	}
}
