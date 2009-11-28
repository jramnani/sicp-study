; Algorithm for computing exponents using successive squaring
; of even-numbered exponents to achieve O(log n) performance in both
; time and space.

(defn square [x] (* x x))

(defn fast-expt
  [b n]
  (cond
    (= n 0) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (- n 1)))))

(println (fast-expt 2 2))
(println (fast-expt 2 5))
(println (fast-expt 2 10))

; Exercise 1.16
; Create an iterative version of the procedure above that uses
; O(log n) time and O(1) space.
; 
; For a wonderful description of how to convert a recursive procedure
; into an iterative one, check out Jim Weirich's example here:
; http://github.com/jimweirich/sicp-study/blob/master/scheme/week02/recursive_to_iterative.scm

(defn fast-expt
  [b n]
  (let [expt-iter (fn [b n product]
                    (cond (= n 0) product
                      (even? n) (recur (square b) (/ n 2) product)
                      :else (recur b (- n 1) (* b product))))]
    (expt-iter b n 1)))

(println (fast-expt 2 2))
(println (fast-expt 2 5))
(println (fast-expt 2 10))

