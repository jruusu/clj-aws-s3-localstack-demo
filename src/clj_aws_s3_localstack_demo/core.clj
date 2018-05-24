(ns clj-aws-s3-localstack-demo.core
  (:require [clojure.string :as string])
  (:import (com.amazonaws.client.builder AwsClientBuilder$EndpointConfiguration)
           (com.amazonaws.services.s3 AmazonS3Client
                                      AmazonS3ClientBuilder)
           (com.amazonaws.services.s3.model HeadBucketRequest))
  (:gen-class))

(defn -main
  "Checks if the bucket can be accessed"
  [& [region endpoint bucket]]
  (if (and region endpoint bucket)
    (let [^AmazonS3Client client (-> (AmazonS3ClientBuilder/standard)
                                     (.enablePathStyleAccess)
                                     (.withEndpointConfiguration (AwsClientBuilder$EndpointConfiguration. endpoint region))
                                     (.build))
          bucket-region (->> bucket
                             (HeadBucketRequest.)
                             (.headBucket client)
                             (.getBucketRegion))]
      (println "Success! Bucket" bucket "exists and is accessible in region" bucket-region))
    (->> ["Usage: lein run [region] [s3-endpoint-url] [s3-bucket-name]"
          ""
          "Example: lein run eu-west-1 https://s3.eu-west-1.amazonaws.com my-bucket"]
         (string/join \newline)
         (println))))
