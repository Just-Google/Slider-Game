package player

import map.map

abstract class State(player:Player){
  def wClicked(): Unit
  def sClicked(): Unit
  def aClicked(): Unit
  def dClicked(): Unit

  def obstaclePlaced(): Unit

  def goalReached(): Unit = {
    player.stage += 1
    player.state = new Stationary(player)
    map.newGoal()
  }

  def gameOver(): Unit = {
    println("You Lost \n" + "Move" + player.moves + "\n" + "Stage" + player.stage)
    player.moves = 0
    player.stage = 0
    map.reset()
  }
}
