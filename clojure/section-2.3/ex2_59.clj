; Exercise 2.59
; Implement the union-set operation for unordered-list representation of sets.

(use 'clojure.test)

(defn element-of-set?
  [x s]
  (cond
    (empty? s) false
    (= x (first s)) true
    :else (element-of-set? x (rest s))))

(defn adjoin-set
  [x s]
  (if (element-of-set? x s)
    s
    (cons x s)))

(defn intersection-set
  [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) '()
    (element-of-set? (first set1) set2) (cons (first set1)
                                              (intersection-set (rest set1) set2))
    :else (intersection-set (rest set1) set2)))

(defn union-set
  [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) set2
    (element-of-set? (first set1) set2) (union-set (rest set1) set2)
    :else (cons (first set1)
                (union-set (rest set1) set2))))

(deftest unordered-set-tests
  (is (= true (element-of-set? 1 '(1 2 3))))
  (is (= '(1 2 3) (adjoin-set 3 '(1 2 3))))
  (is (= '(4 1 2 3) (adjoin-set 4 '(1 2 3))))
  (is (= '(2 3) (intersection-set '(1 2 3) '(2 3 4))))
  (is (= '(1 4 2 3 5 7) (union-set '(1 2 3 4) '(2 3 5 7))))
)

(run-tests)

