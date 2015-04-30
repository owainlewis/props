(ns props.core
  (:import [java.util Properties]))

(defn names [^Properties props]
  "Returns a set of keys in this property list where the key and its corresponding
   value are strings, including distinct keys in the default property list if a
   key of the same name has not already been found from the main properties list.

   Properties whose key or value is not of type String are omitted.
   The returned set is not backed by the Properties object.
   Changes to this Properties are not reflected in the set, or vice versa."
  (.stringPropertyNames props))

(defn property-names [^Properties props]
  "Returns an enumeration of all the keys in this property list,
   including distinct keys in the default property list if a key of the same
   name has not already been found from the main properties list."
  )

(defn with-props
  [props]
  "Sets and returns java.util.Properties from a Clojure map"
  (let [properties (Properties.)]
    (doseq [[k v] props]
      (.setProperty properties (name k) (str v)))
  properties))

(defn load-props [properties-file-name]
  )
