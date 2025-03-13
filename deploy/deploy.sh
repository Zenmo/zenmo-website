
set -ex

source $(dirname "$0")/vars.sh

export TAG=$TAG

docker --context zenmoswarm \
    stack deploy \
    --compose-file deploy/compose.yaml \
    zenmo_website

