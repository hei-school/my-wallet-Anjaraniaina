import java.util
import scala.io.StdIn

object Main extends App {
  val service = new Service(0, new util.ArrayList(), "Ariary")

  def doubleScanner(): Double = {
    StdIn.readDouble()
  }

  def intScanner(): Int = {
    StdIn.readInt()
  }

  private def welcome(): Unit = {
    Service.print("Hello! I'm your smart wallet\n" + "what do you want to do ?")
  }

  def menu(): Unit = {
    Service.print(
      new StringBuilder()
        .append("1. Check your current balance.")
        .append("\n")
        .append("2. Take out money.")
        .append("\n")
        .append("3. Store money.")
        .append("\n")
        .append("4. Convert to another currency.")
        .append("\n")
        .append("5. Check your 5 latest transactions.")
        .append("\n")
        .append("6. Quit.")
        .toString()
    )
    intScanner() match {
      case 1 => service.checkBalance()
      case 2 => service.retrieveMoney()
      case 3 => service.storeMoney()
      case 4 => service.convertCurrency()
      case 5 => service.history()
      case 6 => quit()
      case _ => menu()
    }
  }

  private def quit(): Unit = {
    Service.print("See you later !")
  }

  welcome()
  menu()
}