package tests

import org.scalatest.FunSuite
import player._
import map._

class PlayerTest extends FunSuite{

  test("Test W") {

    val player1: Player = new Player()
    map.goal = new Position(30, 0)
    player1.wClicked()

    assert(player1.position.x == 51)
  }

  test("Test A") {

    val player1: Player = new Player()
    map.goal = new Position(25, 20)
    player1.aClicked()

    assert(player1.position.y == 20)
  }

  test("Test S") {

    val player1: Player = new Player()
    map.goal = new Position(20, 25)
    player1.sClicked()

    assert(player1.position.x == 20)
  }

  test("Test D") {

    val player1: Player = new Player()
    map.goal = new Position(25, 30)
    player1.dClicked()

    assert(player1.position.y == 30)
  }

}
