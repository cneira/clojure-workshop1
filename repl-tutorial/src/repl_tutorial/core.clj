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
