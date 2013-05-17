mutagen
=======

Mutagen is a lightweight framework for applying versioned changes (known as *mutations*) to a resource, like a database. Mutagen takes into account the resource's existing state and only applies changes that haven't yet been applied.

Mutagen takes the general principals of database versioning from frameworks like Flyway and abstracts them so that they can be applied to virtually any resource, not just SQL-based databases. Thus, Mutagen can be used to version changes to SQL and no-SQL databases, files, cloud resources, machine configurations, workflows, or anything else whose state can be defined by a strictly ordered versioning scheme.

The original impetus for creating Mutagen was to manage schema versioning for Apache Cassandra. Please see the separate [Mutagen Cassandra](https://github.com/toddfast/mutagen-cassandra) project for that implementation.

Mutagen is written in Java 1.6 with *no dependencies*.

Using Mutagen
-------------

Mutagen (this project) is fairly limited by itself, providing mainly an API/SPI and some default implementations. See the unit tests for examples of using Mutagen with a manually managed list of mutations.

To make better use of Mutagen, use one of its sub-projects (like [Mutagen Cassandra](https://github.com/toddfast/mutagen-cassandra)), or use it as the basis for writing your own resource-mutation framework. Happy mutating!

Core Entities
-------------

**Mutation**: A mutation is a single change that can be applied to a resource. It is described by a *state*. The actual work performed by a mutation is arbitrary and depends on the higher-level implementation using Mutagen. For example, mutations could be scripts, declarative statements, Java code, network calls, or anything else.

**State**: Every resource, called a *subject*, has a definite current state. States can be ordered relative to one another, allowing Mutagen to determine which states to apply (states > current state) and which to skip (states <= current state). Loosely, you may think of states as version numbers, but as long as they can be ordered, Mutagen doesn't require that states look anything like traditional version numbers.
    
**Subject**: The resource to mutate. Mutagen moves subjects through an ordered series of states by applying mutations. Typical examples would be a database schema, a file, a configuration, or anything else that can be changed in an orderly way.
    
**Plan**: A plan is an executable encapsulation of the mutations to be made to a particular subject.
    
**Planner**: A planner evaluates the current state of a subject, the available mutations, and creates a plan to mutate the subject to the desired state.
    
**Coordinator**: A coordinator decides when and if a mutation can be applied to a subject. For example, in a clustered environment, a coordinator may apply locking to ensure mutations are applied consistently.

