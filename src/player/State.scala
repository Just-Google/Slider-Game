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
}
