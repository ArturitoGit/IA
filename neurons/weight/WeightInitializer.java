package neurons.weight;

public interface WeightInitializer {
	double getWeight(int fromLayer, int fromIndex, int toIndex);
}
