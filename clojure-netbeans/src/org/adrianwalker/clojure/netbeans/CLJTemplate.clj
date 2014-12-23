(ns org.adrianwalker.clojure.FizzBuzz
  (:gen-class))

(defn fizzbuzz [from to]
  (when (<= from to)
    (def fizz (mod from 3))
    (def buzz (mod from 5))
    (print from "")
    (if (= 0 fizz) (print "fizz"))
    (if (= 0 buzz) (print "buzz"))
    (println)
    (recur (inc from) to)))

(defn -main [& args]
  (fizzbuzz 1 15))