(ns repl-tutorial.core
  (:gen-class)
  (:require [clojure.string :as str])
  )
;; REPL  tutorial
;; get the contents of the people.txt file as vector of strings

(def a (str/split-lines (slurp "resources/people.txt")))

(defn  return-names [file]
  (for [x (rest file ) ]
    (let [ fields   (str/split x #",")]
      (fields 1))))

;;eval this statement
(return-names a)

; let's fetch a record with the name as parameter
(defn return-person-named [name file]
  (for [x (rest file )
        :let  [person-name ( (str/split x #",")  1) ]
        :when (= name person-name)]
    x))

;; Workshop 3  Data structures and functions

;; clojure strings are java ones

"I'm a string"
(type "I'm a string")

;; Lists

'(1 2 3 x t x s g)
(list 1 2 3 'x 't 's 'g)

;; Vectors

[1 2 3]

(vec [1 2 3 "green"])

(vector [1 2 3 "green"])

;;Vectors are functions, that means you could evaluate them to their indexes.

([1 2 3] 0)

;;You could check if a symbol references a vector with the function

(vector? [1 2 4])

; Hashmap

{:str 13 :char 10 :dex 20 :wis 8}

;You could also type :

(hash-map :str 13 :char 10 :dex 20 :wis 8)

; there is also sorted-map data structure

(sorted-map :str 13 :char 10 :dex 20 :wis 8)

;Maps are also functions so evaluating this map to one of the keys we get the value.

({:str 13 :char 10 :dex 20 :wis 8} :str)

;Maybe you want the keys from a map.

(keys {:str 13 :char 10 :dex 20 :wis 8})

;Or just the values .

(vals {:str 13 :char 10 :dex 20 :wis 8})


;; sets

#{1 2 3 4 5 7 8 999 9}


(hash-set :a 1 :b 2 :c 1 4)

(sorted-set 999 99 99 11 223 444 55 6677 88 99)

((hash-set :a 1 :b 2 :c 1 4) 1)

((hash-set :a 1 :b 2 :c 1 4) "monday")

(sorted-set-by > 2 3 4 5 6 9 10)


(defn test_comparator [a b]
  (if (and (even? b) (> b a) false true)))

(sorted-set-by test_comparator 2 3 4 5 6 9 1)

; keywords
(:str {:str 10 :dex 9 :wis 18})

;; Collections
(def a (str/split-lines (slurp "resources/people.txt")))

(type a)

(count a)

(def b (conj a "102,john,doe,doe@none.org,127.0.01"))

(count b)
;lazy sequence
(nth (iterate inc 0) 10000)