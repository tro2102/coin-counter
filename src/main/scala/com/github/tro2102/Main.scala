
object CoinCounter {
    def main (args: Array[String]) {
      Config.parse(args).map( config => {
        try {
          val (timing, results) = ProblemRunner(config.problemNum).run
          print(
            s"""
               | RESULTS<Problem #${config.problemNum}>:
                                                        | (completed in $timing ms)
                                                                                 |============================
                                                                                 | $results
         """.stripMargin)
        } catch {
          case x: Throwable => print("Error running solution:" + x.getMessage)
        }
      })
    }
}