package Controller

import javafx.event.EventHandler
import player.{Player, Position}
import javafx.scene.input.{KeyEvent, MouseEvent}
import javafx.event.ActionEvent
import slider.Slider._

class KeyboardInput(p: Player) extends EventHandler[KeyEvent] {

  override def handle(event: KeyEvent): Unit = {
    event.getCode.getName match {
      case "W" => p.wClicked()
      case "A" => p.aClicked()
      case "S" => p.sClicked()
      case "D" => p.dClicked()
      case _ =>
    }
  }

}

class MouseInput(p: Player) extends EventHandler[MouseEvent] {

  override def handle(event: MouseEvent): Unit = {
    val x = (event.getX / SCALE).toInt - 1
    val y = (event.getY / SCALE).toInt - 1
    if (x >= 0 && x <= 50 && y >= 0 && x <= 50) {
      p.obstaclePlaced(new Position(x, y))
    }
  }

}

class ButtonEvent(p: Player, s: String) extends EventHandler[ActionEvent] {

  override def handle(event: ActionEvent): Unit = {
    if (s == "Start") {
      p.startPressed()
    }
    else if (s == "Restart") {
      p.retry()
    }
    else if (s == "Giveup") {
      p.giveUp()
    }
  }
}
