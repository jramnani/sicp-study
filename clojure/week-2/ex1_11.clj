;Exercise 1.11.  A function f is defined by the rule that f(n) = n if n<3 and 
;f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>=3. 
;Write a procedure that computes f by means of a recursive process. 
;Write a procedure that computes f by means of an iterative process. 

; Recursive solution:

(defn f ; {{{
  [n]
  (cond
    (< n 3) n
    :else (+ (f (- n 1))
             (* 2 (f (- n 2)))
             (* 3 (f (- n 3))))))
; }}}

; Test some inputs
(println (f 1))
(println (f 4))
(println (f 5))
(println (f 10))
(println (f 20))

; Iterative solution

