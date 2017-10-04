# Java Module Basics

## Create a java module
1. Create a directory for module: `com.mymodule`
2. Module name and directory name must be same
3. Module name are kept same as package name but this is not mandatory
4. Create a module-info.java on directory name with module declartion

## Write some code for module
1. Create a package to add some code. If you follow convention per se, package name and module name will be kind of same: `com.mymodule`
2. Create a class and add some codes to run: `MyModule.java`

## Compile and run the code
1. To run the code use `run.sh`. To use it do
`./run.sh com.mymodule MyModule`