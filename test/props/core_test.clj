(ns props.core-test
  (:require [clojure.test :refer :all]
            [props.core :refer :all]))

(deftest reading-properties-test
  (testing "Should read a properties file from the class path"
    (println (load-props "mongo.properties"))))

(deftest properties-from-map-test
  (testing "Should create a new java Properties object from a clojure Map"
    (let [properties {:host "http://localhost"
                      :port 8080}]
      (println (from-map properties)))))
