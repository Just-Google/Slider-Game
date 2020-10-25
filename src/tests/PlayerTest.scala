package tests

import org.scalatest.FunSuite
import player._
import map._

class PlayerTest extends FunSuite{

  test("test all directions"){
    val player1: Player = new Player()
    player1.startPressed()
    player1.wClicked()
    player1.sClicked()
    player1.aClicked()
    player1.dClicked()
    assert(player1.position.x == 0)
    assert(player1.position.y == 51)

    val player2: Player = new Player()
    player2.startPressed()
    player2.sClicked()
    player2.wClicked()
    player2.aClicked()
    player2.dClicked()
    assert(player2.position.x == 0)
    assert(player2.position.y == -1)

    val player3: Player = new Player()
    player3.startPressed()
    player3.aClicked()
    player3.wClicked()
    player3.sClicked()
    player3.dClicked()
    assert(player3.position.x == -1)
    assert(player3.position.y == 0)

    val player4: Player = new Player()
    player4.startPressed()
    player4.dClicked()
    player4.wClicked()
    player4.sClicked()
    player4.aClicked()
    assert(player4.position.x == 51)
    assert(player4.position.y == 0)
  }

  test("obstacle placed"){
    val player1: Player = new Player()
    player1.startPressed()
    player1.obstaclePlaced(new Position(0,10))
    player1.wClicked()
    assert(player1.position.x == 0)
    assert(player1.position.y == 9)

    player1.obstaclePlaced(new Position(10,9))
    player1.dClicked()
    assert(player1.position.x == 9)
    assert(player1.position.y == 9)
  }

  test("goal crossed"){
    val player1: Player = new Player()
    player1.startPressed()
    Board.goal = new Position(25,25)
    player1.obstaclePlaced(new Position(0,26))
    player1.wClicked()
    player1.dClicked()
    assert(player1.position.x == 25)
    assert(player1.position.y == 25)
  }
}
