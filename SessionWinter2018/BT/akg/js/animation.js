function setup() {
    createCanvas(innerWidth, innerHeight);
}

let size = 70;
let speed = 500;

let pos = {
    x: size * 2,
    y: size * 2
}
let adding = 0;
let morph = 0;
let type = "rect"

function draw() {
    if (type === "rect") {
        if (pos.x + 50 >= innerWidth) return;
        background(255);

        strokeWeight(2);
        stroke(150);
        fill(150, 0, 150);
        line(
            innerWidth / 2, 0,
            innerWidth / 2, innerHeight
        )
        
        noStroke();
        fill(150, 0, 150);
        quad(
            pos.x - size + morph, pos.y - size,
            pos.x + size - morph, pos.y - size,
            pos.x + size, pos.y + size - morph,
            pos.x - size, pos.y + size - morph
        )

        triangle(
            pos.x - size, pos.y + size - morph,
            pos.x + size, pos.y + size - morph,
            pos.x, pos.y + size - morph + adding
        );


        if (pos.x > innerWidth / 2)
            adding += 0.15;

        if (morph < innerWidth / 2)
            morph += 0.1;


        let yStep = innerHeight / speed;
        let xStep = innerWidth / speed;

        pos.x += xStep;
        pos.y += yStep;
    } else {
        if (pos.x + 25 >= innerWidth) return;

        background(255);
        strokeWeight(2);
        stroke(150);
        fill(150, 0, 150);
        line(
            innerWidth / 2, 0,
            innerWidth / 2, innerHeight
        )

        // left
        line(
            pos.x - size + morph, pos.y - size,
            pos.x - size, pos.y + size - morph,
        );
        // bot-r
        line(
            pos.x + size, pos.y + size - morph,
            pos.x, pos.y + size - morph + adding
        );
        // bot-l
        line(
            pos.x, pos.y + size + adding - morph,
            pos.x - size, pos.y + size - morph
        );
        // right
        line(
            pos.x + size - morph, pos.y - size,
            pos.x + size, pos.y + size -  morph
        );
        // top
        line(
            pos.x - size + morph, pos.y - size,
            pos.x + size - morph, pos.y - size
        );

        let speed = 800;
        let yStep = Math.floor(innerHeight / speed);
        let xStep = Math.floor(innerWidth / speed);

        if (morph < 25);
            morph += speed / 1000;


        if (pos.x > innerWidth / 2) {
            if (adding < 35) {
                adding += 0.04;
            }
        }

        pos.x += xStep;
        pos.y += yStep;
    }
}

function getFPS() {
    console.log(1000 / 30 - 3);
}

// setInterval(drawFunc, 1000 / 30 - 3);