# Nando

A strategy puzzle game about binary logic. In Nando, players compete to construct their secret code by placing logic tiles on a grid.

## Rules

All dimensions, numbers, and rules are under development and subject to change based on feedback from playtesting.

The game is played on a 9x3 board. At the top are 4 outputs for the secret code, at the bottom are 9 switches to drive the logic circuit.

|   | * |   | * |   | * |   | * |   |
|---|---|---|---|---|---|---|---|---|
|   | & |   |   |   |   |   |   |   |
|   |   |   |\| |   |   |   |   |   |
|   |   |   |   |   | ^ |   |   |   |
| 1 | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 |

### Start of the game

Put 9 bit tokens in a random pattern along the bottom of the board.
Each player draws a 4 bit secret code and 4 logic tiles into their hand.

### A turn

A player can do one of the following things.

* Place a logic tile from their hand on the board in such a way that it connects to an open output wire. Draw a card.
* Replace an existing tile with one from their hand, discarding the old tile. Draw a card.
* Discard one tile from their hand and draw a new card.
* Discard a card to flip a switch at the bottom of the board. They play the remainder of the game with one card less.

If a logic loop is created, one tile in the loop chosen by the player is "burned" and removed form the board.

At the end of a turn, update the bit tokens on all tiles to reflect their state. A tile with an open input does not have an output. Only tiles with all of their inputs driven by another active output have an output themselves.

### End of the game

A player wins the game by driving all outputs at the top of the board to match the secret code on their card.


## Building the game

The following items ar needed.

* Double-sided tokens to indicate the state of a tile.
* A sheet to draw the board
* Tiles with logic gates and wires on them (examples found in `resources/tiles`)
* Cards with secret codes

## Clojure implementation

A Clojure implementation is in included to test various things.

    $ java -jar logicgame-0.1.0-standalone.jar [args]

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
