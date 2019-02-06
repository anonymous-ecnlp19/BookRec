# FOCUS

This folder contains the implementation of BookRec. 

## Requirements

  - Apache Maven >= 3.0
  - Java >= 1.8
  - (optional) Bash for running all evaluations automatically

## Running the tool
To start the evaluation of BookRec using the default `evaluation.properties` file (see below), run the following command:

```
mvn clean compile exec:java -Dexec.mainClass=recsys.BookRec.Runner
```

