package machinelearning
import com.github.tototoshi.csv.{CSVReader => ScalaCSVReader}
import java.io.File

object MyCSVReader {
  def readCSV(filePath: String): List[Map[String, String]] = {
    val reader = ScalaCSVReader.open(new File(filePath))
    val allRows: List[Map[String, String]] = reader.allWithHeaders()
    reader.close()
    allRows
  }
}
