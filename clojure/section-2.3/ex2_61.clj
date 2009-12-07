; Exercise 2.61
;
; Give an implementation of adjoin-set using the ordered representation. By 
; analogy with element-of-set? show how to take advantage of the ordering to 
; produce a procedure that requires on the average about half as many steps 
; as with the unordered representation. 

(use 'clojure.test)

(defn element-of-set?
  [x s]
  (cond
    (empty? s) false
    (= x (first s)) true
    (< x (first s)) false
    :else (element-of-set? x (rest s))))

(defn adjoin-set
  [x s]
  (cond
    (empty? s) (list x)
    (= x (first s)) s
    (< x (first s)) (cons x s)
    :else (cons (first s)
                (adjoin-set x (rest s)))))

(deftest adjoin-set-tests
  (is (= true (element-of-set? 1 '(1 2 3))))
  (is (= true (element-of-set? 5 '(1 2 3 4 5 6))))
  (is (= '(1) (adjoin-set 1 '())))
  (is (= '(1 2 3) (adjoin-set 3 '(1 2 3))))
  (is (= '(1 2 3 4) (adjoin-set 1 '(2 3 4))))
  (is (= '(1 2 3 4) (adjoin-set 4 '(1 2 3))))
  (is (= '(5 15 20 30) (adjoin-set 20 '(5 15 30))))
)

(run-tests)
