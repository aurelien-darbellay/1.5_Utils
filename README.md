__Commands I use to compile and execute the program__

# Nivell 1

## Ex 1

From root/N1/src/main/java

_Compile_: javac org/example/Main.java\
_Execute_: java org.example.Main ex1 \<pathToExplore>

The program then list the items (files and folders) in \<pathToExplore> and show them in the terminal ordered
alphabetically.

## Ex 2

From root/N1/src/main/java

_Compile_: javac org/example/Main.java\
_Execute_: java org.example.Main ex2 \<pathToExplore>

The programme then creates the tree of the content of \<pathToExplore> and show it in the terminal, together with info
on the nature (file or folder) of the item and their last modification.

## Ex 3

From root/N1/src/main/java

_Compile_: javac org/example/Main.java\
_Execute_: java org.example.Main ex3 \<pathToExplore> \<target.txt>

The programme then creates the tree of the content of \<pathToExplore> and write it in \<target.txt>, together with info
on the nature (file or folder) of the item and their last modification.

## Ex 4

From root/N1/src/main/java

_Compile_: javac org/example/Main.java\
_Execute_: java org.example.Main ex3 \<pathToRead.txt>

The programme reads the file at the path and then print it on the terminal.

## Ex 5

From root/N1/src/main/java

_Compile_: javac org/example/Main.java\
_Execute_: java org.example.Main ex3 <idObjectToSerialize(String)> <wordObjectToSerialize(String)> <
numObjectToSerialize(String)>

The programme create a serializable object, serialize it, recover it and print it to the terminal. 

