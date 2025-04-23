
set -ex

source $(dirname "$0")/vars.sh

docker build \
    --file deploy/Dockerfile \
    --tag $TAG \
    --progress=plain \
    .
