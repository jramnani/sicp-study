; Exercise 2.17. Deﬁne a procedure last-pair that returns the list that contains only the last element of a given (nonempty) list:
;(last-pair (list 23 72 149 34)) 
;(34) 
;

(defn last-pair
  [items]
  (if (empty? (rest items))
    (first items)
    (last-pair (rest items))))

(defn list-reverse
  [items]
  (if (empty? items)
    items
    (cons (first items) (rest items))))

; Tests
(println (last-pair (list 23 72 149 34))) ; 34
(println (reverse (list 1 4 9 16 25))) ; (25 16 9 4 1)
