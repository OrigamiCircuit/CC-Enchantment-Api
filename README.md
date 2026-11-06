# Computer Craft Enchantment API

A Minecraft mod for CC:Tweaked that provides an API for accessing, retrieving, and managing enchantments through computer and peripheral interactions.

## Overview

Computer Craft Enchantment API is an add-on for CC:tweaked that gives computers and turtles access to Minecraft's enchantment information and functionality through a Lua API named enchantment.

The API provides methods for retrieving enchantment properties, discovering available enchantments, checking compatibility between enchantments, and determining whether items can be enchanted.

The mod also introduces the Analyzer, a separate block that expands the API's capabilities by allowing enchantment checks to be performed against an actual Item Stack rather than relying on Item-Identifiers. This provides more precise results by evaluating the item directly.

The Analyzer exposes its own peripheral methods to connected computers and turtles. It can also be equipped by turtles using their tool slots, allowing them to access the Analyzer's functionality directly.

For a complete list of available methods, their parameters, and their functionality, see the sections below.

## Requirements

- Minecraft 1.20.1
- Minecraft Forge 47.x
- CC:Tweaked

## Development

This project is developed using Java 17, Gradle, and ForgeGradle.

### Project Information

| Property | Value |
|---|---|
| Project | CC Enchantment API |
| Mod ID | `cc_enchantment_api` |
| Minecraft | 1.20.1 |
| Mod Loader | Forge |
| License | MIT |
| Author | OrigamiCircuit |

## License

This project is licensed under the MIT License. See [LICENSE.txt](LICENSE.txt) for details.