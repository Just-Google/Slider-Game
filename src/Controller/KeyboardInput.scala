package Controller

import javafx.event.EventHandler
import player.{Player, Position}
import javafx.scene.input.{KeyEvent, MouseEvent}
import scalafx.scene.shape.Rectangle
import slider.Slider

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
    val x = (event.getX / Slider.SCALE).toInt - 1
    val y = (event.getY / Slider.SCALE).toInt - 1
    if (x >= 0 && x <= 50 && y >= 0 && x <= 50) {
      p.obstaclePlaced(new Position(x, y))
    }
  }

}
