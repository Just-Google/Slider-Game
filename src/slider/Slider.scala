package slider

import Controller._
import map.Board
import player.{Player, Position}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Group, Scene, shape}
import javafx.scene.input.{KeyEvent, MouseEvent}
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Line, Rectangle}
import scalafx.scene.text.{Font, Text}

object Slider extends JFXApp{

  val SCALE: Int = 15

  val sceneGraphics: Group = new Group{}
  sceneGraphics.translateX.value = 15
  sceneGraphics.translateY.value = 15

  val player = new Player()
  player.startPressed()

  val playerDisplay: Rectangle = Rectangle(player.position.x * SCALE, player.position.y * SCALE, SCALE, SCALE)
  playerDisplay.setFill(Color.Blue)
  val goalDisplay: Rectangle = Rectangle(Board.goal.x * SCALE, Board.goal.y * SCALE, SCALE, SCALE)
  goalDisplay.setFill(Color.Red)

  Board.generateRandomObstacles(10)
  for (i <- Board.obstacles) {
    sceneGraphics.children.add(Rectangle(i.x * SCALE, i.y * SCALE, SCALE, SCALE))
  }

  val moveText: Text = new Text("Move : " + player.moves)
  moveText.setFont(Font.font(20))
  moveText.x = 800
  moveText.y = 100

  val stageText: Text = new Text("Stage : " + player.stage)
  stageText.setFont(Font.font(20))
  stageText.x = 800
  stageText.y = 150

  val topBorder: Line = Line(0, 0, 765, 0)
  val leftBorder: Line = Line(0, 0, 0, 765)
  val bottomBorder: Line = Line(0, 765, 765, 765)
  val rightBorder: Line = Line(765, 0, 765, 765)

  sceneGraphics.children.add(playerDisplay)
  sceneGraphics.children.add(goalDisplay)
  sceneGraphics.children.add(topBorder)
  sceneGraphics.children.add(leftBorder)
  sceneGraphics.children.add(bottomBorder)
  sceneGraphics.children.add(rightBorder)

  sceneGraphics.children.add(moveText)
  sceneGraphics.children.add(stageText)

  this.stage = new PrimaryStage {
    title = "Slider Game"
    scene = new Scene(1000, 800) {
      content = List(
        sceneGraphics
      )
      addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardInput(player))
      addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseInput(player))
    }

    var pLength: Int = Board.obstacles.length - 1

    val update: Long => Unit = (time: Long) => {
      playerDisplay.translateX.value = player.position.x * SCALE
      playerDisplay.translateY.value = player.position.y * SCALE
      Slider.goalDisplay.x = Board.goal.x * SCALE
      Slider.goalDisplay.y = Board.goal.y * SCALE
      moveText.setText("Move : " + player.moves)
      stageText.setText("Stage : " + player.stage)

      if (Board.obstacles.length - 1 > pLength) {
        sceneGraphics.children.add(Rectangle(Board.obstacles.last.x * Slider.SCALE, Board.obstacles.last.y * Slider.SCALE, Slider.SCALE, Slider.SCALE))
        pLength += 1
      }
    }

    AnimationTimer(update).start()
  }

}
