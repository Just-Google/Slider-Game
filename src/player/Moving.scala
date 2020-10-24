package player

class Moving(player: Player) extends State(player){
  override def wClicked(): Unit = {}

  override def sClicked(): Unit = {}

  override def aClicked(): Unit = {}

  override def dClicked(): Unit = {}

  override def obstaclePlaced(position: Position): Unit = {}
}
