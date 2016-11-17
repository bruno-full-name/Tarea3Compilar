sudo chmod +x -R ant
./ant/bin/ant -q -S -buildfile build.xml clean
read -p "Ingrese la ruta completa del la JDK: " jdk
export JAVA_HOME=$jdk
alias JAVA_HOME=$jdk
./ant/bin/ant -q -buildfile build.xml jar
