; Exercise 1.44. 
;
; If f is a function and dx is some small number, then the smoothed version of 
; f is the function whose value at a point x is the average of f (x − dx), 
; f (x), and f (x + dx). Write a procedure smooth that takes as input a procedure 
; that computes f and returns a procedure that computes the smoothed f . It is 
; sometimes valuable to repeatedly smooth a function (that is, smooth the 
; smoothed function, and so on) to obtained the n-fold smoothed function. Show 
; how to generate the n-fold smoothed function of any given function using smooth 
; and repeated from exercise 1.43. 

(defn avg
  [x y z]
  (/ (+ x y z)
     3))

(defn square 
  [x] 
  (* x x))

(defn smooth
  [f]
  (let [dx 0.001]
    (fn 
      [x] 
      (avg (f (- x dx)) 
           (f x) 
           (f (+ x dx))))))

(def myfunc (smooth square))
(println (myfunc 5))

; Run the 'smooth' procedure 'n' times.
(defn n-smooth 
  [f n]
  (if (= 1 n)
    (smooth f)
    (smooth (n-smooth f (dec n)))))

(def myfunc (n-smooth square 3))
(println ((n-smooth square 4) 5))

