; Exercise 1.18
;
; Using the results of exercises 1.16 and 1.17, devise a procedure that 
; generates an iterative process for multiplying two integers in terms of 
; adding, doubling, and halving and uses a logarithmic number of steps.
 
(defn dbl
  [x]
  (+ x x))

(defn halve
  [x]
  (/ x 2))

(defn multi-iter
  [x y product]
  (cond 
    (= y 0) (+ 0 product)
    (= y 1) (+ x product)
    (even? y) (multi-iter (dbl x) (halve y) product)
    :else (multi-iter (dbl x) (halve (- y 1)) (+ x product))))

(defn my-multiply
  [x y]
  (multi-iter x y 0))


; Test that multiplying by zero yields zero.
(println (my-multiply 2 0))
(println (my-multiply 0 10))

; Test that multiplying x and one yields x.
(println (my-multiply 5 1))
(println (my-multiply 1 5))

; These test cases should have the same output as Exercise 1.17.
(println (my-multiply 2 2))
(println (my-multiply 2 3))
(println (my-multiply 2 10))

