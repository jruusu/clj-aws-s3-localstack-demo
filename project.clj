(defproject clj-aws-s3-localstack-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[com.amazonaws/aws-java-sdk-s3 "1.11.313"]
                 [org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot clj-aws-s3-localstack-demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
