(ns repl-tutorial.Destructuring)

;Let’s define a vector like this :

(def v [1 2 3 4 5 "B" "C"])

;Now let’s start getting elements out of it:

(let [[a b c] v]
  (+ a b c))



;Let’s imagine you don’t want one of the elements of the collection when destructuring, you just skip it using _.


(let [[a b _ c] v]
  (+ a b c))



;Let’s define a vector as

(def v [1 2 3 [5 8 8 9]])

;Now let’s destructure the collection inside a collection

(let [[a b _ [f d e]] v]
  (+ f d e))


;But what happens if we have an associative data structure inside our sequential data structure?.
; Well the same rules for the sequential data structures applies, let’s see some examples :
;Again let’s define a vector as :


(def v [1 2 3 {:a 5 :b 7}])

;Now let’s get the data from the map

(let [[a b _ {x :a y :b}] v]
  (+ x y))

;Is the same as we did with a vector inside a vector,
; but this time we need to specify that we are going to destructure a map
; because the fourth element of our vector is a map data structure,
; and so we evaluate the keywords :a :b from the map to bind their values to the x and y symbol respectively,
; so x ends with the value 5 and y with the value 7.


;Destructuring Lists

;Let’s apply the same concepts to lists, so let’s define a list like the following :

(def l (list "apple" "pineapple" "papaya" [1 2]))

;Now let’s again take out values from this sequential data structure:


(let [[a b c] l]
  (str "I like" a "," "and a " c))


;As a list is a sequential collection all the same rules apply as with vectors
;symbols a, b and c are sequentially bound to the elements of the sequence,

;; we could destructure also nested data structures
(def l2 (list "apple" "pineapple" [ 1 2 3 4 [9 2]] "papaya"))

(let [ [ a b [ y _ _ _ [_ x ]] ] l2 ]

  (+ x y)
  )
; destructure a list
(def l3 (list "apple" "pineapple"  `( 1 2 3 4  ( 9 2)) "papaya"))

(let [ [ a b [ y _ _ _ [_ x ]] ] l3 ]

  (+ x y)
  )
; get the original collection
(let [ [ a b [ y _ _ _ [_ x ]] :as full ] l3 ]
  full)

; map destructuring

(def keldorn
  {
   :str 15
   :wis 10
   :dex 10
   :con 15
   :int 15
   :char 16
   :equipment
              {:righthand "carsomyr"
               :head "helm of balduran"
               :armor "plate mail"}
   :inventory ["health potion"
               "speed potion"  ]
   })

(let [ { str :str dex :dex } keldorn ]
  (clojure.core/str "keldorn has strength " str " and dex " dex)
  )


(let [ {  { righthand :righthand  head :head  armor :armor } :equipment  } keldorn ]
  (clojure.core/str "keldorn has equipped on his righthand "
                    righthand " " head
                    " is his helmet and he is wearing " armor))

(let [ { [_ x ] :inventory } keldorn]
        x)

(let [ { char :char :as k } keldorn]
   (println "char is " char "full sequence" k))

(let [ { x :class :or { x "paladin"} } keldorn ]
   x)

(defn f [x & rest ]
  (apply + x  rest))

(defn sayhi [ & [_ name]]
  (str "Hello " (or name (str "unknown")) " " )
  )

(defn sayhi2 [ & {:keys [name last job] :or { name "john" last "doe" job "none"} } ]
  (str "his name is " name " his last name is " last  " and his job is " job))


(defn sayhi3 [ {:keys [name last job] :or { name "john" last "doe" job "none"} } ]
  (str "his name is " name " his last name is " last  " and his job is " job))