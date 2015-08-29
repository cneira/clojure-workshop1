(ns repl-tutorial.functional-programming
  (:require [clojure.string :as str])
  )
; High order programming
; convert people.txt to a list of hashmaps using hofs
; first make it a seq

(def people (str/split-lines (slurp "resources/people.txt")))

(defn make-hash-person [row]
  (let [ [i f l e c i]  (str/split row #",")   ]
     (hash-map  :id i :first_name f :last_name l :email e :country c :ip_address i  )))


(map  make-hash-person   (rest people)  )

;reduce

(defn factorial [n]
  (reduce *' (range 1 (inc n))))


(reduce + [ 2 2 3])

; filter

(filter number? [ 1 "a" 3 4 5 6 "adasdf"])


(filter (fn [m] ()))


(def cars [ {:engine "V8" :model "camaro" :maker "Ford"} {:engine "V6" :model "Cherokee" :maker "Jeep"} {:engine "800c" :model "Alto" :maker "Suzuki"}])

(filter (fn [x] (= (:engine x) "V8")) cars)

(filter  #(= (:engine %)  "V8") cars)

(remove  #(= (:engine %)  "V8") cars)



