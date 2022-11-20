cat file.txt | awk 'FNR==10 {print $0}'
