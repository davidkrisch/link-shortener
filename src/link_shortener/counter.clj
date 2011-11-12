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

(defn n [s]
  (loop [f (allButLast s)
         l (nextInAlpha (last s))
         acc ""]
    (if (not= l "0")
      (str f l acc)
      (recur (allButLast f) (nextInAlpha (last f)) (str l acc)))))
