# Props

A small Clojure library for working with java.util.Properties

## Usage

```clojure

(require [io.forward/props :refer :all])

(from-map { :protocol "ssl" :port 3000 } )
;; => java.util.Properties
```

## License

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
