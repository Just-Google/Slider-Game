package player

import map.map

class Stationary(player: Player) extends State(player){
  override def wClicked(): Unit = {
    player.moves += 1
    player.state = new Moving(player)
    while(map.validPosition(player.position, map.obstacles ::: List(map.goal)) && player.position.checkBorder()){
      player.position.move(1,0)
    }
    if(player.position.checkCollision(map.goal)){
      goalReached()
    }
    player.state = new Stationary(player)
  }

  override def sClicked(): Unit = ???

  override def aClicked(): Unit = ???

  override def dClicked(): Unit = ???

  override def obstaclePlaced(): Unit = ???
}
