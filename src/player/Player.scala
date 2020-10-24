package player

import map.map

class Player {
  var state: State = new Stationary(this)
  var position: Position = new Position(0,0)
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

  def obstaclePlaced(): Unit = {
    this.state.obstaclePlaced()
  }

}
