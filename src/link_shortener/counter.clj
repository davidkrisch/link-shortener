(ns link-shortener.counter)

(def 
  ^{:private true}
  alpha "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

(def alpha-length (.length alpha))

(defn allButLast [s]
  (if (= (.length s) 0)
    ""
    (.substring s 0 (- (.length s) 1))))

(defn nextInAlpha [c] 
  (let [index (inc (.indexOf alpha (str c)))
        index (if (= alpha-length index) 0 index)]
    (str (.charAt alpha index))))

(defn incrementCount [count]
  (loop [f (allButLast count)
         l (nextInAlpha (last count))
         acc ""]
    (if (not= l "0")
      (str f l acc)
      (recur (allButLast f) (nextInAlpha (last f)) (str l acc)))))

(def
  ^{:doc "Ref to store the next value of the sequence"
    :private true} 
  curVal (ref "0"))

(defn get-shortened-link []
  (dosync []
    (let [to-return (str @curVal)]
      (alter curVal incrementCount)
      to-return)))

