package player

import map.Board
import scalafx.scene.shape.Rectangle
import slider.Slider._
import slider.Slider

class GameOver(player: Player) extends State(player) {
  override def wClicked(): Unit = {}
  override def sClicked(): Unit = {}
  override def aClicked(): Unit = {}
  override def dClicked(): Unit = {}

  override def obstaclePlaced(position: Position): Unit = {}

  override def goalReached(): Unit = {}

  override def gameOver(): Unit = {}
  override def retry(): Unit = {}
  override def startPressed(): Unit = {
    Board.reset()
    sceneGraphics.children.clear()
    player.moves = 0
    player.stage = 0
    player.state = new Stationary(player)
    player.position.x = 0
    player.position.y = 0
    Board.generateRandomObstacles(10)
    for (i <- Board.obstacles) {
      sceneGraphics.children.add(Rectangle(i.x * SCALE, i.y * SCALE, SCALE, SCALE))
    }
    sceneGraphics.children.add(playerDisplay)
    sceneGraphics.children.add(goalDisplay)
    sceneGraphics.children.add(topBorder)
    sceneGraphics.children.add(leftBorder)
    sceneGraphics.children.add(bottomBorder)
    sceneGraphics.children.add(rightBorder)

    sceneGraphics.children.add(moveText)
    sceneGraphics.children.add(stageText)

    sceneGraphics.children.add(startButton)
    sceneGraphics.children.add(giveupButton)
    sceneGraphics.children.add(gameOverText)

    Slider.gameOverText.setText(" ")
  }
}
