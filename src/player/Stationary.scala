package player

import map.map

class Stationary(player: Player) extends State(player){
  override def wClicked(): Unit = {
    player.moves += 1
    player.state = new Moving(player)
    while(map.validPosition(player.position, map.obstacles ::: List(map.goal)) && !player.position.checkBorder()){
      player.position.move(1,0)
    }
    if(player.position.checkCollision(map.goal)){
      goalReached()
    }
    if(player.position.checkBorder()){
      gameOver()
    }
    player.state = new Stationary(player)
  }

  override def sClicked(): Unit = {
    player.moves += 1
    player.state = new Moving(player)
    while(map.validPosition(player.position, map.obstacles ::: List(map.goal)) && !player.position.checkBorder()){
      player.position.move(-1,0)
    }
    if(player.position.checkCollision(map.goal)){
      goalReached()
    }
    if(player.position.checkBorder()){
      gameOver()
    }
    player.state = new Stationary(player)
  }

  override def aClicked(): Unit = {
    player.moves += 1
    player.state = new Moving(player)
    while(map.validPosition(player.position, map.obstacles ::: List(map.goal)) && !player.position.checkBorder()){
      player.position.move(0,-1)
    }
    if(player.position.checkCollision(map.goal)){
      goalReached()
    }
    if(player.position.checkBorder()){
      gameOver()
    }
    player.state = new Stationary(player)
  }

  override def dClicked(): Unit = {
    player.moves += 1
    player.state = new Moving(player)
    while(map.validPosition(player.position, map.obstacles :+ map.goal) && !player.position.checkBorder()){
      player.position.move(0,1)
    }
    if(player.position.checkCollision(map.goal)){
      goalReached()
    }
    if(player.position.checkBorder()){
      gameOver()
    }
    player.state = new Stationary(player)
  }

  override def obstaclePlaced(position: Position): Unit = {
    if(map.validPosition(position, map.obstacles :+ map.goal :+ player.position )){
      map.obstacles = map.obstacles :+ position
    }
  }
}
