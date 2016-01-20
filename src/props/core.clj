(ns props.core
  (:require [clojure.java.io :as io])
  (:import [java.util Properties]))

(def ^:private resource-stream
  (comp io/input-stream io/resource))

(defn string-property-names [^Properties props]
  "Returns a set of keys in this property list where the key and its corresponding
   value are strings, including distinct keys in the default property list if a
   key of the same name has not already been found from the main properties list"
  (.stringPropertyNames props))

(defn from-map
  [props-map]
  ^{:doc "Sets and returns java.util.Properties from a Clojure map"}
  (let [properties (Properties.)]
    (doseq [[k v] props-map]
      (.setProperty properties (name k) (str v)))
  properties))

(defn load-props
  [properties-file-name]
  ^{:doc "Loads a properties file from the class path and returns as a java
          Properties object"}
  (with-open [stream (resource-stream properties-file-name)]
    (when ((complement nil?) stream)
      (doto (Properties.)
        (.load stream)))))

(defn load-kw-props
  [properties-file-name]
  ^{:doc "Same as load-props but will return the key as a keyword"}
  (let [props (load-props properties-file-name)]
    (into {}
      (for [[k v] props]
        [(keyword k) v]))))
