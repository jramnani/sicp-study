; Exercise 2.62
;
; Give an O(n) implementation of union-set for sets represented as ordered
; lists.

(use 'clojure.test)

(defn element-of-set?
  [x s]
  (cond
    (empty? s) false
    (= x (first s)) true
    (< x (first s)) false
    :else (element-of-set? x (rest s))))

(defn union-set
  [set1 set2]
  (cond
    (empty? set1) set2
    (empty? set2) set1
    :else (let [x1 (first set1)
                x2 (first set2)]
            (cond
              (= x1 x2) (cons x1 (union-set (rest set1) (rest set2)))
              (< x1 x2) (cons x1 (union-set (rest set1) set2))
              :else (cons x2 (union-set set1 (rest set2)))))))

(deftest union-set-tests
  (is (= '(1 2) (union-set '(1 2) '())))
  (is (= '(3 4) (union-set '() '(3 4))))
  (is (= '(1 2 3 4) (union-set '(1 2) '(3 4))))
  (is (= '(1 2 3 4) (union-set '(1 2 3) '(2 3 4))))
  (is (= '(5 15 30 90) (union-set '(5 90) '(15 30))))
)

(run-tests)
