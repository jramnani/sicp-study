; Exercise 2.54. Two lists are said to be equal? if they contain equal elements 
; arranged in the same order. 
; For example, 
;
; (equal? '(this is a list) '(this is a list)) 
; is true, but 
;
; (equal? '(this is a list) '(this (is a) list)) 
; is false. 
;
; To be more precise, we can deﬁne equal? recursively in terms of 
; the basic eq? equality of symbols by saying that a and b are equal? if they 
; are both symbols and the symbols are eq?, or if they are both lists such that 
; (car a) is equal? to (car b) and (cdr a) is equal? to (cdr b). Using this idea,
; implement equal? as a procedure.

(defn equal? 
  "Determines if two lists are equal"
  [l1 l2]
  (cond
    (and (empty? l1) (empty? l2)) true
    (or (empty? l1) (empty? l2)) false
    :else (and (= (first l1) (first l2)) (= (rest l1) (rest l2)))))

(println (equal? '(this is a list) '(this is a list)))
; true

(println (equal? '(this is a list) '(this (is a) list)))
; false
