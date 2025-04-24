#!/bin/bash

set -ex

source $(dirname "$0")/vars.sh

cd $(dirname "$0")/..

docker build \
    --file deploy/Dockerfile \
    --tag $TAG \
    --progress=plain \
    .
