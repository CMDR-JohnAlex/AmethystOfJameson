# Amethyst of Jameson

## Overview

**Amethyst of Jameson** is a text-based adventure game where the player explores a dungeon castle in search of the legendary Amethyst of Jameson. The game features procedurally generated maps and various items with minor effects.

## Features

- **Procedurally Generated Map**: Each game generates a new map with different rooms and items.
- **Variety of Items**: The game includes a range of items, including those with positive, negative, and mixed effects.
- **Player Stats**: The player has stats such as Strength, Dexterity, and Charisma that can be affected by items.
- **Room Descriptions**: Each room has a random description to enhance the immersive experience.

## Getting Started

### Building Yourself

0. Prerequisites:

- Java 8 or higher
- Maven

1. Clone the repository:

    ```sh
    git clone https://github.com/CMDR-JohnAlex/AmethystOfJameson.git
    cd AmethystOfJameson
    ```

2. Build the project using Maven:

    ```sh
    mvn clean install
    ```

3. Run the game:

    ```sh
    java -jar AmethystOfJameson.jar
    ```

### Running the Game

Grab the [Java Runtime Environment for Java 8](https://www.java.com/en/download/).

Download the [latest release here](https://github.com/CMDR-JohnAlex/AmethystOfJameson/releases).

Then run the game like so:

```sh
java -jar AmethystOfJameson.jar
```

Or you can optionally use the provided batch or shell script to run the game. This is nice when double clicking from a file explorer instead of using the console.

- On Windows:

    ```sh
    Run.bat
    ```

- On Unix-based systems:

    ```sh
    Run.sh
    ```

## How to Play

- **Objective**: Find the Amethyst of Jameson and escape the dungeon.

- **Commands**:

  - `north`, `n` or `up`: Move north.
  - `east`, `e` or `right`: Move east.
  - `south`, `s` or `down`: Move south.
  - `west`, `w` or `left`: Move west.
  - `pickup` or `p`: Pick up an item, gold, healing item or a trap. Ow!
  - `map` or `m`: Display the map.
  - `inventory` or `i`: Display the player's inventory.
  - `compass` or `directions`: Displays a compass to help with directions.
  - `leave` or `exit`: Attempt to leave the dungeon. (Only works if you have the Amethyst of Jameson.)
  - `help` or `h`: Displays this list of commands in-game.
  - `quit`: Quit the game.

## Settings

Detailed information about the in-game settings can be found in [Settings.md](Settings.md).

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Added new feature'`).
4. Push to the branch (`git push feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Developed by: CMDR-JohnAlex
- Quality Assurance Tester: seagulldotexe
- Moral Support: seagulldotexe

Thank you for playing **Amethyst of Jameson**!
