(ns clj-aws-s3-localstack-demo.core
  (:gen-class)
  (:import [com.amazonaws.client.builder AwsClientBuilder$EndpointConfiguration]
           [com.amazonaws.services.s3 AmazonS3Client AmazonS3ClientBuilder]
           [com.amazonaws.services.s3.model HeadBucketRequest]))

(defn -main
  "Checks if the bucket can be accessed"
  [& args]
  (let [region                 "eu-west-1"
        endpoint               (str "https://s3.eu-west-1.amazonaws.com")
        bucket                 "clj-aws-s3-localstack-demo-bucket"
        ^AmazonS3Client client (-> (AmazonS3ClientBuilder/standard)
                                   (.enablePathStyleAccess)
                                   (.withEndpointConfiguration (AwsClientBuilder$EndpointConfiguration. endpoint region))
                                   (.build))
        bucket-region (->> bucket
                           (HeadBucketRequest.)
                           (.headBucket client)
                           (.getBucketRegion))]
    (println "Success! Bucket" bucket "exists and is accessible in region" bucket-region)))
