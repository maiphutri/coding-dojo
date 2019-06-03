// 3 is cherry;
// 2 is brick;
// 1 is coin;
// 0 is empty;
var world = [
  [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2], //0
  [2,0,1,1,1,2,1,1,1,3,1,1,1,1,2,1,1,1,1,2], //1
  [2,1,2,2,1,2,1,2,2,2,2,2,2,1,2,1,2,2,1,2], //2
  [2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2], //3
  [2,1,2,1,2,2,1,2,2,0,0,2,2,1,2,2,1,2,1,2], //4
  [0,1,1,1,1,1,1,2,0,0,0,0,2,1,1,1,1,1,3,0], //5
  [2,1,2,1,2,2,1,2,2,2,2,2,2,1,2,2,1,2,1,2], //6
  [2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2], //7
  [2,1,2,2,1,2,1,2,2,2,2,2,2,1,2,1,2,2,1,2], //8
  [2,1,1,3,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2], //9
  [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2], //10
];

var pacman = {
  x: 1,
  y: 1
};

var ghost = {
  x: 10,
  y: 5
};

var score = 0;
var interval;
var ghostInterval;
setInterval(function(){
  if (world[ghost.y-1][ghost.x] != 2) {
    ghostInterval = setInterval(function() {
      if (world[ghost.y-1][ghost.x] != 2) {
        ghost.y--;
        displayGhost();
      } else {
        clearInterval(ghostInterval);
      }
    },500)
  } 
  if (world[ghost.y+1][ghost.x] != 2) {
    ghostInterval = setInterval(function() {
      if (world[ghost.y+1][ghost.x] != 2) {
        ghost.y++;
        displayGhost();
      } else {
        clearInterval(ghostInterval);
      }
    },500)
  }

  if (world[ghost.y][ghost.x-1] != 2) {
    ghostInterval = setInterval(function() {
      if (world[ghost.y][ghost.x-1] != 2) {
        ghost.x--;
        displayGhost();
      } else {
        clearInterval(ghostInterval);
      }
    },500)
  }

  if (world[ghost.y][ghost.x+1] != 2) {
    ghostInterval = setInterval(function() {
      if (world[ghost.y][ghost.x+1] != 2) {
        ghost.x++;
        displayGhost();
      } else {
        clearInterval(ghostInterval);
      }
    },500)
  }

}, 500)

document.onkeydown = (e) => {
  if (e.keyCode == 39 && world[pacman.y][pacman.x+1] != 2) {
    clearInterval(interval);
    document.getElementById("pacman").style.transform = "rotate(0deg)"
    interval = setInterval(function() {
      if (world[pacman.y][pacman.x+1] !== 2) {
        pacman.x++;
        displayPacman();
        if (world[pacman.y][pacman.x] == 1) {
          world[pacman.y][pacman.x] = 0;
          score += 10;
        }
        if(world[pacman.y][pacman.x] == 3) {
          world[pacman.y][pacman.x] = 0;
          score += 50;
        }
        displayWorld();
        displayScore();
      } else {
        clearInterval(interval);
      }
    }, 500);
  }
  
  if (e.keyCode == 37 && world[pacman.y][pacman.x-1]!= 2) {
    clearInterval(interval);
    document.getElementById("pacman").style.transform = "rotate(180deg)";
    interval = setInterval(function() {
      if (world[pacman.y][pacman.x-1] !== 2) {
        pacman.x--;
        displayPacman();
        if (world[pacman.y][pacman.x] == 1) {
          world[pacman.y][pacman.x] = 0;
          score += 10;
        }
        if(world[pacman.y][pacman.x] == 3) {
          world[pacman.y][pacman.x] = 0;
          score += 50;
        }
        displayWorld();
        displayScore();
      } else {
        clearInterval(interval);
      }
    }, 200);
  }
  if (e.keyCode == 40 && world[pacman.y+1][pacman.x] != 2) {
    clearInterval(interval);
    document.getElementById("pacman").style.transform = "rotate(90deg)";
    interval = setInterval(function() {
      if (world[pacman.y+1][pacman.x] !== 2) {
        pacman.y++;
        displayPacman();
        if (world[pacman.y][pacman.x] == 1) {
          world[pacman.y][pacman.x] = 0;
          score += 10;
        }
        if(world[pacman.y][pacman.x] == 3) {
          world[pacman.y][pacman.x] = 0;
          score += 50;
        }
        displayWorld();
        displayScore();
      } else {
        clearInterval(interval);
      }
    }, 200);
  }
  if (e.keyCode == 38 && world[pacman.y-1][pacman.x] != 2) {
    clearInterval(interval);
    document.getElementById("pacman").style.transform = "rotate(-90deg)";
    interval = setInterval(function() {
      if (world[pacman.y-1][pacman.x] !== 2) {
        pacman.y--;
        displayPacman();
        if (world[pacman.y][pacman.x] == 1) {
          world[pacman.y][pacman.x] = 0;
          score += 10;
        }
        if(world[pacman.y][pacman.x] == 3) {
          world[pacman.y][pacman.x] = 0;
          score += 50;
        }
        displayWorld();
        displayScore();
      } else {
        clearInterval(interval);
      }
    }, 200);
  }
}

displayWorld();


function displayGhost() {
  document.getElementById("ghost").style.top = ghost.y * 20 + "px";
  document.getElementById("ghost").style.left = ghost.x * 20 + "px";
}
function displayPacman() {
  document.getElementById("pacman").style.top = pacman.y * 20 + "px";
  document.getElementById("pacman").style.left = pacman.x * 20 + "px";
  if (document.getElementById("pacman").style.top == "100px" && document.getElementById("pacman").style.left == "0px") {
    document.getElementById("pacman").style.transition = "step-end";
    setTimeout(function(){
      pacman.x = 21;
      pacman.y = 5;
      document.getElementById("pacman").style.transition = "all .2s ease-out"
    },100)
  }
}

function displayScore() {
  document.getElementById("score").innerHTML = score;
}

function displayWorld() {
  var output = '';

  for (var i=0; i < world.length; i++) {
    output += "\n<div class='row'>\n";
    for (var j=0; j < world[i].length; j++) {
      if (world[i][j] === 3) {
        output += "<div class='cherry'></div>"
      }
      if (world[i][j] === 2) {
        output += "<div class='brick'></div>";
      }
      if (world[i][j] === 1) {
        output += "<div class='coin'></div>";
      }
      if (world[i][j] === 0) {
        output += "<div class='empty'></div>";
      }
    }
    output += "\n</div>";
  }
  document.getElementById("world").innerHTML = output;
}