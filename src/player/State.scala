package player

import map.Board

abstract class State(player:Player){
  def wClicked(): Unit
  def sClicked(): Unit
  def aClicked(): Unit
  def dClicked(): Unit

  def obstaclePlaced(position: Position): Unit

  def goalReached(): Unit = {
    if(player.position.checkCollision(Board.goal)){
      player.stage += 1
      Board.newGoal()
      Board.generateRandomObstacles(1)
    }
  }

  def gameOver(): Unit = {
    if(player.position.checkBorder()){
      println("You Lost \n" + "Move" + player.moves + "\n" + "Stage" + player.stage)
      player.moves = 0
      player.stage = 0
      Board.reset()
    }
  }
}
