#!/bin/bash

for title in *.HTM; do
  name=$(basename "$title" .HTM)
  mv "$title" "$name.html"
done;