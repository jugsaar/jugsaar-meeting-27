#!/bin/sh

cat <<EOF > target/subfolder/Order/order_$(date "+%H:%M:%S").txt
  John Dilligence

  10 x part 4242
EOF
