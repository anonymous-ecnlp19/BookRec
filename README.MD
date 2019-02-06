
# BookRec

This repository contains the source code implementation of BookRec and the datasets for our paper submitted to ECNLP2019:

_Memory-based collaborative-filtering techniques: A case study with online books_

## Introduction

BookRec is a collaborative-filtering recommender system that provides readers with recommendation of books that are suitable for the needs.

## Repository Structure

This repository is organized as follows:

* The [tools](./tools) directory contains the implementation of the BookRec tool written in Java:
* The [datasets](./dataset) directory contains the datasets described in the paper that we use to evaluate FOCUS:
	* [BookCrossingIB](./datasets/BookCrossingIB): metadata and working folders for the BookCrossing dataset used with ibCF
	* [BookCrossingUB](./datasets/BookCrossingUB): metadata and working folders for the BookCrossing dataset used with ubCF
	* [GoodbooksIB](./datasets/GoodbooksIB): metadata and working folders for the Goodbooks dataset used with ibCF
	* [GoodbooksIB](./datasets/GoodbooksIB): metadata and working folders for the Goodbooks dataset used with ubCF

## `evaluation.properties`
The evaluation of FOCUS is configured with a `.properties` file that specifies the root folder (i) the dataset (ii) the configuration and (iii) the validation technique to be used. For instance, the default `evaluation.properties` performs evaluation on the BookCrossing dataset with ubCF:

```
# Root directory
sourceDirectory=<root>/BookRec/datasets/BookCrossingUB/

```
You need to replace <root> with the directory where you have cloned the BookRec repo from GitHub, for example: `/home/admin/Desktop/` 

