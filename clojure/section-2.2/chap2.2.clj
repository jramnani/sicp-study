(defn list-ref
  [items n]
  (if (= n 0)
    (first items)
    (list-ref (rest items) (- n 1))))

(defn length
  [items]
  (if (empty? items)
    0
    (+ 1 (length (rest items)))))

(defn append
  [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (append (rest list1) list2))))

(defn count-leaves
  [items]
  (cond
    (not (seq? items)) 1
    (empty? items) 0
    :else (+ (count-leaves (first items))
             (count-leaves (rest items)))))

(defn scale-tree
  [tree factor]
  (cond
    (not (seq? tree)) (* tree factor)
    (empty? tree) '()
    :else (cons (scale-tree (first tree) factor)
                (scale-tree (rest tree) factor))))

(defn scale-tree-map
  [tree factor]
  (map (fn [sub-tree]
         (if (seq? sub-tree)
           (scale-tree-map sub-tree factor)
           (* sub-tree factor)))
       tree))

; Signal flow processing

(defn my-filter
  [predicate my-seq]
  (cond 
    (nil? my-seq) nil
    (predicate (first my-seq))
      (cons (first my-seq)
            (filter predicate (rest my-seq)))
    :else (filter predicate (rest my-seq))))

(defn accumulate
  [op initial my-seq]
  (if (empty? my-seq)
    initial
    (op (first my-seq)
        (accumulate op initial (rest my-seq)))))

(defn enumerate-interval
  [low high]
  (if (> low high)
    '()
    (cons low (enumerate-interval (+ low 1) high))))

(defn enumerate-tree
  [tree]
  (cond
    (not (seq? tree)) (list tree)
    (empty? tree) nil
    :else (append (enumerate-tree (first tree))
                  (enumerate-tree (rest tree)))))

(defn square
  [x]
  (* x x))

(defn sum-odd-squares
  [tree]
  (accumulate +
              0
              (map square
                   (filter odd?
                           (enumerate-tree tree)))))

; We can rearrange the pieces and use them in computing the product of the 
; squares of the odd integers in a sequence: 
(defn product-of-squares-of-odd-elements 
  [my-seq]
  (accumulate * 
              1 
              (map square 
                (filter odd? my-seq))))

; accumulate is also called 'fold-right'.
; Here's an implementation of 'fold-left'
(def fold-right accumulate)

(defn fold-left
  [op initial my-seq]
  (let [iter (fn 
               [result remaining]
               (if (empty? remaining)
                 result
                 (recur (op result (first remaining))
                       (rest remaining))))]
  (iter initial my-seq)))

; Tests

(def squares (list 1 4 9 16 25))
(def odds (list 1 3 5 7))
(def squares-and-odds (cons squares odds))

(println (list-ref squares 3)) ; 16
(println (length odds)) ; 4
(println (append squares odds)) ; (1 4 9 16 25 1 3 5 7)
(println)

(println (count-leaves odds)) ; 4
(println (count-leaves squares-and-odds)) ; 9
(println)

(println squares-and-odds) ; ((1 4 9 16 25) 1 3 5 7)
(println (scale-tree squares-and-odds 2)) ; ((2 8 18 32 50) 2 6 10 14)
(println (scale-tree-map squares-and-odds 2)) ; ((2 8 18 32 50) 2 6 10 14)
(println)

(println (filter odd? squares)) ; 1 9 25
(println)

(println (accumulate + 0 odds)) ; 16
(println (accumulate * 1 odds)) ; 105
(println (accumulate cons '() odds)) ; (1 3 5 7)
(println)

(println (enumerate-interval 2 7)) ; (2 3 4 5 6 7)
(println (enumerate-tree squares-and-odds)) ; (1 4 9 16 25 1 3 5 7)
(println)

(println (sum-odd-squares (list 1 2 3 4 5))) ; 35
(println (product-of-squares-of-odd-elements (list 1 2 3 4 5))) ; 225
(println)

(println (fold-right / 1 (list 1 2 3))) ; 3/2
(println (fold-left / 1 (list 1 2 3))) ; 1/6
(println (fold-right list '() (list 1 2 3))) ; (1 (2 (3 ())))
(println (fold-left list '() (list 1 2 3))) ; (((() 1) 2) 3)
(println)
