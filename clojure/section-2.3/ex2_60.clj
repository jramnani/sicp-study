; Exercise 2.60
;
; Suppose we change the representation of sets to be
; lists which allow duplicate entries. What do element-of-set?,
; adjoin-set, union-set, and intersection-set look like?
; How does the efficiency compare?
; Would you ever want to use this representation

(use 'clojure.test)

(defn element-of-set?
  [x s]
  (cond
    (empty? s) false
    (= x (first s)) true
    :else (element-of-set? x (rest s))))

; Since duplicates are allowed, go ahead and add anything to the list.
(def adjoin-set cons)

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

(deftest set-tests
  (is (= true (element-of-set? 1 '(1 2 3))))
  (is (= '(3 1 2 3) (adjoin-set 3 '(1 2 3))))
  (is (= '(4 1 2 3) (adjoin-set 4 '(1 2 3))))
  (is (= '(3 4) (intersection-set '(1 2 3 4) '(3 4 5))))
  ; Note the bug in intersection-set below. All dupes not removed.
  (is (= '(2 2 3 3) (intersection-set '(1 2 2 3 3) '(2 2 3 4 4 4))))
  (is (= '(1 4 2 3 5 7) (union-set '(1 2 3 4) '(2 3 5 7))))
)

(run-tests)

; How does the efficiency compare?
; Storage will be larger because duplicates are allowed.  This means that 
; element-of-set? will take longer to compute, and correspondingly affect
; intersection-set and union-set.
;
; Would you ever want to use this representation?
; It would make sense to use this representation if you were optimizing for
; adjoin-set which, in this implementation, is O(1).
