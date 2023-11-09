package machinelearning
import machinelearning.MyCSVReader
import machinelearning.SGD
import java.io.File

class LinearRegression {
  var weights: Array[Double] = _
  var bias: Double = scala.util.Random.nextDouble()
  val sgdOptimizer = new SGD(learningRate = 0.01)

  def fit(X: Array[Array[Double]], y: Array[Double], epochs: Int): Unit = {
      val nFeatures = X(0).length
      weights = Array.fill(nFeatures)(0.0)

    for (_ <- 1 to epochs) {
        for (j <- X.indices) {
            val prediction = predict(X(j))
            val error = prediction - y(j)
            val gradient = X(j).map(xi => 2 * xi * error)
            val biasGradient = 2 * error
        weights = sgdOptimizer.step(weights, gradient)
        bias -= sgdOptimizer.learningRate * biasGradient
      }
    }
  }

  def predict(x: Array[Double]): Double = {
    weights.zip(x).map { case (w, xi) => w * xi }.sum + bias
  }
}
