# clj-aws-s3-localstack-demo

A trivial AWS S3 bucket access demo

## Access a real AWS S3 bucket in the cloud

Prerequisites:
* a real AWS S3 bucket in the cloud, obviously
* [AWS credentials](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) for accessing the bucket

For example, given a bucket called `my-bucket` in AWS region `eu-west-1`:
```sh
$ lein run eu-west-1 https://s3.eu-west-1.amazonaws.com my-bucket
Success! Bucket my-bucket exists and is accessible in region eu-west-1
```

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
