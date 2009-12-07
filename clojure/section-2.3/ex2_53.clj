; Exercise 2.53. 
;
; What would the interpreter print in response to evaluating each of the 
; following expressions? 
;
(list 'a 'b 'c) 
; ('a 'b 'c)

(println (list (list 'george)))
; ((george))

(println (rest '((x1 x2) (y1 y2))))
; ((y1 y2))


(println (first (rest '((x1 x2) (y1 y2)))))
; (y1 y2)

(println (seq? (first '(a short list))))
; false

(defn memq
  [item x]
  (cond
    (empty? x) false
    (= item (first x)) x
    :else (memq item (rest x))))

(println (memq 'red '((red shoes) (blue socks))))
; false

(println (memq 'red '(red shoes blue socks)))
; (red shoes blue socks)

