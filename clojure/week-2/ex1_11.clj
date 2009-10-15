;Exercise 1.11.  A function f is defined by the rule that f(n) = n if n<3 and 
;f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>=3. 
;Write a procedure that computes f by means of a recursive process. 
;Write a procedure that computes f by means of an iterative process. 

; Recursive solution:

(defn f 
  [n]
  (cond
    (< n 3) n
    :else (+ (f (- n 1))
             (* 2 (f (- n 2)))
             (* 3 (f (- n 3))))))

; Test some inputs
(println "Linear Recursion Results:")
(println (f 1))
(println (f 4))
(println (f 5))
(println (f 10))
(println (f 20))

; Iterative solution
; Given addition of f(n - 1) + 2f(n - 2) + 3f(n - 3)
; we can notice that the value of n shifts downward to the right.
;
; Hence, what was 'a' in one iteration can be shifted to the right 
; and substituded for 'b' in the next, and the value of 'b' can 
; be substituted for the 'c'.  The previous value of 'c' can roll
; off since we don't need it any more.
;
; Once the counter is low enough, return the most recent  calculation of 'a'.
;
(defn f2-iter 
  [a b c counter]
  (cond
    (< counter 3) a 
    :else (f2-iter (+ a (* 2 b) (* 3 c)) a b (dec counter))))

(defn f2
  [n]
  (if (< n 3) 
    n
    (f2-iter 2 1 0 n)))

; Example substitution:
; f2(4)
; (f2-iter 2 1 0 4)
; (f2-iter (+ 2 (* 2 1) (* 3 0)) 2 1 3)
; (f2-iter (+ 4 (* 2 2) (* 3 1)) 4 2 2)
; The counter is now less than 3, so return the most recent calculation of 'a'.
; (+ 4 (* 2 2) (* 3 1) = 11

(println "Iterative Recursion Results:")
(println (f2 1))
(println (f2 4))
(println (f2 5))
(println (f2 10))
(println (f2 20))
