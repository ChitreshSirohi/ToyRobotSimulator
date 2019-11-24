# ToyRobotSimulator
Toy Robot Simulator - Solution


How to run the program - 

find the executable jar “ToyRobotSimulator.jar” and provide a text file with all the command in it. Here is the command sample

java -jar ToyRobotSimulator.jar <fileNameWithPath>



Classes and description

Command.java - This is a java enum that contains all the valid commands for the simulator.

Direction.java - This too is a java enum that contains name of 4 sides namely North,East,South,West. This enum is also used to evaluate the next direction when a Right or a Left command is executed. 

Position.java - Used to depict the location and the direction of the Robot. This class also have getStringFormat method that emits the output in a required format as per REPORT command

Robot.java - This class accepts and executes all the commands and updates the position for the Robot. All the logic for command can be found in this class. 

TableTop.java - This class represents boundary of limit of the Robot movement. It also contains a method that whether a particular position is within the boundary or not.

SimulatorStart.java - Used to start the Program, it accepts a text file as an command line argument. The text file should provide each command on a new line.

RobotTest.java - This file is not included in the jar but source can be viewed to see tests and results. It is based on Junit5


Test Data
find the file commands.txt the same data is used in Unit test

Results of test data execution
Results of the test data can be found in the UnitTest java file. Please view every assert statement.
The index is 0 based.

Assumptions

Ignore the Invalid commands - this also includes any commands that have typos and syntax error
Command are case insensitive
Leading and trailing spaces of the command will be trimmed 
for eg.” plaCe   2  ,  4  ,   north  “ is a valid command

Improvements 

Use circular list than a list to calculate direction
The Solution is good for the current requirement but if there are some additional requirement comes up like turning 45 degrees and moving several places in one command, then it will required to be upgraded.
