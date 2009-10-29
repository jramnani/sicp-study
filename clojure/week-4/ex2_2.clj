; Exercise 2.2
;
; Consider the problem of representing line segments in a plane. Each segment 
; is represented as a pair of points: a starting point and an ending point. 
; Define a constructor make-segment and selectors start-segment and end-segment 
; that define the representation of segments in terms of points. Furthermore, 
; a point can be represented as a pair of numbers: the x coordinate and the y 
; coordinate. Accordingly, specify a constructor make-point and selectors 
; x-point and y-point that define this representation. Finally, using your 
; selectors and constructors, define a procedure midpoint-segment that takes a 
; line segment as argument and returns its midpoint (the point whose 
; coordinates are the average of the coordinates of the endpoints).
 
(ns ex2_2)

(defn make-point
  [x y]
  (list x y))

(defn x-point
  [p]
  (first p))

(defn y-point
  [p]
  (last p))

(defn make-segment
  [start end]
  (make-point start end))

(defn start-segment
  [seg]
  (first seg))

(defn end-segment
  [seg]
  (last seg))

(defn midpoint-segment
  [seg]
  (let [avg (fn 
              [a b]
              (/ 2 (+ a b)))
        mid-x (avg (x-point (start-segment seg))
                   (x-point (end-segment seg)))
        mid-y (avg (y-point (start-segment seg))
                   (y-point (end-segment seg)))]
    (make-point mid-x mid-y)))

(defn print-point
  [p]
  (println "(" (x-point p) "," (y-point p) ")"))

(def start (make-point 1 2))
(def end (make-point 2 4))
(println "Points and Segments")
(println "-------------------")
(println "Start Point:" start)
(println "End Point:" end)
(def my-segment (make-segment start end))
(println "Segment:" my-segment)
(println "Midpoint:")
(print-point (midpoint-segment my-segment))

; Exercise 2.3
;
; Implement a representation for rectangles in a plane. (Hint: You may want to 
; make use of exercise 2.2.) In terms of your constructors and selectors, 
; create procedures that compute the perimeter and the area of a given 
; rectangle. Now implement a different representation for rectangles. Can you 
; design your system with suitable abstraction barriers, so that the same 
; perimeter and area procedures will work using either representation?

; Length and width as a pair of numbers.
(defn make-rect
  [length width]
  (list length width))

(defn rect-length
  [rect]
  (first rect))

(defn rect-width
  [rect]
  (last rect))

(defn rect-perimeter
  [rect]
  (* 2 (+ (rect-length rect) (rect-width rect))))

(defn rect-area
  [rect]
  (* (rect-length rect) (rect-width rect)))

; Tests
(def my-rect (make-rect 2 4))
(println)
(println "Rectangle as two numbers")
(println "------------------------")
(println "Length: " (rect-length my-rect))
(println "Width: " (rect-width my-rect))
(println "Perimeter: " (rect-perimeter my-rect))
(println "Area: " (rect-area my-rect))


; Rectangle as two segments, length and width.

; length of a segment
; end-x - start-x
; end-y - start-y
(defn segment-distance
  [seg]
  (+ (- (x-point (end-segment seg)) (x-point (start-segment seg)))
     (- (y-point (end-segment seg)) (y-point (start-segment seg)))))

(defn make-rect2
  [s1 s2]
  (let [length (segment-distance s1)
        width (segment-distance s2)]
    (list length width)))

; Tests for rectangle as two segments.
; No changes had to be made in the procedures for area and permimeter.
(def start-len (make-point 0 0))
(def end-len (make-point 0 2))
(def start-wid (make-point 0 0))
(def end-wid (make-point 0 4))
(def len (make-segment start-len end-len))
(def wid (make-segment start-wid end-wid))
(def my-rect (make-rect2 len wid))
(println)
(println "Rectangle as two segments")
(println "-------------------------")
(println "Rectangle:" my-rect)
(println "Length: " (rect-length my-rect))
(println "Width: " (rect-width my-rect))
(println "Perimeter: " (rect-perimeter my-rect))
(println "Area: " (rect-area my-rect))
