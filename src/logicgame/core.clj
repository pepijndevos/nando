(ns logicgame.core
  (:use clojure.core.logic)
  (:gen-class))

(defne ando [a b y]
  ([1 1 1])
  ([1 0 0])
  ([0 1 0])
  ([0 0 0]))

(defne oro [a b y]
  ([1 1 1])
  ([1 0 1])
  ([0 1 1])
  ([0 0 0]))

(defne xoro [a b y]
  ([1 1 0])
  ([1 0 1])
  ([0 1 1])
  ([0 0 0]))

(defne noto [a y]
  ([0 1])
  ([1 0]))

(defn inv [goal a b y]
  (fresh [z]
    (goal a b z)
    (noto z y)))

(def nando (partial inv ando))
(def noro (partial inv oro))

(defn tile [N E S W op port]
  (fresh [p1 p2 p3 p4
          ca cb cc cd]
    (== port [ca cb cc cd])
    (permuteo [[:N N] [:E E] [:S S] [:W W]] [p1 p2 p3 p4])
    (matche [op p1 p2 p3 p4]
      ([:and [ca a] [cb b] [cc y] [cd x]]
        (ando a b y) (== x :x))
      ([:or [ca a] [cb b] [cc y] [cd x]]
        (oro a b y) (== x :x))
      ([:nand [ca a] [cb b] [cc y] [cd x]]
        (nando a b y) (== x :x))
      ([:nor [ca a] [cb b] [cc y] [cd x]]
        (noro a b y) (== x :x))
      ([:not [ca a] [cb y] [cc x1] [cd x2]]
        (noto a y) (== x1 :x) (== x2 :x))
      ([:open [ca x1] [cb x2] [cc x3] [cd x4]]
        (== x1 :x) (== x2 :x) (== x3 :x) (== x4 :x))
      ([:w2 [ca a] [cb b] [cc x1] [cd x2]]
        (== a b) (== x1 :x) (== x2 :x))
      ([:w3 [ca a] [cb b] [cc c] [cd x]]
        (== a b) (== b c) (== x :x))
      ([:w4 [ca a] [cb b] [cc c] [cd d]]
        (== a b) (== b c) (== c d)))))

(defn grid [w h]
  (let [numw (* h w)
        hvars (repeatedly numw lvar)]
    (->> hvars (partition w) (map vec) (into []))))

(defn board [size edges gates ports]
  (let [[N E S W] (map vec (partition size edges))
        vvars (vec (concat [N] (grid size (dec size)) [S]))
        hvars (vec (concat [E] (grid size (dec size)) [W]))
        params (for [x (range size)
                     y (range size)]
                 [(get-in vvars [y x])       ; N
                  (get-in hvars [(inc x) y]) ; E
                  (get-in vvars [(inc y) x]) ; S
                  (get-in hvars [x y])       ; W
                  (get-in gates [y x])
                  (get-in ports [y x])])] 
    (everyg #(apply tile %) params)))


(defn -main
  "I don't do a whole lot ... yet."
  [strsize strnum & stredges]
  (let [size (Integer/parseInt strsize)
        numres (Integer/parseInt strnum)
        pattern (map read-string stredges)
        edges (vec (take (* 4 size) (cycle pattern)))
        ops (grid size size)
        ports (grid size size)]
    (println
      (run numres [opg portg]
        (== opg ops)
        (== portg ports)
        (board size edges ops ports)))))
