# BookRec 

This folder contains the implementation of BookRec. In order to run the tool, your computer should meet the following requirements.

## Requirements

  - Apache Maven >= 3.0
  - Java >= 1.8
  - (optional) Bash for running all evaluations automatically

## Running the tool
To start the evaluation of BookRec using the default `evaluation.properties` file (BookCrossingUB), run the following command:

```
mvn clean compile exec:java -Dexec.mainClass=recsys.BookRec.Runner
```
Please be aware that the execution of BookRec takes a long time. First, you need to wait some minutes until you see something running in your console. Afterwards, there are two phases: Computing similarities and producing recommendations. The former may take up to 4 hours depending on your computer's performance as well as the dataset you are experimenting with. Whereas the latter runs in a considerably shorter time, e.g., around half an hour. For instance, with the BookCrossing dataset, the similarity computation will finish after 3 hours and the recommendation phase finishes after 20 minutes.

## `evaluation.properties`
We use a evaluation`.properties` file to specify the root folder of BookRec. For instance, the default `evaluation.properties` performs evaluation on the BookCrossing dataset with ubCF:

```
# Root directory
sourceDirectory=../../BookRec/datasets/BookCrossingUB/

```
