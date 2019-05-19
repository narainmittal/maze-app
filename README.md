# maze-app
This is a Java project to implement the Maze Problem. There are 2 parts in the project.

## Maze Generator
The program generates a maze for an input grid definition, i.e. # of rows & columns. Algorithm for generation
- Depth First Search (Backtracking)

## Maze Solution
The program tries to solve the input maze by trying to find a path from start to end. Algorithms available for solution:
- Depth First Search (Recursive Backtracking)
- Breadth First Search

_The BFS algorithm also finds the shortest solution path_

## Run as Spring Boot app
Execute below command
```
./gradlew run
```

Once the startup is complete, you can test the application health by below URL in browser or CURL

http://localhost:8080/maze-app/health

## Run as standalone Java

The sample (MazeRunner.java) includes a test run on the project. It tries to first generate a 20*20 maze and then solves them with both DFS and BFS algorithms. 

The output looks something like below (although will change on every execution as the generation is randomized)


```


-------------DFS---------------
true
 * xxx         xxx                   *  *  * xxx
 * xxx   xxx   xxx   xxxxxxxxxxxxxxx * xxx * xxxxxxxxx   xxxxxx
 * xxx   xxx         xxx *  *  *  *  * xxx *  *  * xxx
 * xxxxxxxxxxxxxxxxxxxxx * xxxxxxxxxxxxxxxxxxxxx * xxxxxxxxx
 *  *  *  *  *  *  * xxx * xxx               xxx *  *  * xxx
xxxxxxxxxxxxxxxxxx * xxx * xxx   xxxxxxxxxxxxxxxxxxxxx * xxx
   xxx *  *  * xxx *  *  * xxx *  *  *  *  *       xxx *  *  *
   xxx * xxx * xxxxxxxxxxxxxxx * xxxxxxxxx * xxxxxxxxxxxxxxx *
 *  *  * xxx *  *  *  *  * xxx * xxx *  *  * xxx *  *  *  *  *
 * xxxxxxxxxxxxxxxxxxxxx * xxx * xxx * xxx   xxx * xxxxxxxxxxxx
 *  *  * xxx *  *  * xxx *  *  * xxx * xxx   xxx * xxx
xxxxxx * xxx * xxx * xxxxxxxxxxxxxxx * xxxxxxxxx * xxx   xxxxxx
 *  *  * xxx * xxx * xxx *  *  * xxx * xxx *  *  * xxx
 * xxxxxxxxx * xxx * xxx * xxx * xxx * xxx * xxxxxxxxxxxxxxx
 * xxx *  *  * xxx *  *  * xxx *  *  * xxx *  *  *  *  * xxx
 * xxx * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx
 * xxx *  *  *  *  *  *  *  *  *  *  *  *  *  *  * xxx * xxx
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx * xxx
 * xxx *  *  *  *  *  *  *  *  *  *  * xxx   xxx *  *  * xxx
 * xxx * xxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx   xxxxxxxxxxxxxxx
 *  *  * xxx                         *  *  *  *  *  *  *  *  *

Solution path size: 177
Time taken 2
-------------BFS---------------
true
 * xxx         xxx                   *  *  * xxx
 * xxx   xxx   xxx   xxxxxxxxxxxxxxx * xxx * xxxxxxxxx   xxxxxx
 * xxx   xxx         xxx *  *  *  *  * xxx *  *  * xxx
 * xxxxxxxxxxxxxxxxxxxxx * xxxxxxxxxxxxxxxxxxxxx * xxxxxxxxx
 *  *  *  *  *  *  * xxx * xxx               xxx *  *  * xxx
xxxxxxxxxxxxxxxxxx * xxx * xxx   xxxxxxxxxxxxxxxxxxxxx * xxx
   xxx *  *  * xxx *  *  * xxx *  *  *  *  *       xxx *  *  *
   xxx * xxx * xxxxxxxxxxxxxxx * xxxxxxxxx * xxxxxxxxxxxxxxx *
 *  *  * xxx *  *  *  *  * xxx * xxx *  *  * xxx *  *  *  *  *
 * xxxxxxxxxxxxxxxxxxxxx * xxx * xxx * xxx   xxx * xxxxxxxxxxxx
 *  *  * xxx *  *  * xxx *  *  * xxx * xxx   xxx * xxx
xxxxxx * xxx * xxx * xxxxxxxxxxxxxxx * xxxxxxxxx * xxx   xxxxxx
 *  *  * xxx * xxx * xxx *  *  * xxx * xxx *  *  * xxx
 * xxxxxxxxx * xxx * xxx * xxx * xxx * xxx * xxxxxxxxxxxxxxx
 * xxx *  *  * xxx *  *  * xxx *  *  * xxx *  *  *  *  * xxx
 * xxx * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx
 * xxx *  *  *  *  *  *  *  *  *  *  *  *  *  *  * xxx * xxx
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx * xxx
 * xxx *  *  *  *  *  *  *  *  *  *  * xxx   xxx *  *  * xxx
 * xxx * xxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx   xxxxxxxxxxxxxxx
 *  *  * xxx                         *  *  *  *  *  *  *  *  *

Solution path size: 177
Time taken 1


```

