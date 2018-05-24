# clj-aws-s3-localstack-demo

A trivial AWS S3 bucket access demo

You'll need [Leiningen](https://leiningen.org/) to run this.

## Access a real AWS S3 bucket in the cloud

Prerequisites:
* a real AWS S3 bucket in the cloud, obviously
* [AWS credentials](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) for accessing the bucket

For example, given a bucket called `my-bucket` in AWS region `eu-west-1`:
```sh
$ lein run eu-west-1 https://s3.eu-west-1.amazonaws.com my-bucket
Success! Bucket my-bucket exists and is accessible in region eu-west-1
```

## Create and access a local S3 bucket on [LocalStack](https://github.com/localstack/localstack)

Prerequisites:
* [Docker](https://www.docker.com/community-edition)
* Eg. [AWS CLI](https://aws.amazon.com/cli) for creating your bucket

```sh
# Start LocalStack S3 service in Docker, exposing it to host on port 4572
$ CONTAINER_ID=$(docker run -d -e "SERVICES=s3" -p 4572:4572 --rm localstack/localstack)

# Create my-bucket
$ aws --endpoint-url="http://localhost:4572" s3 mb "s3://my-bucket"
make_bucket: my-bucket

# See if it works
$ lein run region-does-not-matter http://localhost:4572 my-bucket
Success! Bucket my-bucket exists and is accessible in region nil

# Stop the Docker container
$ docker stop $CONTAINER_ID
```

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
