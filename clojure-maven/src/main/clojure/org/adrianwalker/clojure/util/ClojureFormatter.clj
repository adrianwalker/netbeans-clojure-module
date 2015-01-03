(ns org.adrianwalker.clojure.util.ClojureFormatter
  (:gen-class
    :name org.adrianwalker.clojure.util.ClojureFormatter
    :methods [#^{:static true} [prettyPrint [String] String]]))

(use '[clojure.pprint])

(defn prettyPrint [code]
  (with-out-str
    (with-pprint-dispatch code-dispatch (pprint code))))

(defn -prettyPrint [code]
   (def prettyCode (prettyPrint (read-string (str "(" code ")"))))
   (subs prettyCode 1 (- (count prettyCode) 2)))