package player

import map.map

abstract class State(player:Player){
  def wClicked(): Unit
  def sClicked(): Unit
  def aClicked(): Unit
  def dClicked(): Unit

  def obstaclePlaced(position: Position): Unit

  def goalReached(): Unit = {
    if(player.position.checkCollision(map.goal)){
      player.stage += 1
      map.newGoal()
    }
  }

  def gameOver(): Unit = {
    if(player.position.checkBorder()){
      println("You Lost \n" + "Move" + player.moves + "\n" + "Stage" + player.stage)
      player.moves = 0
      player.stage = 0
      map.reset()
    }
  }
}
