package player

import map.map

class Position(x: Int, y: Int){
  def checkCollision(position:Position): Boolean = {
    this.x == position.x && this.y == position.y
  }

  def checkBorder(): Boolean = {
    this.x >= 0 && this.y >= 0 && this.x <= 50 && this.y <= 50
  }
}
