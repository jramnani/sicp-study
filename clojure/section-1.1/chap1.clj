(defn square
  [x]
  (* x x))

(defn sum-of-squares
  [x y]
  (+ (square x) (square y)))

(defn abs
  [x]
  (cond
    (< x 0) (- x)
    :else x))

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn good-enough?
  [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))
(defn sqrt
  [x]
  (sqrt-iter 1.0 x))

;; TESTS
(println (sqrt 2))
(println (sqrt 9))
(println (sqrt 25))
(println (sqrt 1024))
(println (sqrt 6000000000000))
(println (sqrt 0.05))
(println (sqrt 0.0001))
