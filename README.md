# DrawingApp

Java Drawing Application - currently supporting console drawing

## Feature Summary
Supports the following commands

Command 		|Description
---------------|--------------------
C w h          | Creates a new canvas of width w and height h.							|
L x1 y1 x2 y2  | Creates a new line from (x1,y1) to (x2,y2). Only horizontal or vertical lines are currently supported. Lines will be drawn using the 'x' character.										|
R x1 y1 x2 y2  | Creates a new rectangle which upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.													|
B x y c        | Fills the entire area connected to (x,y) with "colour" c. The behaviour is similar to that of the "bucket fill" tool in paint programs.	|
Q              | Exits the program.													|

## Assumptions and notes
* colour for bucket fill can only be alphanumeric character including 'x' used for line drawing.
* Program supports horizontal line drawn from left to right OR right to left
* Program supports vertical line drawn from top to bottom or bottom to top
* invalid command inputs will prompt an error for user to enter the command again.

## Installing and running
* `mvn test` - Execute this in the application root folder to runs junit tests
* `mvn install` - Execute this in the application root folder to build jar in target folder
* `java -jar DrawingApp.jar` - Execute this to run the program

## Dependencies
* Java 8
* Maven


