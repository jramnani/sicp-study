; Procedures that define rational numbers.
; The book uses 'cons' to construct a 'pair' who's contents are the 
; numerator and the denominator.
;
; Clojure does not have an equivalent data type of 'pair' that can be
; constructed via 'cons'.  Therefore, I am using (list) to construct
; a list containing the numerator and the denominator.
;
; Since 'cdr'/'rest' returns a list, instead of just the second item 
; in a pair, use clojure's 'last' to mimic the functionality.

;
; The Greatest Common Divisor procedure from Section 1.2.5
(defn gcd
  [a b]
  (if (= b 0)
    a
    (gcd b (rem a b))))

(defn make-rat
  [n d]
  (let [g (gcd n d)]
    (list (/ n g) (/ d g))))

(defn numer
  [x]
  (first x))

(defn denom
  [x]
  (last x))

(defn print-rat
  [x]
  (println)
  (println (first x) "/" (last x)))

(defn add-rat
  [x y]
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn sub-rat
  [x y]
  (make-rat (- (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

(defn mul-rat
  [x y]
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(defn div-rat
  [x y]
  (make-rat (* (numer x) (denom y))
            (* (denom x) (numer y))))

(defn equal-rat?
  [x y]
  (= (* (numer x) (denom y))
     (* (numer y) (denom x))))


(def one-half (make-rat 1 2))
(def one-third (make-rat 1 3))
(println one-half)
(println "Numerator: " (numer one-half))
(println "Denominator: " (denom one-half))
(print-rat one-half)
(print-rat (add-rat one-half one-third)) ; 5 / 6
(print-rat (mul-rat one-half one-third)) ; 1 / 6
(print-rat (add-rat one-third one-third)) ; 6 / 9
