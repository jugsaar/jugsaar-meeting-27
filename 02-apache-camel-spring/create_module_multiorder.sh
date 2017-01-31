#!/bin/sh

cat <<EOF > target/subfolder/Order/order_$(date "+%H:%M:%S").txt
  John Lazy

  2 x module 111
  1 x module 222

  5 x module 333
  3 x module 444
EOF
