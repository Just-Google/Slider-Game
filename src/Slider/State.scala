package Slider

abstract class State(player:Player){
  def wClicked(): Unit
  def sClicked(): Unit
  def aClicked(): Unit
  def dClicked(): Unit

  def obstaclePlaced(): Unit

  def generatePosition(): Position = {//0 - .9999999
    new Position(Math.random() * player.
  }
}
