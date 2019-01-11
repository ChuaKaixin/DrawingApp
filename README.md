# DrawingApp

Java Drawing Application - currently supporting console drawing

## Feature Summary
Supports the following commands

Command 		|Description|
--------------------------------
C w h          | Should create a new canvas of width w and height h.							|
L x1 y1 x2 y2  | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.										|
R x1 y1 x2 y2  | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.													|
B x y c        | Should fill the entire area connected to (x,y) with "colour" c. The	 behaviour of this is the same as that of the "bucket fill" tool in paint programs.	|
Q              | Should quit the program.													|

## Assumptions and notes
* colour for bucket fill can only be alphanumeric character including 'x' used for line drawing.
* Program supports horizontal line drawn from left to right OR right to left
* Program supports vertical line drawn from top to bottom or bottom to top
* invalid command inputs will prompt an error for user to enter the command again.

## Installing and running
In the application root folder
* `mvn test` - runs junit tests
* `mvn install` - builds jar in target folder
* `java -jar DrawingApp.jar` - runs program

## Dependencies
* Java 8
* Maven


