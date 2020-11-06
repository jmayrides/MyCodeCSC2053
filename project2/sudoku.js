var sol =
    [[0, 7, 0, 2, 3, 8, 0, 0, 0],
    [0, 0, 0, 7, 4, 0, 8, 0, 9],
    [0, 6, 8, 1, 0, 9, 0, 0, 2],
    [0, 3, 5, 4, 0, 0, 0, 0, 8],
    [6, 0, 7, 8, 0, 2, 5, 0, 1],
    [8, 0, 0, 0, 0, 5, 7, 6, 0],
    [2, 0, 0, 6, 0, 3, 1, 9, 0],
    [7, 0, 9, 0, 2, 1, 0, 0, 0],
    [0, 0, 0, 9, 7, 4, 0, 8, 0]];

var printBoard = function () {

    var curr, location;

    //loop through all elements
    for (var i = 0; i < 9; i++) {

        for (var j = 0; j < 9; j++) {

            //get location and store it
            location = 'r' + (i + 1).toString() + (j + 1).toString();
            //add num from matrix to html
            curr = document.getElementById(location);
            curr.innerHTML = sol[i][j];

            //bold nums that we already know just to make it look nice
            //and for easier visibility of nums that were filled in
            if (sol[i][j] > 0) {

                curr.style.fontWeight = 'bold';

            } else {

                curr.style.fontWeight = 'normal';

            }

        }

    }

}

var solve = function () {

    var curr, location, tempI, tempJ;
    var satisfies;
    var lastSaved = [];

    //loop through whole board
    for (var i = 0; i < 9; i++) {

        for (var j = 0; j < 9; j++) {

            //if current num is empty, start checking
            if (sol[i][j] == 0) {

                //checks all possible entry nums
                for (var num = 1; num <= 9; num++) {

                    satisfies = true;

                    //checks all values in row for conflicts
                    for (var row = 0; row < 9; row++) {

                        if (sol[row][j] == num) {

                            satisfies = false;
                            break;

                        }

                    }

                    //checks all values in column for conflicts
                    for (var col = 0; col < 9; col++) {

                        if (satisfies) {

                            if (sol[i][col] == num) {

                                satisfies = false;
                                break;

                            }

                        }

                    }

                    //creates vars at top left corner of box current location is so that box can be looped through
                    if (i > 5) {

                        tempI = 6;

                    } else if (i > 2) {

                        tempI = 3;

                    } else {

                        tempI = 0;

                    }

                    if (j > 5) {

                        tempJ = 6;

                    } else if (j > 2) {

                        tempJ = 3;

                    } else {

                        tempJ = 0;

                    }


                    //checks all values in box for conflict
                    for (var boxR = 0; boxR < 3; boxR++) {

                        for (var boxC = 0; boxC < 3; boxC++) {

                            if (satisfies) {

                                if (sol[tempI + boxR][tempJ + boxC] == num) {

                                    satisfies = false;
                                    break;

                                }

                            }

                        }

                    }

                    //if num satisfies, updates sol, saves location and val in array
                    if (satisfies) {

                        sol[i][j] = num;
                        lastSaved.push(i, j, num);
                        location = 'r' + (i + 1).toString() + (j + 1).toString();
                        curr = document.getElementById(location);
                        curr.innerHTML = sol[i][j];

                        break;

                        //else if we have reached 9 and none have satisified, reset current
                        //num to 0 and move back to last saved num
                    } else if (num == 9) {

                        i = lastSaved[lastSaved.length - 3];
                        j = lastSaved[lastSaved.length - 2];
                        num = (lastSaved[lastSaved.length - 1])++;
                        sol[i][j] = 0;
                        lastSaved.pop();
                        lastSaved.pop();
                        lastSaved.pop();

                    }

                }

            }

        }

    }

}

var newPuzzle = function() {

    var request = new XMLHttpRequest();

    request.open("GET", "https://sugoku.herokuapp.com/board?difficulty=medium", true);
    request.send();
    request.onload = function(){

        var data = JSON.parse(this.response);
        sol = data.board;
        printBoard();

    }

}

printBoard();