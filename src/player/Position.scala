package player

import map.map

class Position(var x: Int, var y: Int){
  def checkCollision(position:Position): Boolean = {
    this.x == position.x && this.y == position.y
  }

  def move(horizontal: Int, vertical: Int): Unit = {
    x += horizontal
    y += vertical
  }

  def checkBorder(): Boolean = {
    this.x < 0 || this.y < 0 || this.x > 50 && this.y > 50
  }
}
