; Section 2.3 - Symbolic Data

(defn memq
  [item x]
  (cond
    (empty? x) false
    (= item (first x)) x
    :else (memq item (rest x))))

(println (memq 'apple '(pear bannana prune)))
(println (memq 'apple '(x (apple sauce) y apple pear)))

