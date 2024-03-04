#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>
#include <ncurses.h>

#define WIDTH 40
#define HEIGHT 20
#define INITIAL_SNAKE_LENGTH 5
#define DELAY 100000

typedef struct {
    int x, y;
} point;

typedef struct {
    point head;
    point body[WIDTH * HEIGHT];
    int length;
    char dir;
} snake;

typedef struct {
    point pos;
    bool eaten;
} food;

void init_ncurses() {
    initscr();
    cbreak();
    noecho();
    curs_set(0);
    keypad(stdscr, TRUE);
    timeout(0);
}

void draw_snake(snake s) {
    mvprintw(s.head.y, s.head.x, "@");
    for (int i = 0; i < s.length; i++) {
        mvprintw(s.body[i].y, s.body[i].x, "#");
    }
}

void move_snake(snake *s) {
    for (int i = s->length - 1; i > 0; i--) {
        s->body[i] = s->body[i - 1];
    }
    s->body[0] = s->head;
    switch (s->dir) {
        case 'w': s->head.y--; break;
        case 's': s->head.y++; break;
        case 'a': s->head.x--; break;
        case 'd': s->head.x++; break;
    }
}

void generate_food(food *f, snake s) {
    do {
        f->pos.x = rand() % WIDTH;
        f->pos.y = rand() % HEIGHT;
        f->eaten = false;
    } while (mvinch(f->pos.y, f->pos.x) != ' ' || (f->pos.x == s.head.x && f->pos.y == s.head.y));
}

void draw_food(food f) {
    mvprintw(f.pos.y, f.pos.x, "*");
}

bool check_collision(snake s) {
    if (s.head.x < 0 || s.head.x >= WIDTH || s.head.y < 0 || s.head.y >= HEIGHT) {
        return true;
    }
    for (int i = 0; i < s.length; i++) {
        if (s.body[i].x == s.head.x && s.body[i].y == s.head.y) {
            return true;
        }
    }
    return false;
}

int main() {
    init_ncurses();

    snake s = {
        .head = {WIDTH / 2, HEIGHT / 2},
        .length = INITIAL_SNAKE_LENGTH,
        .dir = 'w'
    };

    for (int i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
        s.body[i] = (point){s.head.x, s.head.y + i + 1};
    }

    food f;
    generate_food(&f, s);

    int ch;
    while (1) {
        clear();
        draw_snake(s);
        draw_food(f);
        refresh();

        ch = getch();
        if (ch != ERR) {
            switch (ch) {
                case 'w':
                case 'a':
                case 's':
                case 'd':
                    if (abs(ch - s.dir) != 1) {
                        s.dir = ch;
                    }
                    break;
                case 'q':
                    endwin();
                    return 0;
            }
        }

        move_snake(&s);

        if (s.head.x == f.pos.x && s.head.y == f.pos.y) {
            s.length++;
            generate_food(&f, s);
        }

        if (check_collision(s)) {
            mvprintw(HEIGHT / 2, WIDTH / 2 - 4, "Game Over!");
            refresh();
            usleep(2000000);
            endwin();
            return 0;
        }

        usleep(DELAY);
    }

    endwin();
    return 0;
}
