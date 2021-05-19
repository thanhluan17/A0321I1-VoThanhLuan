/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;

    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    };

    this.moveRight = function () {
        this.left += 30;
        console.log('ok: ' + this.left);
    };

    this.moveLeft = function () {
        this.left -= 30;
        console.log('ok: ' + this.left);
    };

    this.moveBottom = function () {
        this.top += 30;
        console.log('ok: ' + this.top);
    };

    this.moveTop = function () {
        this.top -= 30;
        console.log('ok: ' + this.top);
    }

}

let hero = new Hero('cat.png', 20, 30, 150);

function start() {
    if (hero.left < window.innerWidth / 2 - hero.size) {
        hero.moveRight();
        hero.moveBottom();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 300)
}

start();