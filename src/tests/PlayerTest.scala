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

}
