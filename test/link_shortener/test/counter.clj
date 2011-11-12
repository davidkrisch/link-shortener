(ns link-shortener.test.counter
  (:use [link-shortener.counter])
  (:use clojure.test))

(deftest test_nextInAlpha
  (is (= (nextInAlpha "z") "A") "Should have been A.")
  (is (= (nextInAlpha "Z") "0") "Should have been 0.")
  (is (= (nextInAlpha "0") "1") "Should have been 1.")
  (is (= (nextInAlpha \Z) "0") "Didn't handle char correctly.")
  (is (= (nextInAlpha "") "1") "Didn't handle emptry string correctly."))

(deftest test_allButLast 
  (is (= (allButLast "asdf") "asd") "Why didn't it return asd?")
  (is (= (allButLast "a") "") "This shouldn't return anything.")
  (is (= (allButLast "") "") "This shouldn't return anything.")) 

(deftest test_multichar
  (is (= (n "ab") "ac") "Why didn't it return ac?")
  (is (= (n "Z") "10") "Why didn't it return 10?")
  (is (= (n "ZZ") "100") "Why didn't it return 100?")
  (is (= (n "zZ") "A0") "Why didn't it return A0?")
  (is (= (n "asdfZZ") "asdg00") "Why didn't it return asdg00?"))
