package map

import player._

object map {
  var obstacles: List[Position] = List()
  var goal: Position = generatePosition(new Position(0,0))
  var mapSize: Int = 50

  def newGoal(): Unit = {
    goal = generatePosition(goal)
  }

  def generatePosition(position: Position): Position = {//0 - .9999999
    var temp: Position = new Position((Math.random() * mapSize+1).toInt, (Math.random() * mapSize+1).toInt)
    val tempList: List[Position] = obstacles ::: List(position)
    while(!validPosition(temp, tempList)){
      temp = new Position((Math.random() * mapSize+1).toInt, (Math.random() * mapSize+1).toInt)
    }
    temp
  }

  def validPosition(position: Position, positions: List[Position]): Boolean = {
    if(positions.size == 1){
      position.checkCollision(positions(0))
    }
    else{
      validPosition(position,positions.splitAt(positions.size/2)._1) && validPosition(position,positions.splitAt(positions.size/2)._2)
    }
  }

}
