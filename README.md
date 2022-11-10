![alt text](https://github.com/ryanviana/PacMan/blob/main/readmeImages/PacMan_-_The_Game.png)

#### Pac-Man game implemented using pure Java

 Pac-Man is a 1980 maze action video game developed for arcades. The player controls Pac-Man, who must eat all the dots inside an enclosed maze while avoiding four colored ghosts. 

### Game Preview
![alt text](https://github.com/ryanviana/PacMan/blob/main/readmeImages/play.gif)
![alt text](https://github.com/ryanviana/PacMan/blob/main/readmeImages/ghost_hunter.gif)
![alt text](https://github.com/ryanviana/PacMan/blob/main/readmeImages/dying.gif)


### For Developers
##### UML
![alt text](https://github.com/ryanviana/PacMan/blob/main/readmeImages/Main.jpg)

##### Designing New Levels

Using your favorite IDE,
 
 1. Open _src_ folder.
 2. Inside it, open the _level_ folder.
 3. The maze is created based on a TXT file. So, you can create a new _level.txt_ to start designing.

Some rules for designing your new maze are,

1. The maze design is create nothing more than zeros and ones. Zeros being free space and ones being walls.
2. The maze must be 31x31.

Finally, you can add your new level into the game by,

1. Opening the _pacmanEngine_ folder.
2. Inside it, open the _gameConstants.java_ file.
3. Include the path to the new file in _levelFiles_ array.

### How to Run
##### Using [NetBeans](https://netbeans.apache.org/download/index.html)
1. Open the project using NetBeans
2. In the src look for PacmanTheGame folder
3. Run the PacmanTheGame.java file
