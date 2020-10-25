package player

import map.Board

class Player {
  var state: State = new Stationary(this)
  var position: Position = new Position(25, 25)
  var moves: Int = 0
  var stage: Int = 0

  def wClicked(): Unit = {
    this.state.wClicked()
  }
  def sClicked(): Unit = {
    this.state.sClicked()
  }
  def aClicked(): Unit = {
    this.state.aClicked()
  }
  def dClicked(): Unit = {
    this.state.dClicked()
  }

  def obstaclePlaced(position: Position): Unit = {
    this.state.obstaclePlaced(position: Position)
  }

}
