(ns repl-tutorial.core
  (:gen-class)
  (:require [clojure.string :as str])
  )



(def  a  (str/split-lines (slurp  "resources/persons.txt") ))

(defn  return-names [file]
  (for [x (rest file ) ]
    (let [ fields   (str/split x #",")]
      (fields 1))))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
