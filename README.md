# Props

A small Clojure library for working with java.util.Properties

## Usage

```clojure

(require [io.forward/props :as props])

(def properties
  (with-props
    {:host "http://localhost"
	 :port 8080}))


```

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
