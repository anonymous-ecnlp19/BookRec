# BookRec 

This folder contains the implementation of BookRec. 
Please be aware that the execution of BookRec takes a long time. First, you need to wait some minutes until you see something running. Afterwards, the similarity computation may take up to 4 hours. For instance, with the BookCrossing dataset, the similarity computation will finish after 3 hours.
## Requirements

  - Apache Maven >= 3.0
  - Java >= 1.8
  - (optional) Bash for running all evaluations automatically

## Running the tool
To start the evaluation of BookRec using the default `evaluation.properties` file (BookCrossingUB), run the following command:

```
mvn clean compile exec:java -Dexec.mainClass=recsys.BookRec.Runner
```

## `evaluation.properties`
We use a evaluation`.properties` file to specify the root folder of BookRec. For instance, the default `evaluation.properties` performs evaluation on the BookCrossing dataset with ubCF:

```
# Root directory
sourceDirectory=../../BookRec/datasets/BookCrossingUB/

```
