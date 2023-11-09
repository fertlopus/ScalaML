package machinelearning

class SGD(learningRate: Double) {
  val learningRate: Double = learningRate
  def step(weights: Array[Double], gradient: Array[Double]): Array[Double] = {
      // update the weights based on the gradient and learning rate
      weights.zip(gradient).map {case (w, g) => w - learningRate * g}
  }
}
