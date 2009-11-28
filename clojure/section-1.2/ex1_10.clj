;Exercise 1.10.  The following procedure computes a mathematical function 
;called Ackermann's function.

(defn A 
  [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1)
                 (A x (- y 1)))))

;What are the values of the following expressions?

; This equation has the shape of linear recursion.
(A 1 10)  
;(A 0 (A 1 9))
;(A 0 (A 0 (A 0 8)))
;(A 0 (A 0 (A 0 (A 0 7))))
;(A 0 (A 0 (A 0 (A 0 (A 0 6)))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 5))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4)))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 3))))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 1))))))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 2)))))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 4))))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 (A 0 8)))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 (A 0 16))))))
;(A 0 (A 0 (A 0 (A 0 (A 0 32)))))
;(A 0 (A 0 (A 0 (A 0 64))))
;(A 0 (A 0 (A 0 128)))
;(A 0 (A 0 256))
;(A 0 512)
;1024

; Notice that the shape of the equation below is neither purely linear or 
; iterative recursion.
(A 2 4)  
;(A 1 (A 2 3))
;(A 1 (A 1 (A 2 2)))
;(A 1 (A 1 (A 1 (A 2 1))))
;(A 1 (A 1 (A 1 2)))
;(A 1 (A 1 (A 0 (A 1 1))))
;(A 1 (A 1 (A 0 2)))
;(A 1 (A 1 4))
;(A 1 (A 0 (A 1 3)))
;(A 1 (A 0 (A 0 (A 1 2))))
;(A 1 (A 0 (A 0 (A 0 (A 1 1)))))
;(A 1 (A 0 (A 0 (A 0 2))))
;(A 1 (A 0 (A 0 4)))
;(A 1 (A 0 8))
;(A 1 16)
;....
;65536 

(A 3 3)
; See above.
;65536 

;Consider the following procedures, where A is the procedure defined above:

(defn f [n] (A 0 n))

(defn g [n] (A 1 n))

(defn h [n] (A 2 n))

(defn k [n] (* 5 n n))

;Give concise mathematical definitions for the functions computed by the 
;procedures f, g, and h for positive integer values of n. 
;For example, (k n) computes 5n2. 

;(f n) = 2 * n
;(g n) = 2 ^ n
;(h n) = 2^2 * 2^2
