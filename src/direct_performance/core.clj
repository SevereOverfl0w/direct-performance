(ns direct-performance.core
  (:require
    [criterium.core :as c]))

(defn a
  [n]
  (inc n))

(def b #(a %))
(def c a)

(defn -main
  [& _]
  (println "=== Indirect (def b #(a %))")
  (c/bench (b 200))
  
  (println "=== Direct (def c a)")
  (c/bench (c 200)))
