(defn first-denomination
  [kinds-of-coins]
  (cond
    (= kinds-of-coins 1) 1
    (= kinds-of-coins 2) 5
    (= kinds-of-coins 3) 10
    (= kinds-of-coins 4) 25
    (= kinds-of-coins 5) 50))

(defn cc
  [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount
                 (- kinds-of-coins 1))
             (cc (- amount
                    (first-denomination kinds-of-coins))
                 kinds-of-coins))))

(defn count-change
  [amount]
  (cc amount 5))

(println (count-change 100))
; Answer = 292
(println (count-change 11))
; Answer = 4

(defn cube
  [x]
  (* x x x))

(defn p 
  [x]
  (- (* 3 x) (* 4 (cube x))))

(defn sine
  [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

(defn square
  [x]
  (* x x))

; Algorithm for computing exponents using successive squaring
; of even-numbered exponents to achieve O(log n) performance.
(defn fast-expt
  [b n]
  (cond
    (= n 0) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (- n 1)))))

; Section 1.2.5
; Procedure for finding the Greatest Common Divisor of two integers.
(defn gcd
  [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

; Section 1.2.6
; Procedures for determining whether an integer is a prime number.
; This algorithm has an order of O(sqrt n).
(defn divides?
  [a b]
  (= (rem b a) 0))

(defn find-divisor
  [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor
  [n]
  (find-divisor n 2))

(defn prime?
  [n]
  (= n (smallest-divisor n)))

; Fermat's test
(defn expmod
  [base exp m]
  (cond
    (= exp 0) 1
    (even? exp) (rem (square (expmod base (/ exp 2) m))
                                     m)
    :else (rem (* base (expmod base (- exp 1) m))
                               m)))

