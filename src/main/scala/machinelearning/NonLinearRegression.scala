package machinelearning
import scala.math.pow


class NonLinearRegression(degree: Int) extends LinearRegression {


  private def enhanceFeatures(features: Array[Array[Double]]): Array[Array[Double]] = {
    features.map { featureRow =>
      featureRow.flatMap { feature =>
        (0 to degree).map(pow(feature, _))
      }
    }
  }

  override def fit(X: Array[Array[Double]], y: Array[Double], epochs: Int): Unit = {
    val enhancedFeatures = enhanceFeatures(X)
    super.fit(enhancedFeatures, y, epochs)
  }

  override def predict(x: Array[Double]): Double = {
    val enhancedFeatures = enhanceFeatures(Array(x)).head
    super.predict(enhancedFeatures)
  }
}
