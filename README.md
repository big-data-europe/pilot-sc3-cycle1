The pilot is carried out by CRES in the frame of SC3 Secure, Clean and Efficient Energy.

The pilot demonstrates the following workflow: a developer in the field of wind energy enhances

condition monitoring for each unit in a wind farm by pooling together data from multiple units from

the same farm (to consider the cluster operation in total) and third party data (to perform correlated

assessment). The custom analysis modules created by the developer use both raw data and the

outputs of built-in analysis modules. The following datasets are involved:

● Raw sensor and SCADA data from a given wind farm

● Third-party raw or synthetic data

● Analysis results from built-in analysis modules

All data is in custom binary or ASCII formats. ASCII files contain a metadata header and in

tabulated form the signal data (signal in columns, time sequence in rows). All data is annotated

by location, time, and system id. The following processing is carried out:

● Near-real time execution of parametrized models to return operational statistics,

● Weekly execution of operational statistics

● Weekly execution of model parametrization

The following outputs are made available for visualization or further processing:

● Operational statistics, near-real time and weekly

● Model parameters

including correlation analysis of data across units


