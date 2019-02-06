
# BookRec

This repository contains the source code implementation of BookRec and the datasets for our paper submitted to ECNLP2019:

_Memory-based collaborative-filtering techniques: A case study with online books_

## Introduction

BookRec is a collaborative-filtering recommender system that provides readers with recommendation of books that are relevant to their preferences.

We evaluate two CF techniques to build a book recommender system. In particular, we conduct an empirical study using two datasets: BookCrossing and Goodbooks. To thoroughly study the performance, we make use of different quality indicators, i.e., accuracy(precision, recall, and nDCG), diversity (entropy, coverage), and novelty (EPC). Eventually, we obtained some _serendipitous_ outcomes. In contrast to many existing studies, we found out that compared to the user-based collaborative-filtering technique (ubCF), the item-based collaborative-filtering technique (ibCF) does not always have a superior performance as it has been usually perceived. Our experimental results show that the performance of the two techniques very much depends on the characteristics of the datasets as well as the sparsity of the user-item matrix. 

## Repository Structure

This repository is organized as follows:

* The [tool](./tool) directory contains the implementation of the BookRec tool written in Java:
* The [datasets](./dataset) directory contains the 4 datasets described in the paper and their corresponding working directories as follows:
	* [BookCrossingIB](./datasets/BookCrossingIB): metadata and working folders for the BookCrossing dataset used with ibCF
	* [BookCrossingUB](./datasets/BookCrossingUB): metadata and working folders for the BookCrossing dataset used with ubCF
	* [GoodbooksIB](./datasets/GoodbooksIB): metadata and working folders for the Goodbooks dataset used with ibCF
	* [GoodbooksIB](./datasets/GoodbooksIB): metadata and working folders for the Goodbooks dataset used with ubCF

## `evaluation.properties`
We use a `.properties` file to specify the root folder of BookRec. For instance, the default `evaluation.properties` performs evaluation on the BookCrossing dataset with ubCF:

```
# Root directory
sourceDirectory=<root>/BookRec/datasets/BookCrossingUB/

```
You need to replace `<root>` with the directory where you have cloned the BookRec repo from GitHub, for example: `/home/admin/Desktop/` 

