(defproject peer "0.4.0"
  :description "P2P - Clojure(Script) style"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.516"]
                 [org.clojure/core.async "0.4.490"]
                 [io.pedestal/pedestal.interceptor "0.5.2"]
                 [com.taoensso/timbre "4.10.0"]
                 [http-kit "2.3.0"]
                 [jarohen/chord "0.8.1" :exclusions [org.clojure/tools.reader
                                                     com.cognitect/transit-cljs
                                                     com.cognitect/transit-clj]]
                 [ring/ring-defaults "0.2.3"]
                 [bidi "2.0.16"]
                 [stylefruits/gniazdo "1.0.1"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [com.cognitect/transit-cljs "0.8.256"]]

  :source-paths ["src/clj" "src/cljs"]

  :plugins [[s3-wagon-private "1.3.0"]]

  :profiles {:test {:dependencies []}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "" "--no-sign"] ; disable signing
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :clean-targets ^{:protect false} [:target-path "figwheel_server.log" "resources/public/js/test/"])
