(ns org.adrianwalker.clojure.util.ClojureFormatter
  (:gen-class
    :name org.adrianwalker.clojure.util.ClojureFormatter
    :methods [#^{:static true} [prettyPrint [String] String]]))

(use '[clojure.pprint])

(defn prettyPrint [code]
  (with-out-str
    (with-pprint-dispatch code-dispatch (pprint code))))

(defn -prettyPrint [s]
  (def codeVector (read-string (str "[" s "]")))
  (def prettyCode "")
  (doseq [code codeVector]
    (if (> (count prettyCode) 0)
      (def prettyCode (str prettyCode "\n")))
    (def prettyCode (str prettyCode (prettyPrint code))))
  prettyCode
)
