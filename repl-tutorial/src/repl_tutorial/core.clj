(ns repl-tutorial.core
  (:gen-class)
  (:require [clojure.string :as str])
  )



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
    (println x )
    ))

