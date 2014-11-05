"Pythagorean triples a, b and c, are constructed in the following way:
a = n^2 - m^2
b = 2nm
c = n^2 + m^2
for any positive integers m < n"

(defn triples []
  ; Returns a lazy sequence of Pythagorean triples, constructed as documented above
  (for [m (range 1 50)
        n (range 1 50)
        :when (< m n)]        
    [(- (Math/pow n 2) (Math/pow m 2))
     (* 2 n m)
     (+ (Math/pow n 2) (Math/pow m 2))]))

(defn find-that-triple [s]
  ; Returns that Pythagorean triple [a b c] for which a + b + c = s
  (let [triples (triples)]
    (loop [i 0]
      (let [triple (nth triples i)
            a (first triple)
            b (second triple)
            c (last triple)]
        (if (= (+ a b c) s)
          [a b c]
          (recur (inc i)))))))
      
(println (find-that-triple 1000.0))


