; Exercise 2.4
;
; Here is an alternative procedural representation of pairs. For this 
; representation, verify that (car (cons x y)) yields x for any objects x and y.  
;
; (define (cons x y)
;   (lambda (m) (m x y)))
; 
; (define (car z)
;   (z (lambda (p q) p)))
; 
; What is the corresponding definition of cdr? (Hint: To verify that this works, 
; make use of the substitution model of section 1.1.5.) 

(defn my-cons
  [x y]
  (fn [m] (m x y)))

(defn my-car
  [z]
  (z (fn [p q] p)))

(defn my-cdr
  [z]
  (z (fn [p q] q)))

(def x (my-cons 1 2))
(println x)
(println (my-car x))
(println (my-cdr x))
