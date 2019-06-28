
# BookRec

This repository contains the source code implementation of BookRec and the datasets for our paper submitted to FAiSE 2019:

_Building a flexible information system to support booklovers: A case study with collaborative-filtering recommendation techniques_

## Introduction

BookRec is a collaborative-filtering recommender system that provides readers with recommendation of books that are relevant to their preferences.

We evaluate two CF techniques to build a book recommender system. In particular, we conduct an empirical study using two datasets: BookCrossing and Goodbooks. To thoroughly study the performance, we make use of different quality indicators, i.e., accuracy (precision, recall, and nDCG), diversity (entropy, coverage), and novelty (EPC). Eventually, we obtained some _serendipitous_ outcomes. In contrast to many existing studies, we found out that compared to the user-based collaborative-filtering technique (ubCF), the item-based collaborative-filtering technique (ibCF) does not always have a superior performance as it has been usually perceived. Our experimental results show that the performance of the two techniques very much depends on the characteristics of the datasets as well as the sparsity of the user-item matrix. 

## Repository Structure

This repository is organized as follows:

* The [tool](./tool/BookRec/) directory contains the implementation of the BookRec tool written in Java:
* The [datasets](./dataset) directory contains the 4 datasets described in the paper and their corresponding working directories as follows:
	* [BookCrossingIB](./datasets/BookCrossingIB): metadata and working folders for the BookCrossing dataset used with ibCF
	* [BookCrossingUB](./datasets/BookCrossingUB): metadata and working folders for the BookCrossing dataset used with ubCF
	* [GoodbooksIB](./datasets/GoodbooksIB): metadata and working folders for the Goodbooks dataset used with ibCF
	* [GoodbooksUB](./datasets/GoodbooksUB): metadata and working folders for the Goodbooks dataset used with ubCF


## How to cite
If you find our work useful for your research, please cite the paper using the following BibTex entry:

```
@InProceedings{10.1007/978-3-030-20948-3_19,
	author={Nguyen, Phuong T. and {Di Rocco}, Juri and {Di Ruscio}, Davide}, 
	editor="Proper, Henderik A. and Stirna, Janis",
	title={{Building Information Systems Using Collaborative-Filtering Recommendation Techniques}},
	booktitle={Advanced Information Systems Engineering Workshops},
	year={2019},
	publisher={Springer International Publishing},
	address={Cham},
	pages={214--226},	
	isbn={978-3-030-20948-3}
}

```
