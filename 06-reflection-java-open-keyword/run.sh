#!/bin/sh

rm -rf mods

moduleName=$1
mainFile=$2
sourceDir=${3:-src}
moduleCompileDir=${4:-mods}

if [ -z "$moduleName" ]; then
    echo "ERROR: Call syntax \n ./run.sh module.name MainClass \n ./run.sh module.name full.package.MainClass"
    exit 0
fi

# compiles all the modules in mods directory
echo "javac -d $moduleCompileDir --module-path ./jars/ --module-source-path $sourceDir \$(find $sourceDir -name \"*.java\")"
javac -d $moduleCompileDir --module-path ./jars/ --module-source-path $sourceDir $(find $sourceDir -name "*.java") 


# Given module name and main class file you run the application
if [[ $mainFile == *"."* ]]; then
    echo "java --module-path ./jars/:$moduleCompileDir -m $moduleName/$mainFile"
    echo "\n--- OUTPUT ---"
    java --module-path ./jars/:$moduleCompileDir -m $moduleName/$mainFile
else
    echo "java --module-path ./jars/:$moduleCompileDir -m $moduleName/$moduleName.$mainFile"
    echo "\n--- OUTPUT ---"
    java --module-path ./jars/:$moduleCompileDir -m $moduleName/$moduleName.$mainFile
fi