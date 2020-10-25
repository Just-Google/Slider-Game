package player

import map.Board

class Stationary(player: Player) extends State(player){
  override def wClicked(): Unit = {
    player.state = new Moving(player)
    if(Board.validPosition(new Position(player.position.x,player.position.y-1), Board.obstacles)){
      player.moves += 1
    }
    while(Board.validPosition(player.position, Board.obstacles :+ Board.goal) && !player.position.checkBorder()){
      player.position.move(0,-1)
    }
    if(!Board.validPosition(player.position, Board.obstacles)){
      player.position.move(0,1)
    }
    goalReached()
    player.state = new Stationary(player)
    gameOver()
  }

  override def sClicked(): Unit = {
    player.state = new Moving(player)
    if(Board.validPosition(new Position(player.position.x,player.position.y+1), Board.obstacles)){
      player.moves += 1
    }
    while(Board.validPosition(player.position, Board.obstacles :+ Board.goal) && !player.position.checkBorder()){
      player.position.move(0,1)
    }
    if(!Board.validPosition(player.position, Board.obstacles)){
      player.position.move(0,-1)
    }
    goalReached()
    player.state = new Stationary(player)
    gameOver()
  }

  override def aClicked(): Unit = {
    player.state = new Moving(player)
    if(Board.validPosition(new Position(player.position.x-1,player.position.y), Board.obstacles)){
      player.moves += 1
    }
    while(Board.validPosition(player.position, Board.obstacles :+ Board.goal) && !player.position.checkBorder()){
      player.position.move(-1,0)
    }
    if(!Board.validPosition(player.position, Board.obstacles)){
      player.position.move(1,0)
    }
    goalReached()
    player.state = new Stationary(player)
    gameOver()
  }

  override def dClicked(): Unit = {
    player.state = new Moving(player)
    if(Board.validPosition(new Position(player.position.x+1,player.position.y), Board.obstacles)){
      player.moves += 1
    }
    while(Board.validPosition(player.position, Board.obstacles :+ Board.goal) && !player.position.checkBorder()){
      player.position.move(1,0)
    }
    if(!Board.validPosition(player.position, Board.obstacles)){
      player.position.move(-1,0)
    }
    goalReached()
    player.state = new Stationary(player)
    gameOver()
  }

  override def obstaclePlaced(position: Position): Unit = {
    if(Board.validPosition(position, Board.obstacles :+ Board.goal :+ player.position )){
      Board.obstacles = Board.obstacles :+ position
      player.moves += 1
    }
  }
}
