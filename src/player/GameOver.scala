package player

import map.Board

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
    player.moves = 0
    player.stage = 0
    player.state = new Stationary(player)
    player.position.x = 0
    player.position.y = 0
  }
}
