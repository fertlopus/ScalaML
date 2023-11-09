## Machine Learning Concepts using Scala

---

<p align="center">
  <img src="./src/imgs/gd_scala_repo_img.png?raw=true" alt="custom image" width="50%"/>
</p>


---

#### Description:

This repository contains all the code that I've wrote to test the inference speed of Gradient Descent Algorithms and Linear Regression Algos using Scala programming language. This code is just a testing purposes not a fully functional project that is ready to use out of the box. 

How to install:

* clone the repo or download as zip
* open with IntelliJ as it is a simple IDEA project

If you have changes to suggest for this repository, either:
* submit a GitHub issue
* submit a pull request

All the dependencies are listed in `build.sbt file` 

## Linear Regression

The `LinearRegression` class provides an implementation of simple linear regression that can be trained using Stochastic Gradient Descent (SGD).

### Usage

To use the `LinearRegression` class, you must first read your data from a CSV file, separate it into features and target arrays, and then fit the model.

```scala
import machinelearning.{CSVReader, LinearRegression}

object RegressionApp {
  def main(args: Array[String]): Unit = {
    val filePath = "path/to/your/data.csv"
    val data = CSVReader.readCSV(filePath)
    val features = data.map(row => row.init.map(_.toDouble).toArray).toArray
    val target = data.map(row => row.last.toDouble).toArray

    val regression = new LinearRegression()
    regression.fit(features, target, learningRate = 0.01, epochs = 1000)
    // ...
  }
}
```


Classes implemented:

* `MyCSVReader` - class for reading the raw (table) csv file format for further usage in machine learning algorithms
* `LinearRegression` - class for linear regression algorithm using vanilla gradient descent