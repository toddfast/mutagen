mutagen
=======

Mutagen is a lightweight framework for applying versioned changes to a resource, like a database, taking into account its existing state and only applying changes that haven't yet been applied.

Mutagen takes the general principals of database versioning from frameworks like Flyway and abstracts them so that they can be applied to virtually any resource, not just SQL-based databases. Thus, Mutagen can be used to version changes to SQL and no-SQL databases, files, cloud resources, machine configurations, workflows, or anything else whose state can be defined by a strictly ordered version history.

The original impetus for creating Mutagen was to manage schema versioning for Apache Cassandra. Please see the separate [Mutagen Cassandra](https://github.com/toddfast/mutagen-cassandra) project for that implementation.

Mutagen is written in Java 1.6 with no dependencies.

Using Mutagen
-------------

Mutagen (this project) is fairly limited by itself, providing mainly an API/SPI and some default implementations. See the unit tests for a simple use case with manually specified mutations.

To make better user of Mutagen, use one of its sub-projects (like [Mutagen Cassandra](https://github.com/toddfast/mutagen-cassandra)), or use it as the basis for writing your own resource mutation framework.

Concepts
--------

TBD

Entities
--------
TBD

