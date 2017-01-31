#!/bin/sh

cat <<EOF > target/subfolder/Order/order_$(date "+%H:%M:%S").txt
  John Lazy

  2 x module 12345
EOF
