; Exercise 1.20
; The equation below describes a process that finds the 
; Greatest Common Divisor of two numbers using Euclid's Algorithim.

(defn gcd
  [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

; Using the substitution method (for normal order), illustrate 
; the process generated in evaluating (gcd 206 40) and indicate 
; the remainder operations that are actually performed. 
;
; Normal-order evaluation {{{
; How many remainder operations are actually performed in the 
; normal-order evaluation of (gcd 206 40)? 
(gcd 206 40)
(if (= 40 0)
  206
  (gcd 40 (rem 206 40)))

(if (= (rem 206 40) 0) ; Evaluates to 6
  40
  (gcd (rem 206 40) (rem 40 (rem 206 40))))

(if (= (rem 40 (rem 206 40)) 0) ; Evaluates to 4
  (rem 206 40)
  (gcd (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40)))))

(if (= (rem (rem 206 40) (rem 40 (rem 206 40))) 0) ; Evaluates to 2
  (rem 40 (rem 206 40))
  (gcd (rem (rem 206 40) (rem 40 (rem 206 40))) (rem (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40))))))

(if (= (rem (rem 40 (rem 206 40)) (rem (rem 206 40) (rem 40 (rem 206 40)))) 0) ; Evaluates to 0 which breaks the loop.
  (rem (rem 206 40) (rem 40 (rem 206 40)))) ; Final consequent expression. Return value = 2

; How many times is the 'rem' operation performed in the example above?
; Answer = 18
;
; Why?  
; The 'if' special form always evaluates the predicate expression. 
; Therefore all of the 'rem' procedures in the predicate expressions are 
; performed for each iteration in the illustration above.
; Next the final consequent expression is evaluated and its 'rem' procedures are
; preformed.
; }}}


; In the applicative-order evaluation? 
(gcd 206 40)

(if (= 40 0)
  206
  (gcd 40 (rem 206 40)))

(gcd 40 6)
(if (= 6 0)
  40
  (gcd 6 (rem 40 6)))

(gcd 6 4)
(if (= 6 0)
  6
  (gcd 4 (rem 6 4)))

(gcd 4 2)
(if (= 2 0)
  4
  (gcd 2 (rem 4 2)))

(gcd 2 0)
(if (= 0 0)
  2) ; Return the consequent expression. Evaluates to 2.

; How many remainder operations are performed?
; Answer = 4
;
; Why?
; Applicative-order evaluation applies the remainder procedure for each
; iteration above, and uses its value as the argument to 'gcd' in each 
; iteration.
