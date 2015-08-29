(ns repl-tutorial.looping-conditionals
  (:require [clojure.string :as str])
  )

(def b  (map str/split  (str/split-lines (slurp "resources/people.txt") )  #",") )

(def a (str/split-lines (slurp "resources/people.txt") ))




(doseq [x (range 5) ] (println "add"))


(defn pos-neg-or-zero
  "Determines whether or not n is positive, negative, or zero"
  [n]
  (cond
    (< n 0) "negative"
    (> n 0) "positive"
    :else "zero"))

(let [ c (range 9)]

  (cond
    (<  (count c) 2) "this sequence is < 2"
    (>  (count c) 0) "this sequences is > 0"
    :else "don't know"
    )
  )


(let [country "China"]
  (case country
    "" "no nationality"
    "China" "you are chinese"
    "Germany" "you are german"
    ;this is the default case
    "I don't know which is your country"
    ))


(defn return-nationality [file]
  (dotimes [x (count file )]
            (let [ c  ( (str/split (nth file x ) #",") 4 )  ]
              ;(println "country is " c )
              (case c
                "China"  (println (file x ) "is Chinese")
                "Germany" (println (file x ) "is German")
                nil  (println "no country given")
                (println c)
                ))))

(defn search-name  [file name]
  (doseq  [x  file]
    (let [ n ( (str/split x #",") 1 ) ]
      #_(println n)
      (cond
        ( = name n ) (println "Here is a " name "  " x )
         :else nil #_(println "Name not found" )))))

(search-name a "Gregory")

(defn sname  [file name]
  (loop [ x  file ]
    #_(println "x is " x "\n")
    #_(println "res is " (rest x ))
    ( if (= ((str/split (first x)  #",") 1)  name )  (println "found " name "here " (first x) ) (recur (next x )))
    ))



(defn fact[x]
  (if (<= x 1) 1 (*'  x  (fact (- x 1))  )))

(defn fact-recur [n]
  (loop [x n
         next (dec x)
         total 1]
    (if (> x 1)
      (recur next (dec next) (*' total x))
      total)))
