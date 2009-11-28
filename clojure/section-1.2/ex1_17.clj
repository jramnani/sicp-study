; Exercise 1.17
;
; The exponentiation algorithms in this section are based on performing 
; exponentiation by means of repeated multiplication. In a similar way, 
; one can perform integer multiplication by means of repeated addition. 
; The following multiplication procedure (in which it is assumed that our 
; language can only add, not multiply) is analogous to the 'expt' procedure: 

(defn their-multiply
  [a b]
  (if (= b 0)
    0
    (+ a (* a (- b 1)))))

(println "Reference Implementation")
(println "------------------------")
(println (their-multiply 2 0))
(println (their-multiply 2 2))
(println (their-multiply 2 3))
(println (their-multiply 2 5))
(println) 

; The above algorithm takes a number of steps that is linear in b. Now suppose we 
; include, together with addition, operations double, which doubles an integer, 
; and halve, which divides an (even) integer by 2. Using these, design a 
; multiplication procedure analogous to 'fast-expt' that uses a logarithmic number 
; of steps. 

(defn dbl
  [x]
  (+ x x))

(defn halve
  [x]
  (/ x 2))

(defn my-multiply
  [x y]
  (cond 
    (= y 0) 0
    (= y 1) x
    (even? y) (dbl (my-multiply x (halve y)))
    :else (+ x (my-multiply x (- y 1)))))

; Test that multiplying by zero yields zero.
(println (my-multiply 2 0))
(println (my-multiply 0 10))

; Test that multiplying x and one yields x.
(println (my-multiply 5 1))
(println (my-multiply 1 5))

; Repeat test cases for reference implementation.
(println (my-multiply 2 2))
(println (my-multiply 2 3))
(println (my-multiply 2 10))

