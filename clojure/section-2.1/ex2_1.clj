; Exercise 2.1
;
; Define a better version of make-rat that handles both positive and negative 
; arguments.  Make-rat should normalize the sign so that if the rational 
; number is positive, both the numerator and denominator are positive, and if 
; the rational number is negative, only the numerator is negative. 

(defn gcd
  [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn make-rat
  [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))

(defn print-rat
  [x]
  (println)
  (println (first x) "/" (last x)))

(print-rat (make-rat -4 10))
(print-rat (make-rat -4 -10))
