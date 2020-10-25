package map

import player._
import scalafx.scene.shape.Rectangle
import slider.Slider

object Board {
  var obstacles: List[Position] = List()
  var goal: Position = generatePosition(new Position(0,0))
  var mapSize: Int = 50

  def newGoal(): Unit = {
    goal = generatePosition(goal)
    while((goal.x == 0 && goal.y == 0)||(goal.x == 50 && goal.y == 50)||(goal.x == 0 && goal.y == 50)||(goal.x == 50 && goal.y == 0)){
      goal = generatePosition(goal)
    }
  }

  def generateRandomObstacles(number: Int): Unit = {
    for(i <- 1 to number){
      var temp: Position = generatePosition(goal)
      while(!validPosition(temp, obstacles)){
        temp = generatePosition(new Position(0,0))
      }
      obstacles = obstacles :+ temp
    }
  }

  def generatePosition(position: Position): Position = {//0 - .9999999
    var temp: Position = new Position((Math.random() * mapSize+1).toInt, (Math.random() * mapSize+1).toInt)
    while(!validPosition(temp, obstacles :+ position)){
      temp = new Position((Math.random() * mapSize+1).toInt, (Math.random() * mapSize+1).toInt)
    }
    temp
  }

  def validPosition(position: Position, positions: List[Position]): Boolean = {
    if(positions.isEmpty){
      true
    }
    else{
      if(positions.size == 1){
        !position.checkCollision(positions.head)
      }
      else{
        validPosition(position,positions.splitAt(positions.size/2)._1) && validPosition(position,positions.splitAt(positions.size/2)._2)
      }
    }
  }

  def reset(): Unit = {
    obstacles = List()
    generateRandomObstacles(5)
    newGoal()
  }
}
