package machinelearning
import machinelearning.MyCSVReader
import java.io.File

class LinearRegression {
  var weights: Array[Double] = _
  var bias: Double = scala.util.Random.nextDouble()

  def fit(X: Array[Array[Double]], y: Array[Double], learningRate: Double, epochs: Int): Unit = {
      val nFeatures = X(0).length
      weights = Array.fill(nFeatures)(bias)

      for (i <- 1 to epochs) {
        for (j <- X.indices) {
            val prediction = predict(X(j))
            val error = prediction - y(j)
            bias -= learningRate * error
            for (k <- weights.indices) {
                weights(k) -= learningRate * error * X(j)(k)
            }
        }
      }
  }

  def predict(x: Array[Double]): Double = {
      weights.zip(x).map {
        case (w, xi) => w * xi}.sum + bias
  }
}
