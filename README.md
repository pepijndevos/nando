# Nando

A strategy puzzle game about binary logic. In Nando, players compete to construct their secret code by placing logic tiles on a grid.

## Rules

All dimensions, numbers, and rules are under development and subject to change based on feedback from playtesting.

The game is played on a staggered grid as shown below. At the top are 4 outputs for the secret code, at the bottom are 12 switches to drive the logic circuit.

```
     *   *   *   *
    |   |   |   |   |
  |   |   |   |   |   |
|   |   |   |   |   |   |
 * * * * * * * * * * * *
```

### Start of the game

Put 12 bit tokens in a random pattern along the bottom of the board.
Each player draws a 4 bit secret code.

### A turn

A player can do two things:

The player draws a tile and places it on the board in a position that is fully connected to other tiles or the bottom edge of the board.

The player flips one bit at the bottom of the board and updates all connected tiles. It is not allowed to flip this bit back for one round.

### End of the game

A player wins the game by driving all outputs at the top of the board to match the secret code on their card.

When a tile with two different outputs connects to the top, the left output counts.

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
