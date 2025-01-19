# Amethyst of Jameson - Settings

## Overview

This document provides detailed information about the in-game settings available in **Amethyst of Jameson**. These settings allow you to customize various aspects of the game to enhance your playing experience.

## Settings

### Test Mode

- **Description**: Enables or disables test mode.
- **Default Value**: `false`
- **Possible Values**: `true`, `false`
- **Effect**: This does absolutely nothing.

### Map Width

- **Description**: Sets the width of the dungeon map.
- **Default Value**: `7`
- **Possible Values**: Any positive integer
- **Effect**: Determines the number of columns in the dungeon map. Increasing the width will create a larger map, providing more rooms to explore.

### Map Height

- **Description**: Sets the height of the dungeon map.
- **Default Value**: `7`
- **Possible Values**: Any positive integer
- **Effect**: Determines the number of rows in the dungeon map. Increasing the height will create a larger map, providing more rooms to explore.

### Hide Unvisited Rooms

- **Description**: Controls whether unvisited rooms are hidden on the map.
- **Default Value**: `true`
- **Possible Values**: `true`, `false`
- **Effect**: When enabled, rooms that the player has not yet visited will be displayed as "UNKNOWN" on the map. When disabled, the map will display the type of each room.

### Empty Room Weight

- **Description**: Sets the probability weight for generating empty rooms.
- **Default Value**: `20`
- **Possible Values**: Any positive integer
- **Effect**: Higher values increase the likelihood of generating empty rooms. This number is relative to the other weight values. This setting affects the overall distribution of room types in the dungeon.

### Item Room Weight

- **Description**: Sets the probability weight for generating item rooms.
- **Default Value**: `30`
- **Possible Values**: Any positive integer
- **Effect**: Higher values increase the likelihood of generating rooms containing items. This number is relative to the other weight values. This setting affects the overall distribution of room types in the dungeon.

### Gold Room Weight

- **Description**: Sets the probability weight for generating gold rooms.
- **Default Value**: `30`
- **Possible Values**: Any positive integer
- **Effect**: Higher values increase the likelihood of generating rooms containing gold. This number is relative to the other weight values. This setting affects the overall distribution of room types in the dungeon.

### Trap Room Weight

- **Description**: Sets the probability weight for generating trap rooms.
- **Default Value**: `10`
- **Possible Values**: Any positive integer
- **Effect**: Higher values increase the likelihood of generating rooms containing traps. This number is relative to the other weight values. This setting affects the overall distribution of room types in the dungeon.

### Healing Room Weight

- **Description**: Sets the probability weight for generating healing rooms.
- **Default Value**: `3`
- **Possible Values**: Any positive integer
- **Effect**: Higher values increase the likelihood of generating rooms containing healing items. This number is relative to the other weight values. This setting affects the overall distribution of room types in the dungeon.

### Seed

- **Description**: Sets the seed for the random number generator.
- **Default Value**: Randomly generated at the start of each game
- **Possible Values**: Any long integer
- **Effect**: The seed determines the sequence of random numbers used to generate the dungeon map and other random elements. Setting a specific seed allows for reproducible game sessions, useful for sharing with a friend, replaying the same map, or reporting a bug.

## How to Change Settings

Settings can be changed through the in-game settings menu. To access the settings menu:

1. Start the game.
2. Select "Settings" from the main menu.
3. Follow the prompts to change the desired settings.
