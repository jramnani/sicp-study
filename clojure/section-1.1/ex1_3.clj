(defn square
  [x]
  (* x x))

(defn sum-of-squares
  [x y]
  (+ (square x) (square y)))

(defn sum-of-greatest-squares
  [x y z]
  (if (>= x y)
    (sum-of-squares x (if (> y z) y z))
    (sum-of-squares y (if (> x z) x z))))

;; TESTS
(println (sum-of-greatest-squares 2 3 4))
(println (sum-of-greatest-squares 4 3 2))
(println (sum-of-greatest-squares 3 4 2))


