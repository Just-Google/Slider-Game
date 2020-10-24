package player

class Player {
  var state: State = new Stationary(this)
  var position: Position = new Position(0,0)
  var moves: Int = 0
  var obstacles: List[Position] = List()
  var goal: Position = this.state.generatePosition()
  var mapSize:

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
