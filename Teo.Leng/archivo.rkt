#lang racket/base

(define pares '(0 2 4 6 8))
(car pares) ; resulta 0
(cdr pares) ; resulta (2 4 6 8)
(cons 1 (cdr pares)) ; resulta (1 2 4 6 8)
(null? '()) ; resulta #t
(equal? 5 '(5)) ; resulta #f
(append '(1 3 5) pares) ; resulta (1 3 5 0 2 4 6 8)
(list '(1 3 5) pares) ; resulta ((1 3 5) (0 2 4 6 8))

;-----------------------------------------------------------------------------------------2

((lambda (x) (* x x)) 6)
(define square (lambda (x) (* x x)))
(square 4)
(define (sq x) (* x x))
(sq 5)




