(ns repl-tutorial.core
  (:gen-class)
  (:require [clojure.string :as str])
  )
;;repl tutorial
(def  a  (str/split-lines (slurp  "resources/persons.txt") ))

(defn  return-names [file]
  (for [x (rest file ) ]
    (let [ fields   (str/split x #",")]
      (fields 1))))

(defn return-only-name [name file]
  (for [x (rest file )
        :let  [person-name ( (str/split x #",")  1) ]
        :when (= name  person-name )
        ]
    (str x )
    ))


(defn map-person-by-name [name file]
  (let [v {}]
         (for [x (rest file )   r  (str/split x #",")
               :let  [person-name ( (str/split x #",")  1) ]
               :when (= name  person-name )
               ]
           (conj v { :name person-name :address (r 2)})
           )

         )

  )

(doall (range 1 (inc (count a ))))

(defn map-person [p]
  {:name (p 1) :last_name (p 2) :email (p 3) :country (p 4) :ip (p 5)}
  )







;;  data structures

;; hash map
( {:str 13 :char 10  :dex  20 :wis 8   }  :str )
(list 1 2 3 'x 't 's 'g )

;;Vectors, maps, sets are collections. All Clojure collections are immutable, they are persistent. All collections support count, conj, and seq.
;;• count – returns the number of items in a collection.
;;• conj – add items to the collection; where the item is added depends on the collection type.
;;• seq – returns a seq on the collection; if the collection is empty returns nil.

(count a)
(seq a)
;if statement
(if (true?  nil ) "yes"  "no"  )
;do
(do "cat" "mouse" "trap" "poison")

;;let
(let [ cat "tom" mouse "jerry"  ]

    (let [ watcher "bill" ]

        (println  watcher "knows about " cat mouse)
      )
  )


(quote (+ 1 2 ))


(def f (fn [x] (str/split x #",")))

(def pm ( map map-person (map f a ) ))

(defn f
  ([x] ( + 30 x ))
  ([ x y ]  ( * x y )))


